public class StackArray <E> implements StackInterface
{
  private E[] stack = null;

  private int max;
  private int size = 0;
  private int top = -1;



  @SuppressWarnings("unchecked")
  public StackArray(int max)
  {
    this.max = max;
    this.stack = (E[]) new Object[max];
  }

  public void push(Object<E> e)
  {
    if(isFull())
    {
      //return;
    }
    this.size++;
    this.stack[++top] = e;
  }

  public E pop()
  {
    if(isEmpty())
    {
      return null;
    }
    this.size--;
    E e = this.stack[top];
    this.stack[--top] = null;
    return e;
  }

  public boolean isEmpty()
  {
    return (this.size == 0);
  }

  public boolean isFull()
  {
    return (this.max == this.size);
  }

}
