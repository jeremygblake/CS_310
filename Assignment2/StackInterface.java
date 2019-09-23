public interface StackInterface<E> {
  public void push(Object<E> e);
  public E pop();
  public boolean isEmpty();
  public boolean isFull();

}
