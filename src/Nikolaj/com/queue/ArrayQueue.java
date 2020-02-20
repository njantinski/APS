package Nikolaj.com.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>{
    private E[] elements;
    private int length, front, rear;

    public ArrayQueue(int maxLength){
        clear();
        elements = (E[]) new Object[maxLength];
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public void enqueue(E x) {
        if(length == elements.length){
            System.out.println("redicata e polna");
            return;
        }
        elements[rear++] = x;
        if(rear == elements.length)
            rear = 0;
        length++;
    }

    @Override
    public E peek() {
       if(length > 0)
           return elements[front];
       else
           return null;
    }

    @Override
    public E dequeue() {
        if(length > 0) {
            E frontmost = elements[front];
            elements[front++] = null;
            if (front == elements.length)
                front = 0;
            length--;
            return frontmost;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        length = 0;
        front = rear = 0;
    }

    @Override
    public int size() {
        return length;
    }
}
