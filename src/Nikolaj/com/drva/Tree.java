package Nikolaj.com.drva;
import java.util.Iterator;


public interface Tree <E>{
    public Tree.Node<E> root();
    public Tree.Node<E> parent(Tree.Node<E> node);
    public int childCount(Tree.Node<E> node);
    public void makeRoot(E elem);
    public Tree.Node<E> addChild(Tree.Node<E> node, E elem);
    public void remove(Tree.Node<E> node);
    public Iterator<E> children (Tree.Node<E> node);

    interface Node<E>{
        public E getElement();
        public void setElement(E elem);
    }
}


