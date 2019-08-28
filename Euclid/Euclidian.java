


public class Euclidian{

  private int a;        //num 1
  private int b;        //num2 (greater, if not then swapped with a)
  private int r;        //remainder

  public void check()
  {
    if(a > b){this.swap();}
  }

  private void swap()       //this will swap the variables is a is greater than b
  {
    System.out.println("The first number was greater than the second so the numbers were flipped...");

    int tmp = this.a;
    this.a = this.b;
    this.b = tmp;
  }

  public int findGCD(int _a, int _b )     //this will give the user the option to call the function different ways...  this allows for a var set in the constructor than a parameterless call for returning the GCD
  {
    this.a = _a;
    this.b = _b;
    this.check();
    return(this.recursiveEuclidianAlgorithm(this.a,this.b));
  }

  private int recursiveEuclidianAlgorithm(int a, int b)          //this allows for a paramaterless constructor but then setting the vars in the findGCD function call
  {
    r = b%a;
    if (r != 0){a = recursiveEuclidianAlgorithm(r,a);}          //recursively returns until the

    return a;

  }


}
