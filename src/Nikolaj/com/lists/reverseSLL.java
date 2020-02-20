package Nikolaj.com.lists;

public class reverseSLL {
    public static void reverseSLL(SLL<Integer> list){
        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> tmpNew = null;
        SLLNode<Integer> newSucc = null;
        while(tmp != null){
            tmpNew = tmp.succ;
            tmp.succ = newSucc;
            newSucc = tmp;
            tmp = tmpNew;
        }
        list.setFirst(newSucc);
    }

    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();
        for(int i = 0; i < 3; i++)
            list.insertLast(i);
        reverseSLL(list);
        //list.reverseList();
        System.out.println(list.toString());
    }

}
