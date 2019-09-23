public class StackArray<E> implements StackInferface
{
  private E[] stack = null;

  private int max;
  private int size = 0;
  private int top = -1;




  public StackArray(int max)
  {
    this.max = max;
    this.stack = new E[max];
  }

  public void push(E e)
  {
    if(isFull())
    {
      return;
    }
    this.size++;
    this.stack[++top];
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

  public boolen isFull()
  {
    return (this.max == this.size);
  }

}
