package Nikolaj.com.lists;

public class DivideListByNumber {
    public void Divide(SLL<Integer> lista, int n){
        SLLNode<Integer> tmp1 = lista.getFirst();
        SLLNode<Integer> tmp2 = lista.getFirst();
        int counter = lista.getLength();

        lista.insertLast(n);

        for(int i = 0; i < counter; i++){
            if(tmp1.element.compareTo(n) == 1){
                lista.insertLast(tmp1.element);
                tmp2 = tmp2.succ;
                try {
                    lista.delete(tmp1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tmp1 = tmp2;
            }
            else if(tmp1.element.compareTo(n) == -1){
                tmp1 = tmp1.succ;
                tmp2 = tmp2.succ;

            }
            else{
                tmp2 = tmp2.succ;
                try {
                    lista.delete(tmp1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tmp1 = tmp2;
            }
        }


    }
}
