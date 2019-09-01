public class HourlyEmployee extends Employee
{
  private int hours;

  public HourlyEmployee(String _id, String _name, int salary, int _hours)
  {
    super(_id, _name, salary);
    this.hours = _hours;
  }

  public int getHours()
  {
    return this.hours;
  }

  public void setHours(int _hours)
  {
    this.hours = _hours;
  }

}
