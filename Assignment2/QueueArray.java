import java.lang.RuntimeException;

public class QueueArray
{
  private Object[] elements;
	private int front = -1;
	private int rear = -1;
	private int numOfelements = 0;

	public QueueArray(int size) {
		this.elements = new Object[size];
	}

	public void enqueue(Object o) {
		if (isFull())
			throw new RuntimeException("Full");
		if (front == -1){
			front = 0;
		}
		if (rear == elements.length-1) // deal with circular case
			rear = 0;
		else
			rear++;
		elements[rear] = o;

		numOfelements++; // add 1 to the element count
	}

	public Object dequeue() {
		if (isEmpty())
			throw new RuntimeException("Empty");
		Object dequeue_value = elements[front];

		if(front==rear)
		{
			front = -1;
			rear=-1;
		}
		else if (front == elements.length-1)
		{
			front = 0;
		}
		else
		{
			front++;
		}
		numOfelements--;
		return dequeue_value;
	}

	public Object peek() {
		return elements[front];
	}

	public boolean isFull() {
		return numOfelements == elements.length;
	}

	public boolean isEmpty() {
		return numOfelements == 0;
	}
}
