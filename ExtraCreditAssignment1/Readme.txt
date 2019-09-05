Usage Instructions:

[1] Command Line:   java -jar ExtraCredit1.jar

[2] Type in the number at the beginning at each option and hit enter to confirm your selection.
      Note: You can only exit the program by selecting the exit option at the main menu

[3] Select Staff type by typing the associates number and press enter.



Classes Used:
- CreateAndPrintStaff
- Employee
- ExecutiveEmployee
- HourlyEmployee
- StaffMember
- Volunteer

Class Descriptions:

  CreateAndPrintStaff:
     Methods:
          void main(String[] args)
               - prints the main menu our using the printmenu() function and loops until
                 you tell it to exit.
          void createStaff()
               - This can be called to start the process of creating a new staff Member
                 This would include navigating the menu for which staff type the user
                 would like to create along with the logic on which to create.
          void maxError()
               - This is a method containing a print statement that is called when there
                 are to many of a specific type of employee being created.
          String createEmployeeId()
               - this will take the employees position in the array and parse it as a string
                 called id.  The id is returned from this function then sent to the class objects
                 constructor.
          void printStaff()
               - Calling this will envoke a for loop that will print all existing staff member data
                 from the object array.  If there are no staff members then it informs the user.
          void printCreateStaffMenu()
               - This will print the menu for the user interface for staff selection
          void printMenu()
               - This will print the menu or the initial user interface of which action to take

     Employee:
          Employee(String _id, String _name, String _salary)
               - Calls the super with the id and name parameters and sets the salary


     ExecutiveEmployee:
          ExecutiveEmployee(String _id, String _name, String _salary)
               - calls the super along with the data in the variables _id, _name, and _salary
          String getSalary()
               - returns the salary along with concatenating it with "Annually"
     HourlyEmployee:
          HourlyEmpoyee(String _id, String _name, String salary)
               - calls the super sending the data in _id, _name, and _salary
          String getSalary()
               - returns the protected variable salary along with concatenating it with " Weekly"

     StaffMember:
          StaffMember(String _id, String _name)
               - sets the parameters to the protected variables associated with them
          void setName(String _name)
               - sets _name to protected variable name
          String getName()
               - returns name
          String getPosition()
               - return the position of a staff member
          void setId(String _id)
               - set staff id
          String getId()
               - returns the staff id
          void setSalary(String _salary)
               - sets the variable _salary to protected variable salary
          void getSalary()
               - returns the protected variable salary
          void setHours(int _hours)
               - sets _hours to protected variable hours
          String geHours()
               - returns the protected variable hours
     Volunteer:
          Volunteer(String _id, String _name, int _hours)
               - calls the super along with sending the data stored in _id and _name
