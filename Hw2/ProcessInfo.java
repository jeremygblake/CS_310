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
    this.time = thie.time - decrementUnit;
    if(this.time <= 0)
    {
      return false;
    }

    return true;
  }
}
