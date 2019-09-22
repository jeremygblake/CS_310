import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public class BalancedParentheses
{

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
    }
    StackInterface stack = new StackInterface();

    try{

      BufferedReader br = new BufferedReader(file);
      boolean flag = false;

      while((c = br.read()) != -1)
      {
        if(c == '(' | c == '{')
        {
          flag == true;
          stack.push(c);
        }
        else if(c == ')' | c == '}')
        {
          flag = false;
          stack.push(c);
          if (c != stack.pop())
          {
            System.out.print("NOT BALANCED");

          }
        }
        if(flag == true)
        {
          stack.push(c):
        }
      }


    }catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}
