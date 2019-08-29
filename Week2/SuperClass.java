public class SuperClass
{
  private   int a;
  private   int b;
  protected int c;

  SuperCLass()
  {
    System.out.println("");

  }
  public void operation()
  {
    System.out.println("SuperClass operation was called")
  }
  public void operation(int variable_change)
  {
    a = varaible_change;
  }

  public void operation(int _a, int _b)
  {
    a = _a;
    b = _b;
  }
  public void printValues()
  {
    System.out.println("Printing the value of a, b, c");
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);


  }


}
