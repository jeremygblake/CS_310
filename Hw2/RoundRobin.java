import java.util.Scanner;

public class RoundRobin
{
  private float timeQuantum;
  public SimpleInput in = new SimpleInput(System.in);
  ListInterface<ProcessInfo> infoList = new SinglyLinkedListClass<ProcessInfo>();

  public static void main(Stringp[] args)
  {
    while(true)
    {
      System.out.println("Enter Time Quantum");
      int timeQuantum = in.intInput();
      roundRobinLoop();

    }
  }



  public void roundRobinLoop()
  {
    while(true)
    {
      System.out.println("[1] Enter a Process\n\n[2] Start Execution");
      int ans = in.intInput();

      if(ans == 1)
      {
        System.out.println("Enter Process Name: ");
        String name = in.stringInput();
        System.out.println("Enter Process Priority: ");
        int priority = in.intInput();
        System.out.println("Enter Process Time: ");
        float time = in.floatInput();

        ProcessInfo pi = new ProcessInfo(name, priority, time);

        infoList.insertItem(pi, pi.getPriority());

      }
      else if(ans == 2)
      {
        infoList.decrement(timeQuantum);
      }
    }
  }

  class SimpleInput
  {
    Scanner in;

    SimpleInput(Object type)
    {
      Scanner = new Scanner(type);
    }

    public int intInput()
    {
      return in.nextInt();
    }
    public String stringInput()
    {
      return in.nextLine();
    }
    public float floatInput()
    {
      return in.nextFloat();
    }
  }



}
