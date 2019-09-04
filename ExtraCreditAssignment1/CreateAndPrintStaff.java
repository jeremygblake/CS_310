import java.util.Scanner;

public class CreateAndPrintStaff
{
  static StaffMember[] staffMembers = new StaffMember[9];
  static int currentStaff;
  static final int maxOfEachStaff     = 3;
  static int currentVolunteers;
  static int currentHourly;
  static int currentExecutive;
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
          printStaff();
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
    if (staffType < 1 || staffType > 3)
    {
      return;
    }
    //there is an issue with indexoutofbounds in the parse
    String id = createEmployeeId();
    String income;

    if(staffType > 1)
    {
      if(staffType == 3)
      {
        if(currentHourly > 2){maxError();return;}
        System.out.print("\nEnter Name: ");
        String name = in.next();
        System.out.print("\nEnter Hours/Week: ");
        int hours = in.nextInt();
        System.out.print("\nEnter Weekly Income: ");
        income = in.next();
        staffMembers[currentStaff] = new HourlyEmployee(id, name, income, hours);
        currentHourly++;
        currentStaff++;
        return;
      }
      if(currentExecutive > 2){maxError();return;}
      System.out.print("\nEnter Name: ");
      String name = in.next();
      System.out.print("\nEnter Annual Income: ");
      income = in.next();
      staffMembers[currentStaff] = new ExecutiveEmployee(id, name, income);
      currentExecutive++;
      currentStaff++;
      return;
    }
    if(currentHourly > 2){maxError();return;}
    System.out.print("\nEnter Name: ");
    String name = in.next();
    System.out.print("\nEnter Hours/Week: ");
    int hours = in.nextInt();
    staffMembers[currentStaff] = new Volunteer(id, name, hours);
    currentHourly++;
    currentStaff++;
  }

  public static void maxError()
  {
    System.out.println("Cannot Add More than 3 of Selected Type");
  }

  public static String createEmployeeId()
  {
    String id;
    id = "00" + Integer.toString(currentStaff + 1);

    return id;
  }

  public static void printStaff()
  {
    if(currentStaff == 0)
    {
      System.out.println("No Employees");
      return;
    }

    System.out.println("STAFF:\n");
    for( int i = 0; i < currentStaff; i++)
    {
      System.out.println("ID " + staffMembers[i].getId() + " " + staffMembers[i].getName() + ", " + staffMembers[i].getPosition() + ", Salary " + staffMembers[i].getSalary());

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
