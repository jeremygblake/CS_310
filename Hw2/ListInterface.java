public interface ListInterface<E>
{
	public int 			size();
	public boolean 	isEmpty();
	public E 				first();
	public E 				last();
	public void 		rotate();
	public void 		addFirst(E e);
	public void 		addLast(E e);
	public E 				removeFirst();
	public void     addItemByPriority(E e);
	public void     display();
}
