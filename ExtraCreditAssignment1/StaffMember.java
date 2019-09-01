public class StaffMember
{
  private String id;
  private String name;
  protected int salary;
  protected int hours;

  public StaffMember(String _id, String _name)
  {
    this.id = _id;
    this.name = _name;
  }

  public void setName(String _name)
  {
    this.name = _name;
  }
  public String getName()
  {
    return this.name;
  }
  public String getPosition()
  {
    return this.getClass().getName();
  }


  public String getId()
  {
    return this.id;
  }
  public void setId(String _id)
  {
    this.id = _id;
  }
  public int getSalary()
  {
    return this.salary;
  }
  public void setSalary(int _salary)
  {
    this.salary = _salary;
  }

  public void setHours(int _hours)
  {
    this.hours = _hours;
  }
  public int getHours()
  {
    return this.hours;
  }
}
