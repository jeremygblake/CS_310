public class ExecutiveEmployee extends Employee
{

  public ExecutiveEmployee(String _id, String _name, String _salary)
  {
    super(_id, _name, _salary);
  }

  public String getSalary()
  {
    return this.salary + " Annually";
  }


}
