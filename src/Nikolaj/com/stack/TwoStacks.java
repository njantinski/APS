package Nikolaj.com.stack;

import java.util.NoSuchElementException;

public class TwoStacks<E> {

    private int depth1;
    private int depth2;
    private E[] elems;

    public TwoStacks(int maxDepth) {
        this.depth1 = 0;
        this.depth2 = 0;
        this.elems = (E[]) new Object[maxDepth];
    }

    public boolean isEmptyFirst() {
        return depth1 == 0;
    }
    public boolean isEmptySecond(){
        return depth2 == 0;
    }

    public boolean isFull(){
        return (depth1+depth2 == elems.length);
    }

    public E peekFirst() {
        if(depth1 == 0)
            throw new NoSuchElementException();
        return elems[depth1 - 1];
    }
    public E peekSecond() {
        if(depth2 == 0)
            throw new NoSuchElementException();
        return elems[elems.length - depth2];
    }


    public void clearFirst() {
       for(int i = 0; i < depth1; i++){
           elems[i] = null;
       }
       depth1 = 0;
    }
    public void clearSecond(){
        for(int i = elems.length - 1; i >= elems.length-depth1; i--){
            elems[i] = null;
        }
        depth2 = 0;
    }


    public void pushFirst(E o) {
        if(isFull()){
            System.out.println("Stekot e poln");
        } else{
            elems[depth1++] = o;
        }
    }
    public void pushSecond(E o){
        if(isFull()){
            System.out.println("Stekot e poln");
        } else{
            elems[elems.length - (++depth2)] = o;
        }
    }


    public E popFirst() {
        if(depth1 == 0){
            throw new NoSuchElementException();
        }
        else{
            E elem = elems[--depth1];
            elems[depth1] = null;
            return elem;
        }
    }
    public E popSecond() {
        if (depth2 == 0)
            throw new NoSuchElementException();
        E topmost = elems[elems.length-depth2];
        elems[elems.length-depth2] = null;
        depth2--;
        return topmost;
    }

}
