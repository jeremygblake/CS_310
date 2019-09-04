public class HourlyEmployee extends Employee
{
  public HourlyEmployee(String _id, String _name, String _salary, int _hours)
  {
    super(_id, _name, _salary);
    this.hours = _hours;
  }
  @Override
  public String getSalary()
  {
    return this.salary + " Weekly";
  }

}
