package Nikolaj.com.stack;

import java.util.NoSuchElementException;

interface Stack<E>{

    public boolean isEmpty();
    public E peek();
    public void clear();
    public void push(E o);
    public E pop();

}



public class ArrayStack<E> implements Stack<E> {
    private int depth;
    private E[] elements;

    public ArrayStack(int maxDepth) {
        depth = 0;
        this.elements = (E[]) new Object[maxDepth];
    }

    @Override
    public boolean isEmpty() {
        return (depth == 0);
    }

    @Override
    public E peek() {
        return elements[depth - 1];
    }

    @Override
    public void clear() {
        for(int i = 0; i < depth ; i++){
            elements[i] = null;
        }
        depth = 0;
    }

    @Override
    public void push(E o) {
        elements[depth] = o;
        depth ++;
    }

    @Override
    public E pop() {
        if(depth == 0)
            throw new NoSuchElementException();

        E ret = elements[depth - 1];
        elements[depth-1] = null;
        depth --;
        return ret;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stackce = new ArrayStack<>(10);

        for(int i = 0; i < 10 ; i++){
            stackce.push(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(stackce.pop());
        }
    }


}
