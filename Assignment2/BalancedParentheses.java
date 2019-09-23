import java.io.BufferedReader;
import java.io.File;

public class BalancedParentheses
{

  BufferedReader br = new BufferedReader(file);

  public static void main (String[] args) throws IOException
  {

    File file = new File("input.txt");
    if(file.isDirectory() || !file.exists())
    {
      System.out.println("404 - File Not Found Error")
      return;
    }

    StackInterface stack = new StackInterface();

    while((tmp_char = br.read()) != null)
    {
      if(tmp_char == '{')
      {
        stack.push(tmp_char)

      }
    }


    BufferedReader br = new BufferedReader(file);
    boolean flag = false;


  }

  public readLoop()
  {
    Char tmp_char = '';
    while((tmp_char = br.read()) != null)
    {
      if(tmp_char == '{')
      {
        
      }

    }
  }
}
