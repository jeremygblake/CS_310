import java.util.Scanner;

public class CreateAndPrintStaff
{

  final int maxStaff = 3;
  int currentStaff;


  static Scanner in = new Scanner(System.in);


  public static void main(String[] args)
  {
    StaffMember staffMembers = new StaffMembers[maxStaff];
    boolean flag = true;
    currentStaff = 0;


    while(flag)
    {
      printMenu();


      int selection = in.nextInt();

      switch(selection)
      {
        case 1 :
          System.out.println("");
          createStaff();
          break;

        case 2 :
          System.out.println("");
          break;

        case 3 :
          flag = false;
          break;

        default :
          System.out.println("Inproper Input");
          continue;
      }
    }
  }

  public static void createStaff()
  {
    if(currentStaff == maxStaff)
    {
      System.out.println("Reached Staff Limit of: " + maxStaff);
      return;
    }

    printCreateStaffMenu();
    int staffType;
    staffType = in.nextInt();
    switch(staffType)
    {
      case 1:
        break;

      case 2:
        break;

      case 3:
        break;

      default:
        System.out.println("Inproper Input");
        break;
    }


  }


  public static void printCreateStaffMenu()
  {
    System.out.println("What Type of Staff:\n\n[1]     Volunteer\n\n[2]     Executive\n\n[3]     Hourly");
  }

  public static void printMenu()
  {
    System.out.println("Welcome Enter Option to Continue:\n\n[1]     Create Staff Member\n\n[2]     Print Staff Members\n\n[3]     Exit");
  }

}
