public class ProcessInfo
{
  private float processTime;
  private int priority;
  private String name;

  public ProcessInfo(float time, int priority, String name)
  {
    this.processTime = time;
    this.priority = priority;
    this.name = name;
  }

  public float getProcessTime()
  {
    return this.processTime;
  }

  public int getPriority()
  {
    return this.priority;
  }

  public String getName()
  {
    return this.name;
  }

  public boolean decrementTime(float decrementUnit)
  {
    this.processTime -= decrementUnit;
    if(this.processTime <= 0)
    {
      return false;
    }

    return true;
  }

  public String toString()
  {
    return "Name: " + this.name + " Priority: " + this.priority + " Process Time: " + this.processTime;
  }
}
