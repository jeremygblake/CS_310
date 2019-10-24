import java.util.NoSuchElementException;

public class HeapClass <E extends Comparable<E>> {
    Object[] heap;
    private int size;
    private int maxsize;

    public HeapClass(int capacity, E initial)
    {
        this.maxsize = capacity;
        this.size = 0;
        heap = new Object[this.maxsize + 1];
        heap[0] = initial;
    }
    private int parent(int pos)
    {
        return pos / 2;
    }
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
    private boolean isLeaf(int pos)
    {
        if(pos > (size /2) && pos <= size)
        {
            return true;
        }
        return false;
    }
    public void add(E e)
    {
        heap[++size] = e;
        int pos = size;
        while(((E)heap[pos]).compareTo((E)heap[parent(pos)]) == 1)
        {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }
    private void swap(int one, int two)
    {

        E tmp =(E) heap[one];
        heap[one] = heap[two];
        heap[two] = tmp;
    }
    public E removeMax()
    {
        E e = (E)heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return e;
    }
    public E max()
    {
        E max = (E)heap[1];
        return max;
    }
    public void heapify(int pos)
    {
        if(isLeaf(pos))
        {
            return;
        }
        if(((E)heap[pos]).compareTo((E)heap[leftChild(pos)]) == -1 ||((E)heap[pos]).compareTo((E)heap[rightChild(pos)]) == -1 )
        {
            if(((E)heap[leftChild(pos)]).compareTo((E)heap[rightChild(pos)]) == 1)
            {
                swap(pos, leftChild(pos));
                heapify(leftChild(pos));
            }
            else
            {
                swap(pos, rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }
    public void displayHeap()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT : " +
                    heap[2*i] + " RIGHT :" + heap[2*i+1]);
            System.out.println();
        }
    }

    public void display()
    {
        for(int i = 1; i < size; i++)
        {
            System.out.println(heap[i]);
        }
    }
}











