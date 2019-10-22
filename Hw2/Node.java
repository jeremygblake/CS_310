public class Node<E extends Comparable<E>>
{
	private E data;
	private Node<E> nextNode;

	public Node(E e, Node<E> n)
	{
		this.data = e;
		this.nextNode = n;
	}
	public Node<E> getNext()
	{
		return nextNode;
	}
	public E getElement()
	{
		return data;
	}
	public void setNext(Node<E> n)
	{
		nextNode = n;
	}

	public String toString()
	{
		return data.toString();
	}

	public int compareTo(E e)
	{
		return this.data.compareTo(e);
	}
}
