import java.util.Scanner;

class Source{


  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.print("Euclidian Algorithm:\n\nInput Smaller Number: ");
    int a = in.nextInt();
    System.out.print("\n\nInput Bigger Number: ");

    int b = in.nextInt();

    Euclidian e = new Euclidian();
    System.out.println("The GCD is: " + e.findGCD(a,b));

  }
}
