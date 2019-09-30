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


    int i = 0;
    while((record = br.readLine()) != null && )
    {
      String[] nameThenId = record.split(" ", 2);
      si_arr[i] = new StudentInfo(nameThenId[0], Integer.parseInt(nameThenId[1]));
    }

    System.out.println("Enter number of seats in the class: ");
    int seats = in.nextInt();
    





  }
}
