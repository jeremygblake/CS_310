import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BalancedParentheses
{
  public static void main (String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    StackArray stack = new StackArray(30);
    int tmp_char = ' ';

    while((tmp_char = br.read()) != -1)  //O(n)  complexity
    {
      //System.out.println((int)tmp_char);  // TEST for data output
      if((char)tmp_char == '}' && (stack.isEmpty() ||((int)stack.pop() + tmp_char) != 248)) //ascii addition to check
      {
           stack.push('.');   //adds an element to the list so that the list will not be empty and the logic will return Unbalanced
           break;  //breaks the loop if there is a ublanaced set
      }
      else if((char)tmp_char == '{')
      {
        stack.push(tmp_char);
      }
      else
      {
        continue;
      }
    }
    //in theory there should be an empty stack if the parentheses are balanced... there for check and print
    if(stack.isEmpty())
    {
      System.out.println("Balanced Parentheses");
    }
    else
    {
      System.out.println("Unbalanced Parentheses");
    }//
  }
}
