package Nikolaj.com.lists;



import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

class SLLNode<E>{
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E element, SLLNode<E> succ) {
        this.element = element;
        this.succ = succ;
    }
}
class SLL<E>{
    private SLLNode<E> first;

    public SLL() {
        this.first = null;
    }
    public void insertFirst(E o){
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void setFirst(SLLNode<E> first) {
        this.first = first;
    }

    public void insertAfter(E o, SLLNode<E> after){
        SLLNode<E> tmp = new SLLNode<E>(o,after.succ);
        after.succ = tmp;
    }

    public void insertBefore(E o, SLLNode<E> before){
        if(first != null){
            SLLNode<E> tmp = first;
            if( first == before){
                this.insertFirst(o);
            }
            while(tmp.succ != before){
                tmp = tmp.succ;
                if(tmp.succ == before){
                    SLLNode<E> ins = new SLLNode<E>(o,before);
                    tmp.succ = ins;
                }
                else System.out.println("ELementot ne postoi vo nizata");
                }
            }
        else System.out.println("Nizata e prazna");
        }

    public void lastElementFirst(){
        SLLNode<E> tmp = getFirst();
        SLLNode<E> tmp1 = getFirst();
        boolean flag = true;
        while(tmp != null) {
            tmp = tmp.succ;
            if(flag){
                flag = false;
                continue;
            }
            tmp1 = tmp1.succ;
        }

        tmp.succ = getFirst();
        tmp1.succ = null;
    }




    public E deleteFirst(){
        if(first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        }
        return null;
    }
    public E delete(SLLNode<E> Node) throws Exception {
        if(first == null)
            deleteFirst();
       else if(first != null){
            SLLNode<E> tmp = first;
            if(first ==  Node)
                deleteFirst();
            while(tmp.succ != Node && tmp.succ.succ != null) {
                    tmp = tmp.succ;
            }
            if(tmp.succ == Node){
                    tmp.succ = tmp.succ.succ;
                }

            }
        else throw new Exception("No such element");
        return Node.element;
        }
    public SLLNode<E> getFirst(){
        return first;
    }
    public int getLength(){
        int length = 0;
        if(first != null){
            SLLNode<E> counter = first;
            while(counter != null){
                counter = counter.succ;
                length++;
            }
        }
        return length;
    }
    public void insertLast(E o){
        if(first != null){
            SLLNode<E> tmp = first;
            while(tmp.succ != null){
                tmp = tmp.succ;
            }
            SLLNode<E> insert = new SLLNode<E>(o,null);
            tmp.succ = insert;
        }
        else insertFirst(o);
    }

    public SLLNode<E> find (E o) throws Exception {
       if(first != null){
           SLLNode<E> tmp = first;
           while(tmp.succ != null && tmp.element != o) {
               tmp = tmp.succ;
           }
               if(tmp.element == o)
                   return tmp;
               else {
                   System.out.println("Ne postoi takov element");
                   return null;
               }
       }
       else System.out.println("Listata e prazna");
        return null;
    }
    public void merge(SLL<E> lista){
        if(first != null){
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = lista.getFirst();
        }
        else
            first = lista.getFirst();
    }


    // prasaj za ova
    public void reverseList(){
        if(first != null){
            SLLNode<E> tmp = first;
            SLLNode<E> newSucc = null;
            SLLNode<E> succ;
            while(tmp != null){
                succ = tmp.succ;
                tmp.succ = newSucc;
                newSucc = tmp;
                tmp = succ;
            }
            first = newSucc;
        }
    }

    public SLLNode<E> findNthNode(int n){
        if(n == 1)
            return first;
        else{
            SLLNode<E> tmp = first;
            int counter = 1;
            while(tmp != null && counter != n){
                tmp = tmp.succ;
                counter++;
            }
            if(tmp == null){
                System.out.println("The list haven't that number of elements");
                return null;
            }
            else{
                System.out.println("The " + counter + " element in the array is: "
                        + tmp);
                return tmp;
            }
        }
    }
    public int countElement(E o){
        int counter = 0;
        if(first == null){
            return counter;
        }
        else{
            SLLNode<E> tmp = first;
            while(tmp !=null){
                if(tmp.element == o)
                    counter++;
                tmp = tmp.succ;
            }
            return counter;
        }
    }

    public SLLNode<E> nthElementFromBehind(int n)throws Exception{
        SLLNode<E> tmp = getFirst();
        int counter = 0;
        while(tmp != null ){
            tmp = tmp.succ;
            counter ++;
        }
        if(n > counter)
            throw new Exception("There are less elements than entered in " +
            "the list");
        int realCounter = counter - n;
        counter = 0;
        tmp = getFirst();
        while(counter != realCounter){
            tmp = tmp.succ;
            counter++;
        }
        return tmp;
    }


    //prasaj za iteratorov
    public Iterator<E> iterator(){
        return new LRIterator<E>();
    }




    private class LRIterator<E> implements Iterator<E>{
        private SLLNode<E> place, prev, curr;

        private LRIterator(){
            place = (SLLNode<E>) first;
            curr = prev =null;
        }
        public boolean hasNext(){
            return (place != null);
        }
        public E next(){
            if(place == null)
                throw new NoSuchElementException();
            E nextElement = place.element;
            prev = curr;
            curr = place;
            place = place.succ;
            return nextElement;
        }

    }
    public int length(){
        SLLNode<E> tmp = getFirst();
        int counter = 0;
        while(tmp != null){
            tmp = tmp.succ;
            counter ++;
        }
        return counter;
    }

    public String toString(){
        String ret = "";
        SLLNode<E> tmp = getFirst();
        while(tmp != null){
            ret += tmp.element.toString();
            if(tmp.succ != null)
                ret += " ->";
            tmp = tmp.succ;
        }
        return ret;
    }
}


class JoinSortedLists<E extends Comparable<E>>{
    public SLL<E> join(SLL<E> list1,  SLL<E> list2){
        SLL<E> newJoinedList = new SLL<E>();
        SLLNode<E> prvaListaJazol = list1.getFirst();
        SLLNode<E> vtoraListaJazol = list2.getFirst();

        while(prvaListaJazol != null && vtoraListaJazol != null){
            if((prvaListaJazol.element.compareTo(vtoraListaJazol.element)) == -1){
                newJoinedList.insertLast(prvaListaJazol.element);
                prvaListaJazol = prvaListaJazol.succ;
            }
            else if((prvaListaJazol.element.compareTo(vtoraListaJazol.element)) == 1){
                newJoinedList.insertLast(vtoraListaJazol.element);
                vtoraListaJazol = vtoraListaJazol.succ;
            }
            else {
                newJoinedList.insertLast(vtoraListaJazol.element);
                vtoraListaJazol = vtoraListaJazol.succ;
                prvaListaJazol = prvaListaJazol.succ;

            }
        }
        if(prvaListaJazol != null){
            while(prvaListaJazol != null){
                newJoinedList.insertLast(prvaListaJazol.element);
                prvaListaJazol = prvaListaJazol.succ;
            }
        }
        if(vtoraListaJazol != null){
            while(vtoraListaJazol != null){
                newJoinedList.insertLast(vtoraListaJazol.element);
                vtoraListaJazol = vtoraListaJazol.succ;
            }

        }
        return newJoinedList;
    }

}


public class ListaAud {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int brLista;

