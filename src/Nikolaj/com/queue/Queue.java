package Nikolaj.com.queue;

public interface Queue<E> {
    public boolean isEmpty();
    public void enqueue(E o);
    public E peek();
    public E dequeue();
    public void clear();
    public int size();
}
