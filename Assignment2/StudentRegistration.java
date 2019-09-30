import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class StudentRegistration implements QueueInterface
{
  public static void main(String[] args)
  {
    File file = new File("Records.txt");
    if(!file.exists() && !file.isDirectory())
    {
      throw FileNotFoundException();
    }
    Scanner fileIn = new Scanner(file);
    Scanner sysIn = new Scanner(System.in);
    System.out.print("Enter the number of available seats in your class: ");
    int tmp = sysIn.nextInt();
    String record = "";

    while((record = fileIn.readLine()) != null)
    {
      //TODO: split and push records

    }


  }
}
