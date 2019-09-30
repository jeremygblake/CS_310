public interface QueueInterface{
  public void enqueue(Object o);
  public Object dequeue();
  public Object peek();
  public boolean isFull();
  public boolean isEmpty();
}
