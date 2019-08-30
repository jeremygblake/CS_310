

public class StaffMember
{
  private   final int     min         = 10000;
  private   final int     max         = 99999;
  protected       int     EmployeeId;
  protected       double  Hours;

  public int createEmployeeId()
  {
    int id = (Math.random() * ((max - min) + 1)) + min;
    return id;
  }

  public int create EmployeeId(int id)
  {
    return id+1;
  }


}
