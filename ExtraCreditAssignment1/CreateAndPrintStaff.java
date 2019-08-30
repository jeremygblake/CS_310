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

      try{

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
            System.out.println("");
            break;

          case 4 :
            flag = false;
            break;

          default :
            continue;
        }


      }catch(Exception e)
      {
        e.printStackTrace();

        System.out.print("System Error Try Again");

      }

    }
  }




  public static void printMenu()
  {
    System.out.println("Select an Option (type number and hit enter):\n\n[1] Add Staff Members\n\n[2] Remove Staff Members\n\n[3] Print Staff Members\n\n[4] Exit");
  }

}
