package Nikolaj.com.lists;

public class pairWiseSwap {
    public static void swap(SLL<Integer> list){
        SLLNode<Integer> first = list.getFirst();
        SLLNode<Integer> succ;
        SLLNode<Integer> newFirst;
        SLLNode<Integer> prev = null;


        while(first != null && first.succ != null){
            succ = first.succ;
            newFirst = succ.succ;

            first.succ = newFirst;
            succ.succ = first;
            if(prev == null){
                list.setFirst(succ);
            }
            if(prev != null){

                prev.succ = succ;
            }
            prev = first;
            first = newFirst;


        }
    }

    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();

        for(int i = 0; i < 11; i++)
            list.insertLast(i);
        System.out.println(list.toString());

        swap(list);
        System.out.println(list.toString());

    }
}
