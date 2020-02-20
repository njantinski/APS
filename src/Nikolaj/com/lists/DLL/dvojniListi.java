package Nikolaj.com.lists.DLL;

class DLLNode<E>{
    protected E element;
    protected DLLNode<E> pred;
    protected DLLNode<E> succ;

    public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = element;
        this.pred = pred;
        this.succ = succ;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DLLNode<E> getPred() {
        return pred;
    }

    public void setPred(DLLNode<E> pred) {
        this.pred = pred;
    }

    public DLLNode<E> getSucc() {
        return succ;
    }

    public void setSucc(DLLNode<E> succ) {
        this.succ = succ;
    }
}

class DLL<E>{
    protected DLLNode<E> first;
    protected DLLNode<E> last;

    public DLL(){
        this.first = null;
        this.last = null;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    public void setFirst(DLLNode<E> first) {
        this.first = first;
    }

    public void setLast(DLLNode<E> last) {
        this.last = last;
    }

    public void insertFirst(E o){
        DLLNode<E> ins = new DLLNode<E>(o, null, first);

        if(first == null)
            last = ins;
        else
        first.pred = ins;
        first = ins;
    }

    public void insertLast(E o){
        if(first == null)
            insertFirst(o);
        else{
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }
    public E deleteFirst(){
        if(first != null){
            DLLNode<E> tmp = first;
            first = first.succ;
            first.pred = null;

            if(first == null)
                last = null;
            return tmp.element;
        }
        return null;
    }
    public E deleteLast(){
        if(last != null){
            DLLNode<E> tmp = last;
            if(first.succ == null) {
                return deleteFirst();
            }
            last = last.pred;
            last.succ = null;
            return tmp.element;
        }
        return null;
    }
    public void insertBefore(E o, DLLNode<E> before) {
        if(before == first){
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred,
                before);
        before.pred.succ = ins;
        before.pred = ins;
    }
    public void insertAfter(E o, DLLNode<E> after) {
        if(after==last){
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after,
                after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }


    public String toString(){
        String print = "";
        DLLNode<E> node = getFirst();
        while(node.succ != null){
            print += node.element;
            print += "->";
            node = node.succ;
        }
        print += node.element;
        return print;
    }



}
public class dvojniListi {
}
