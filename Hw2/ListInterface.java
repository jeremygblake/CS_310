public interface ListInterface<E> {

	public void    insertItem(E data,int priority);
	public E       removeMin();
	public boolean isEmpty();
	public E       minElement(); /* peek equivlant */
	public int     minPriority();
	public void    display();

}
