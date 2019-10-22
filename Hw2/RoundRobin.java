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
      System.out.println("[1] Enter a Process\n\n[2] Start Execution\n\n[3] Exit");
      int ans = in.nextInt();

      if(ans == 1)
      {
        System.out.println("Enter Process Name: ");
        String name = in.next();
        System.out.println("Enter Process Priority: ");
        int priority = in.nextInt();
        System.out.println("Enter Process Time: ");
        float time = in.nextFloat();

        ProcessInfo pi = new ProcessInfo(time, priority, name);
        infoList.addItemByComparison(pi);
      }
      else if(ans == 2)
      {
        System.out.println("\n\n\nADDING NODES");

        infoList.addItemByComparison(new ProcessInfo(4,2,"A"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"B"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"C"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"D"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"E"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"F"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"G"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"H"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"I"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(4,2,"J"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"K"));
        infoList.display();
        System.out.println("\n");
        infoList.addItemByComparison(new ProcessInfo(5,1,"L"));
        infoList.display();
        System.out.println("\n");

        System.out.println("=========== INITIAL    =============\n");
        infoList.display();
        System.out.println("=========== PROCESSING =============\n");

        ProcessInfo temp;
        boolean isPositive;
        System.out.println("SIZE: " + infoList.size());
        while(!infoList.isEmpty())
        {
          System.out.println("\n");
          int size = infoList.size();
          for(int i = 0; i < size; i++)
          {
            temp = infoList.removeFirst();
            if(!temp.setTime(temp.getProcessTime() - timeQuantum))
            {
              continue;
            }
            infoList.addLast(temp);
          }
          infoList.display();
        }
      }
      else if(ans == 3)
      {
        return;
      }
      else
      {
        System.out.println("INPUT ERROR");
      }
    }
  }
}
