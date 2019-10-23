import java.util.Scanner;

public class MainProgram {

    private static Scanner in = new Scanner(System.in);
    private static HeapClass<ProcessInfo> heap = new HeapClass<ProcessInfo>(10, new ProcessInfo(5, -100, "NULL POSITION OBJECT"));



    private static void enterProcess()
    {
        System.out.println("Enter Process Name: ");
        String name = in.next();
        System.out.println("Enter Process Priority: ");
        int priority = in.nextInt();
        System.out.println("Enter Process Time: ");
        float time = in.nextFloat();

        ProcessInfo pi = new ProcessInfo(time, priority, name);
        heap.add(pi);
    }



    public static void main(String[] args)
    {
        heap.add(new ProcessInfo(5, 1, "A"));
        heap.display();
        heap.add(new ProcessInfo(5, 2, "B"));
        heap.display();

        heap.add(new ProcessInfo(5, 1, "D"));
        heap.display();

        heap.add(new ProcessInfo(5, 5, "E"));
        heap.display();

        heap.add(new ProcessInfo(5, 3, "F"));
        heap.display();



        while(true)
        {
            System.out.println("[1] Enter a process\n\n[2] Build Heap\n\n[3] Delete Highest Priority\n\n[4]Check Highest Priority Item\n\n[5]Check Highest Priority\n\n[6]Display Heap\n\n[7] Exit");
            int ans = in.nextInt();
            switch(ans)
            {
                case 1:
                    enterProcess();
                    break;
                case 2:
                    break;
                case 3:
                    heap.removeMax();
                    break;
                case 4:
                    System.out.println(heap.max().toString());
                    break;
                case 5:
                    System.out.println(heap.max().getPriority());
                    break;
                case 6:
                    heap.display();
                    break;
                default:
                    //exits
                    return;

            }
        }
    }


}