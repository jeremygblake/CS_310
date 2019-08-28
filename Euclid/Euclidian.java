


public class Euclid{

  private int x;
  private int y;


  public Euclid(int _x, int _y)
  {
    this.setX(_x);
    this.setY(_y);

    if(x > y){this.swap()}

  }


  public void setX(int _x)
  {
    this.x = _x;
  }

  public void setY(int _y)
  {
    this.y = _y;
  }

  private void swap()
  {
    System.out.println("x was greater than y so the numbers were flipped");

    int tmp = this.x;
    this.x = this.y;
    this.y = tmp;
  }
  public void findGCD()
  {
    this.findGCD(this.x, this.y)
  }
  public void findGCD(int a, int b)
  {
    GCD = y%x

  }

}
