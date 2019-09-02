public class Employee extends StaffMember
{
  public Employee(String _id, String _name, String _salary)
  {
    super(_id, _name);
    this.salary = _salary;
  }
}
