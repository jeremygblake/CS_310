import java.util.Scanner;

public class CreateAndPrintStaff
{
  StaffMember[] staffMembers = new StaffMember[9];
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
        setVoluneteer();
        break;

      case 2:
        setExecutive();
        break;

      case 3:
        setHourly();
        break;

      default:
        System.out.println("Inproper Input");
        break;
    }
  }
  public void setStaff(int staffType)
  {

    int income;

    System.out.print("\nEnter Name: ");
    String name = in.nextLine();

    System.out.print("\nEnter Hours/Week: ");
    int hours = in.nextInt();

    if(staffType > 1)
    {
      if(staffType == 2)
      {
        if(currentHourly > 2){maxError();return;}
        System.out.print("\nEnter Weekly Income: ");
        income = in.nextInt();
        staffMembers[currentStaff] = new Hourly(name, hours, income, staffType);
        currentHourly++;
        currentStaff++;
        return;
      }
      if(currentExecutive > 2){maxError();return;}
      System.out.print("\nEnter Annual Income: ");
      income = in.nextInt();
      staffMembers[currentStaff] = new Executive(name, hours, income, staffType);
      currentExecutive++;
      currentStaff++;
      return;
    }
    if(currentHourly > 2){maxError();return;}
    staffMembers[currentStaff] = new Volunteer(name, hours);
    currentHourly++;
    currentStaff++;

  }

  public static void maxError()
  {
    System.out.println("Cannot Add More than 3 of Selected Type");
  }

  public static string createEmployeeId()
  {
    string id;
    id = "00" + (currentStaff + 1).toString();

    return id;
  }

  public void printStaff()
  {
    System.out.println("STAFF:\n");
    for( int i = 0; i < staffMembers.length; i++)
    {
      System.out.print("ID " + staffMembers[i].getID() + " " + staffMembers[i].getName() + ", " + staffMembers[i].getPosition() + ", Salary " + staffMembers[i].getSalary());

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
