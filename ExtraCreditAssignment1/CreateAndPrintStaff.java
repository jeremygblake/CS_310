import java.util.Scanner;

public class CreateAndPrintStaff
{
  StaffMember[] staffMembers = new StaffMember[9];
  static final int totalStaff;

  static final int maxOfEachStaff     = 3;
  static       int currentVolunteers;
  static       int currentHourly;
  static       int currentExecutive;



  static Scanner in = new Scanner(System.in);


  public static void main(String[] args)
  {
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
    printCreateStaffMenu();
    int staffType;
    staffType = in.nextInt();
    switch(staffType)
    {
      case 1:
        setStaff(1);
        break;

      case 2:
      setStaff(2);
        break;

      case 3:
      setStaff(3);
        break;

      default:
        System.out.println("Inproper Input");
        break;
    }


  }

  public void setStaff(int staffType)
  {
    int income;

    System.out.print("\nEnter Name: ")
    String name = in.nextLine();

    System.out.print("\nEnter Hours/Week: ");
    int hours = in.nextInt();

    if(staffType > 1)
    {
      System.out.print("\nEnter Annual Income")
      income = in.nextInt();
    }


  }

  public void printStaff()
  {

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
