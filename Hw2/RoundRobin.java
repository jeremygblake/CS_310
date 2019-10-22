import java.util.Scanner;

public class RoundRobin
{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    ListInterface<ProcessInfo> infoList = new SinglyLinkedListClass<ProcessInfo>();


    System.out.println("Enter Time Quantum");
    float timeQuantum = in.nextInt();
    while(true)
    {
      System.out.println("[1] Enter a Process\n\n[2] Start Execution");
      int ans = in.nextInt();

      if(ans == 1)
      {
        System.out.println("Enter Process Name: ");
        String name = in.nextLine();
        System.out.println("Enter Process Priority: ");
        int priority = in.nextInt();
        System.out.println("Enter Process Time: ");
        float time = in.nextFloat();

        ProcessInfo pi = new ProcessInfo(time, priority, name);
        infoList.addLast(pi);
        //infoList.addItemByPriority(pi, pi.getPriority());
      }
      else if(ans == 2)
      {
        infoList.display();
      }
    }
  }
}
