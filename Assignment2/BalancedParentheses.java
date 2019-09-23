import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class BalancedParentheses
{


  public static void main (String[] args) throws IOException
  {

    File file = new File("input.txt");
    if(file.isDirectory() || !file.exists())
    {
      System.out.println("404 - File Not Found Error");
      return;
    }
    BufferedReader br = new BufferedReader(file);

    Stack<Character> stack = new Stack<Character>(300);

    while((tmp_char = br.read()) != null)
    {
      if(tmp_char == "}")
      {
        while(stack.pop() != "{")
        {
          if(stack.isEmpty())
          {
            System.out.print("Unbalanced Parentheses");
            return;
          }
        }
      }
      stack.push(tmp_char);

    }
    System.out.println("Balanced Parentheses");

  }
}
