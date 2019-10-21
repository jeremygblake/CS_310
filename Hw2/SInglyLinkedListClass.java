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
      newNode.nextNode = head;
      head = newNode;
      last = head;
    }
    else if(priority < head.priority)
    {
      newNode.nextNode = head;
      head = newNode;
      last.nextNode = head;
    }
    else if(priority > last.priority)
    {
      newNode.nextNode = head;
      last.nextNode = newNode;
      newNode = last;
    }
    else
    {
      p = head;
      while(p.nextNode.priority <= priority)
      {
        p = p.nextNode;
      }
      newNode.nextNode = p.nextNode;
      p.nextNode = newNode;
    }
  }

  public E removeElement(E e)
  {
    do {
      if(e == p.data)
      {
        return p.data;
      }
      p = p.nextNode;
    }while(p != head);
  }

  public E minElement()
  {
    if(isEmpty())
    {
      return null;
    }
    else
    {
      return head.data;
    }
    public int minPriority()
    {
      if(isEmpty)
      {
        return null;
      }
      else
      {
        return head.priority
      }
    }

  public void decrement(float decrementUnit)
  {
    Node p = head;
    do
    {
      boolean isPositive = p.data.decrement(decrementUnit);
      if(!isPositive)
      {
        removeElement(p);
      }
      p = p.nextNode;
    }
    while(p != head);
  }
  public boolean isEmpty()
  {
    return (head == null);
  }

  public void Display()
  {
    Node p = head;
    do {
      System.out.println(p.data+" "+p.priority);
      p = p.nextNode;
    }while(p != head);
  }



}