        System.out.println("Vnesi br na clenovi na listata");
        brLista = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Vnesi gi clenovite na listata:");

        SLL lista1 = new SLL();

        for(int i = 0; i < brLista; i++){
            lista1.insertLast(scanner.nextInt());
            scanner.nextLine();
        }

        System.out.println("Vnesenata lista e: ");
        SLLNode<Integer> tmp = new SLLNode<>(lista1.getFirst().element, lista1.getFirst().succ);
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.succ;
        }

        System.out.println("Vnesi spored koj sakas listata da se podeli");

        int brojce = scanner.nextInt();
        DivideListByNumber deli = new DivideListByNumber();
        deli.Divide(lista1,brojce );


        System.out.println("Vnesenata lista e: ");
        tmp = new SLLNode<>(lista1.getFirst().element, lista1.getFirst().succ);
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.succ;
        }
       /* System.out.println("Vnesi go elementot koj sakas da bide prv");

        int br = scanner.nextInt();
        scanner.nextLine();

        lista1.insertFirst(br);

        tmp = new SLLNode<>(lista1.getFirst().element, lista1.getFirst().succ);
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.succ;
        }


        System.out.println("Vnesi br na clenovi na vtorata lista");
        brLista = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Vnesi gi clenovite na listata:");

        SLL lista2 = new SLL();

        for(int i = 0; i < brLista; i++){
            lista2.insertLast(scanner.nextInt());
            scanner.nextLine();
        }

        System.out.println("Vnesenata lista e: ");
       tmp = new SLLNode<>(lista2.getFirst().element, lista2.getFirst().succ);
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.succ;
        }

        System.out.println("Dvete listi spoeni se: ");
        lista1.merge(lista2);
        tmp = lista1.getFirst();
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.succ;
        }
       // System.out.println(lista1.findNthNode(3).element);
        System.out.println("Listata prevrtena naopaku e: ");
        lista1.reverseList();
        tmp = lista1.getFirst();
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.succ;
        }*/
    }
}
