import java.lang.RuntimeException;

public class QueueArray
{
  private StudentInfo[] elements;
	private int front = -1;
	private int rear = -1;
	private int numOfElements = 0;

	public QueueArray(int size) {
		this.elements = new StudentInfo[size];
	}

	public void enqueue(StudentInfo o) {
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

		numOfElements++; // add 1 to the element count
	}

	public StudentInfo dequeue() {
		if (isEmpty())
			throw new RuntimeException("Empty");
		StudentInfo data = elements[front];

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
		numOfElements--;
		return data;
	}

	public Object peek() {
		return elements[front];
	}

	public boolean isFull() {
		return numOfElements == elements.length;
	}

	public boolean isEmpty() {
		return numOfElements == 0;
	}

  public int size()
  {
    return this.numOfElements;
  }
}
