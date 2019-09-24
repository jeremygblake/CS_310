import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BalancedParentheses
{
  public static void main (String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    StackArray stack = new StackArray(10);
    char tmp_char = ' ';

    while((tmp_char = (char)br.read()) != -1)
    {
      System.out.println(tmp_char);

      if(tmp_char == '}' && ((int)stack.pop() + (int)tmp_char) != 248)
      {
        System.out.println("Unbalanced Parentheses");
      }
      else if(tmp_char == '{')
      {
        stack.push(tmp_char);
      }
      else
      {
        continue;
      }

    }
    System.out.println("Balanced Parentheses");

  }



}
