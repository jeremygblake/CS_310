public class Employee extends StaffMember
{
  protected int salary;

  public Employee(String _id, String _name, int _salary)
  {
    super(_id,_name);
    this.salary = _salary;
  }
  @override
  public int getSalary()
  {
    return this.salary;
  }

  public void setSalary(int _salary)
  {
    this.salary = _salary;
  }

}
