import java.util.Scanner;

public class PQProcess {

    private static Scanner in = new Scanner(System.in);

    private static void enterProcess()
    {
        System.out.println("Enter Process Name: ");
        String name = in.next();
        System.out.println("Enter Process Priority: ");
        int priority = in.nextInt();
        System.out.println("Enter Process Time: ");
        float time = in.nextFloat();

        ProcessInfo pi = new ProcessInfo(time, priority, name);
        //TODO: ADD pi to the Heap array
    }

    private static  void buildHeap()
    {

    }

    private static void deleteHighestPriority()
    {

    }

    private static void checkHighestPriorityItem()
    {

    }
    private static void checkHighestPriority()
    {

    }
    private static void displayHeap()
    {

    }
    private static void exit()
    {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("[1] Enter a process\n\n[2] Build Heap\n\n[3] Delete Highest Priority\n\n[4]Check Highest Priority Item\n\n[5]Check Highest Priority\n\n[6]Display Heap\n\n[7] Exit");
            int ans = in.nextInt();
            ans--;
            switch(ans)
            {
                case 1:
                    enterProcess();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        }
    }


}
