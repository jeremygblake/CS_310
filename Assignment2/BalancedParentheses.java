import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BalancedParentheses
{


  public static void main (String[] args) throws IOException
  {

    BufferedReader br = new BufferedReader(new FileReader("input.txt"));

    StackArray<Char> stack = new StackArray<Char>(300);
    
    char tmp_char = ' ';

    while((tmp_char = (char)br.read()) != -1)
    {
      if(tmp_char == '}')
      {
        while(stack.pop() != '{')
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
