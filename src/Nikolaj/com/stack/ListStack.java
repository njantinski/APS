package Nikolaj.com.stack;



import java.util.NoSuchElementException;

public class ListStack<E> implements Stack<E> {
    private SLLNode<E> top;

    public ListStack(){
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top ==null;
    }

    @Override
    public E peek() {
        return top.element;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public void push(E o) {
        SLLNode<E> novNode = new SLLNode<E>(o, top);
        top = novNode;
    }

    @Override
    public E pop() {
        if(top == null)
            throw new NoSuchElementException();
        E popElement = top.element;
        top = top.succ;
        return popElement;
    }
}
