public class ProcessInfo implements Comparable<ProcessInfo>
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
  public boolean setTime(float t)
  {
    this.processTime = t;
    return(this.processTime > 0); //returns false if negative
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

  public String toString()
  {
    return "Name: " + this.name + " Priority: " + this.priority + " Process Time: " + this.processTime;
  }

  public int compareTo(ProcessInfo pi)
  {
    if(this.priority > pi.getPriority())
    {
      return 1;
    }
    return -1;
  }
}
