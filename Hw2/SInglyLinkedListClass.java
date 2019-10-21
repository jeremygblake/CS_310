public class SinglyLinkedListClass<E> implements ListInterface<E>
{
  private Node<E> first;
  private Node<E> last;

  SinglyLinkedListClass()
  {
    this.first = null;
    this.last = null;
  }

  public void insertItem(E item, int priority)
  {
    Node newNode,p;
    Node<E> newNode = new Node(item, priority);

    if(isEmpty())
    {
      newNode.nextNode = first;
      first = newNode;
      last = first;
    }
    else if(priority < first.priority)
    {
      newNode.nextNode = first;
      first = newNode;
      last.nextNode = first;
    }
    else if(priority > last.priority)
    {
      newNode.nextNode = first;
      last.nextNode = newNode;
      newNode = last;
    }
    else
    {
      p = first;
      while(p.nextNode.priority <= priority)
      {
        p = p.nextNode;
      }
      newNode.nextNode = p.nextNode;
      p.nextNode = newNode;
    }
  }

  public E removeElement(Node e)
  {
    Node p = first;
    do {
      if(e == p)
      {
        return p.data;
      }
      p = p.nextNode;
    }while(p != first);
    return null;
  }

  public E minElement()
  {
    if(isEmpty())
    {
      throw new NullPointerException();
    }
    else
    {
      return first.data;
    }
  }
    public int minPriority()
    {
      if(isEmpty())
      {
        throw new NullPointerException();
      }
      else
      {
        return first.priority;
      }
    }

  public void decrement(float decrementUnit)
  {
    Node p = first;
    do
    {
      boolean isPositive = p.data.decrement(decrementUnit);
      if(!isPositive)
      {
        removeElement(p);
      }
      p = p.nextNode;
    }
    while(p != first);
  }

  public boolean isEmpty()
  {
    return (first == null);
  }

  public void display()
  {
    if(isEmpty())
    {
      throw new NullPointerException();
    }
    Node p = first;
    do {
      System.out.println(p.data+" "+p.priority);
      p = p.nextNode;
    }while(p != first);
  }



}
