public class SinglyLinkedListClass<E extends Comparable<E>> implements ListInterface<E>
{
  private Node<E> tail = null;
  private int size = 0;

  public SinglyLinkedListClass(){}

  public int size()
  {
    return size;
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public E first()
  {
    if(isEmpty()) return null;

    return tail.getNext().getElement();
  }

  public E last()
  {
    if(isEmpty()) return null;
    return tail.getElement();
  }

  public void rotate()
  {
    if(tail != null)
      tail = tail.getNext();
  }
  public void addItemByComparison(E e)
  {

    if(isEmpty() || tail.getNext().compareTo(e) == -1)
    {
      addFirst(e);
    }
    else if(tail.compareTo(e) >= 0)
    {
      addLast(e);
    }
    else
    {
      Node x = tail.getNext();
      while(x.getNext().compareTo(e) >= 0)
      {
        x = x.getNext();
      }
      Node<E> newNode = new Node<E>(e, x.getNext());
      x.setNext(newNode);
      size++;
    }

  }

  public void addFirst(E e)
  {
    if(isEmpty())
    {
      tail = new Node<>(e,null);
      tail.setNext(tail);
    }
    else
    {
      Node<E> newest = new Node<>(e, tail.getNext());
      tail.setNext(newest);
    }
    size++;
  }

  public void addLast(E e)
  {
    addFirst(e);
    tail = tail.getNext();
  }

  public E removeFirst()
  {
    if(isEmpty()) return null;
    Node<E> head = tail.getNext();
    if(head == tail)
    {
      tail = null;
    }else
    {
      tail.setNext(head.getNext());
    }
    size--;
    return head.getElement();

  }

  public void display()
  {
    for(int i = 0; i < size; i++)
    {
      System.out.println(first().toString());
      rotate();
    }
  }
}
