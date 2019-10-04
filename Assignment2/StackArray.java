import java.lang.RuntimeException;

/*
Author:       Jeremy Goold
Description:  LIFO stack implementation
*/
public class StackArray implements StackInterface
{
  private Object[] stack = null;
  private int max;
  private int size = 0;
  private int top = -1;

  public StackArray(int max)
  {
    this.max = max;
    this.stack = new Object[max];
  }

  public void push(int c) //add to end
  {
    if(isFull())
    {
      return;
    }
    this.size++;
    this.stack[++top] = c;
  }

  public Object pop()  //remove from end
  {
    if(isEmpty())
    {
      throw new RuntimeException("");
    }
    this.size--;
    Object c = this.stack[top];
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

  public Object peek()
  {
    if(isEmpty())
    {
      throw new RuntimeException("Empty");
    }
    return stack[top];
  }

  public void displayStack()
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
