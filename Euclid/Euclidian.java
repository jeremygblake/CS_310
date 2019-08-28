


public class Euclidian{

  private int a;
  private int b;
  private int r;

  public Euclidian()
  {
    this.setA(1);
    this.setB(1);
  }

  public Euclidian(int _a, int _b)
  {
    this.setA(_a);
    this.setB(_b);

    if(a > b){this.swap();}

  }

  public void setA(int _a)
  {
    this.a = _a;
  }

  public void setB(int _b)
  {
    this.b = _b;
  }

  private void swap()
  {
    System.out.println("a was greater than b so the numbers were flipped");

    int tmp = this.a;
    this.a = this.b;
    this.b = tmp;
  }


  public int findGCD()
  {
    return(this.findGCD(this.a, this.b));
  }

  public int findGCD(int a, int b)
  {
    r = b%a;
    if (r != 0){a = findGCD(r,a);}

    return a;

  }


}
