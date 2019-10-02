import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;



public class StudentRegistration
{
  public static void main(String[] args) throws FileNotFoundException, IOException
  {
    FileReader      file = new FileReader("Records.txt");
    BufferedReader  br = new BufferedReader(file);

    Scanner         in = new Scanner(System.in);
    StudentInfo[]   enrolledStudents = null;
    String          record = "";
    QueueArray      queue = null;

    int i = 0;
    while(br.readLine() != null)
    {
      i++;
    }
    br.reset();
    String[] nameThenId;
    StudentInfo[] si_arr = new StudentInfo[i];
    for(int j = 0; j < i; j++)
    {
      nameThenId = record.split(" ", 2);
      si_arr[j] = new StudentInfo(nameThenId[0], Integer.parseInt(nameThenId[1]));
    }

    System.out.println("Enter number of seats in the class: ");
    int seats = in.nextInt();

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
          continue;
      }
    }
  }
  public static void printStudents(StudentInfo[] enrolledStudents, QueueArray studentQueue)
  {
    System.out.println("======= Enrolled Students ========");


    for(int i = 0; i < enrolledStudents.length; i++)
    {
      System.out.println(" REDID: " + enrolledStudents[i].getRedID() + " Name: " + enrolledStudents[i].getName());
    }

    System.out.println("======= Wait List =======");

    StudentInfo tmp = null;

    for(int i = 0; i < studentQueue.size(); i++)
    {
      tmp = studentQueue.dequeue();
      System.out.println(" REDID: " + tmp.getRedID() + " Name: " + tmp.getName());
      studentQueue.enqueue(tmp);
    }
  }


  public static void dropStudent(StudentInfo[] enrolledStudents, QueueArray queue)
  {
    System.out.println("Students REDID: ");
    Scanner in = new Scanner(System.in);
    int inID = in.nextInt();

    int x;
    for (x = 0; x < enrolledStudents.length; x++)
    {
      if (enrolledStudents[x].getRedID() == inID)
      {
        System.out.println(enrolledStudents[x].getName() + " removed from class");
        enrolledStudents[x] = queue.dequeue();
        return;

      }
    }
    System.out.println("STUDENT NOT FOUND");

  }

}
