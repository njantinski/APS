package Nikolaj.com.drva;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLLTree<E> implements Tree<E> {

    // implementation of node interface
    class SLLNode<P> implements Node<P>{
        SLLNode<P> parent, sibling, firstChild;
        // data holder
        P element;
        public SLLNode(P o){
            element = o;
            parent =  sibling = firstChild = null;
        }

        @Override
        public P getElement() {
            return element;
        }

        @Override
        public void setElement(P elem) {
            element = elem;
        }
    }

    protected SLLNode<E> root;

    public SLLTree(){
        root = null;
    }

    public Node<E> root(){
        return root;
    }

    public Tree.Node<E> parent(Tree.Node<E> node){
        return ((SLLNode<E>)node).parent;
    }

    public int childCount(Tree.Node<E> node){
        SLLNode<E> tmp = ((SLLNode<E>)node).firstChild;
        int num = 0;
        while(tmp != null){
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem){
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem){
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;

        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;

        return tmp;
    }

    @Override
    public Iterator<E> children(Tree.Node<E> node) {
        return new SLLTreeChildIterator<E>(((SLLNode<E>)node).firstChild);
    }

    public void remove(Tree.Node<E> node){
        SLLNode<E> curr = (SLLNode<E>) node;
        if(curr.parent != null){
            if(curr.parent.firstChild == curr){
                // the node is first child of its parent
                // reconnect parent to its next sibling

                curr.parent.firstChild = curr.sibling;
            } else{
                // the node is not the first child

                SLLNode<E> tmp = curr.parent.firstChild;
                while(tmp.sibling != curr){
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }

        }
        else{
            root = null;
        }
    }
    class SLLTreeChildIterator<T> implements Iterator<T> {
        SLLNode<T> start, current;
        public SLLTreeChildIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }
        public boolean hasNext() {
            return (current != null);
        }
        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }
    }


    // pecatenje na jazli rekurzivo i
    // printanje onolku prazni mesta kolku sto e nivoto na drvoto

    public void printNodesRecursively(Node<E> node, int level){
        if(node == null)
            return;

        int i;
        SLLNode<E> tmp;

        for(i = 0; i < level; i++){
            System.out.print(" ");
        }
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>) node).firstChild;
        while(tmp != null){
            printNodesRecursively(tmp, level +1);
            tmp = tmp.sibling;
        }
    }
    public void printTree(){
        printNodesRecursively(root, 0);
    }

    public int countMaxChildrenRecursivelly(SLLNode<E> node){
        SLLNode<E> tmp = node.firstChild;
        int max = childCount(node);
        while(tmp != null){
            max = Math.max(max, countMaxChildrenRecursivelly(tmp));
            tmp = tmp.sibling;
        }
        return max;
    }
    public int countMaxChildren(){
       return countMaxChildrenRecursivelly(root);
    }
    public static void main(String[] args) {
        Tree.Node<String> a,b,c,d;
        SLLTree t = new SLLTree();
        t.makeRoot("C:");
        a = t.addChild(t.root, "Program files");
        b = t.addChild(a, "CodeBlocks");
        c = t.addChild(b, "codeblocks.dll");
        c = t.addChild(b, "codeblocks.exe");
        b = t.addChild(a, "Nodepad++");
        c = t.addChild(b, "langs.xml");
        c = t.addChild(b, "notepad++.exe");
        a = t.addChild(t.root, "Users");
        b = t.addChild(a, "Darko");
        c = t.addChild(b, "Desktop");
        c = t.addChild(b, "Downloads");
        c = t.addChild(b, "My Documents");
        c = t.addChild(b, "My Pictures");
        b = t.addChild(a, "Public");
        a = t.addChild(t.root, "Windows");
        b = t.addChild(a, "Media");
        t.printTree();
        System.out.println("Stepenot na drvoto e: " + t.countMaxChildren());
    }

}
