import java.util.Scanner;

public class CreateAndPrintStaff
{


  public static void main(String[] args)
  {


    Scanner in = new Scanner(System.in);
    boolean flag = true;

    while(flag)
    {
      printMenu();


      int selection = in.nextInt();

      switch(selection)
      {
        case 1 :
          System.out.println("");
          break;

        case 2 :
          System.out.println("");
          break;

        case 3 :
          flag = false;
          break;

        default :
          continue;
      }

    }
  }

  public static createStaff()
  {

  }


  public static void printMenu()
  {
    System.out.println("Welcome Enter Option to Continue:\n\n[1]     Create Staff Member\n\n[2]     Print Staff Members\n\n[3]     Exit");
  }

}
