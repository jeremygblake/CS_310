public class StackArray implements StackInterface
{
  private char[] stack = null;

  private int max;
  private int size = 0;
  private int top = -1;


  @SuppressWarnings("unchecked")
  public StackArray(int max)
  {
    this.max = max;
    this.stack = new char[max];
  }

  public void push(char c)
  {
    if(isFull())
    {
      return;
    }
    this.size++;
    this.stack[++top] = c;
  }

  public char pop()
  {
    if(isEmpty())
    {
      return ' ';
    }
    this.size--;
    char c = this.stack[top];
    this.stack[top] = ' ';
    top--;
    return c;
  }

  public boolean isEmpty()
  {
    return (this.size == 0);
  }

  public boolean isFull()
  {
    return (this.max == this.size);
  }
  public void printStack()
  {
    if(isEmpty())
    {
      return;
    }
    for(int i = 0; i < this.size; i++)
    {
      System.out.println(stack[i]);
    }
  }
}
