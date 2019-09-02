public class HourlyEmployee extends Employee
{
  public HourlyEmployee(String _id, String _name, String salary, int _hours)
  {
    super(_id, _name, salary);
    this.hours = _hours;
  }

  public String getSalary()
  {
    return this.salary + " Weekly";
  }

}
