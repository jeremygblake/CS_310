import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public class Balances Parentheses
{
l
  public static void main (String[] args)
  {
    Scanner in = new Scanner(System.in);

    System.out.println("Input the file path for the input file: ");
    String file_path = in.next();
    File file = new File(file_path);
    String tmp_char = "";

    if(!file.exists() || file.isDirectory())
    {
      System.out.println("Inproper Path!  Exiting...");
      return;
    }m
    try{
      BufferedReader br = new BufferedReader(file):
      tmp_char = br.read();
      if(tmp_char == '{' | tmp_char == '(')
      {
        //TODO: loop until EOF or end Parentheses
      }
    }catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}
