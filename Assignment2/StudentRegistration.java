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
    QueueArray      queue;

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
        //delete student
          break;

        case 2:
        //print students
          break;

        case 3: return;

        default:
          System.out.println("not an option try again");
          continue;
      }
    }
  }
}
