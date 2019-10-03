import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentRegistration
{
  private static int numberEnrolled = 0;

  public static void main(String[] args) throws FileNotFoundException, IOException
  {
    File            file              = new File("Records.txt");    //input file  used mostly to take the length()/bytes of the file to input into the mark method
    FileReader      fr                = new FileReader(file);      //sets file reader for stream
    BufferedReader  br                = new BufferedReader(fr);
    int             seats             = 0;
    Scanner         in                = new Scanner(System.in);
    StudentInfo[]   enrolledStudents  = null;
    StudentInfo[]   si_arr;
    String          record            = "";
    QueueArray      queue             = null;
    String[]        nameThenId;


    br.mark((int)file.length() + 1);          //marks the buffered Reader with

    while((record = br.readLine()) != null)   //checks the number of lines in the file to initialize an array to hold the records
    {
      numberEnrolled++;
    }
    br.reset();                               //resets the bufferedReader
    si_arr = new StudentInfo[numberEnrolled];

    for(int j = 0; j < numberEnrolled; j++)
    {
      record = br.readLine();
      nameThenId = record.split(" ", 2);              //splits the string into a 2 string array  that is then fed into the constructor for studentinfo
      si_arr[j] = new StudentInfo(nameThenId[0], Integer.parseInt(nameThenId[1]));
    }
    br.close();
    fr.close();

    System.out.println("Enter number of seats in the class: ");
    seats = in.nextInt();

    enrolledStudents = new StudentInfo[seats];

    int count = 0;
    while(count < si_arr.length && count < enrolledStudents.length)
    {
      enrolledStudents[count] = si_arr[count];
      count++;
    }
    if(si_arr.length > enrolledStudents.length)
    {
      queue = new QueueArray(si_arr.length - count);
      for(int x = count; x < si_arr.length; x++)
      {
        queue.enqueue(si_arr[x]);
      }
    }
    while(true)
    {
      System.out.println("Enter Corresponding number: \n\n[1] Remove Enrolled Student by ID \n\n[2] Print Enrolled Student \n\n[3] Exit");
      int ans = in.nextInt();

      switch(ans)
      {
        case 1:
          dropStudent(enrolledStudents, queue);
          break;

        case 2:
          printStudents(enrolledStudents, queue);
          break;

        case 3: return;

        default:
          System.out.println("not an option try again");
          break;
      }
    }
  }
  public static void printStudents(StudentInfo[] enrolledStudents, QueueArray studentQueue)
  {
    System.out.println("======= Enrolled Students ========");

    int min = enrolledStudents.length;
    if(min > numberEnrolled){min = numberEnrolled;}

    for(int i = 0; i < min; i++)
    {
      System.out.println(" REDID: " + enrolledStudents[i].getRedID() + " Name: " + enrolledStudents[i].getName());
    }

    System.out.print("\n\n");
    System.out.println("======= Wait List =======");
    if(studentQueue == null || studentQueue.isEmpty())
    {
      System.out.println("Empty");
      System.out.print("\n\n");
      return;
    }
    System.out.print("test");
    StudentInfo tmp = null;

    for(int i = 0; i < studentQueue.size(); i++)
    {
      tmp = studentQueue.dequeue();
      System.out.println(" REDID: " + tmp.getRedID() + " Name: " + tmp.getName());
      studentQueue.enqueue(tmp);
    }
    System.out.print("\n\n");
  }
  public static void dropStudent(StudentInfo[] enrolledStudents, QueueArray queue)
  {
    System.out.println("Students REDID: ");
    Scanner in = new Scanner(System.in);
    int inID = in.nextInt();

    int x;
    for (x = 0; x < enrolledStudents.length; x++)
    {
      if (enrolledStudents[x].getRedID() == inID)                               //checks for matching ID
      {
        System.out.println(enrolledStudents[x].getName() + " removed from class");
        if(queue == null || queue.isEmpty())
        {
          for(int i = x; i < numberEnrolled - 1; i++)
          {
            enrolledStudents[i] = enrolledStudents[i+1];               //if the queue is empty then we need to adjust the enrolled studetents array and not just replace
          }
          numberEnrolled--;                                           //subtracts the enrolled amount to keep the logic safes
          return;
        }
        else
        {
          enrolledStudents[x] = queue.dequeue();                          //sets the next queue element into the dropped students spot
          System.out.println(enrolledStudents[x].getName() + " added");
          return;
        }
      }
    }
    System.out.println("STUDENT NOT FOUND");
  }
}
