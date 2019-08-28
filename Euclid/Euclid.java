


public class Euclid{

  private int x;
  private int y;


  public Euclid(int _x, int _y)
  {
    this.setX(_x);
    this.setY(_y);
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
    int tmp = this.x;
    this.x = this.y;
    this.y = tmp;
  }

  public int findGCD()
  {
    int GCD = 0;

    return GCD;
  }

}
