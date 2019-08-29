public class InheritanceExample implements MethodNames
{
  public static int main(String[] args)
  {
    SubClass sub1 = new SubClass();
    SuperClass super1 = new SuperClarr();
    GrandChildClass gc = new GrandChildClass();


    sub1.b = 20;
    sub1.c = 30;
    gc.b = 100;
    gc.c = 200;
    sub1.printValues();
    sub1.operation();
    gc.operation();
    gc.printValues();


    super1.operation();
    super1.printValues();
    super1.operation(200);
    super1.printValues();

    //TODO: CODE HERE
    return 1;
  }
}
