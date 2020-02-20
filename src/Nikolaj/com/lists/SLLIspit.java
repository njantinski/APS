package Nikolaj.com.lists;

import java.util.Scanner;

// napisi funkcija kojasto ke ja izmeni listata taka sto
// ke bide vo format
// ao an a1 an-1 itn
public class SLLIspit {

    public static void izmeniLista(SLL<Integer> list){
        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> tmp1 = list.getFirst();
        SLLNode<Integer> brojac1 = list.getFirst();

        while(tmp.succ != null){
            brojac1 = tmp;
            while(tmp1.succ != null){
                tmp1 = tmp1.succ;

            }
            while(brojac1.succ != tmp1){
                brojac1 = brojac1.succ;

            }
            tmp1.succ = tmp.succ;
            tmp.succ = tmp1;
            brojac1.succ = null;
            if(tmp.succ == null ) {
                break;
            }
            tmp = tmp.succ.succ;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Integer> list = new SLL<>();
        System.out.println("Vnesi kolku elementi sakas da ima vo listata");
        int n = sc.nextInt();
        System.out.println("Vnesi gi elementite vo listata:");
        for(int i = 0; i < n; i++){
            list.insertLast(sc.nextInt());
        }
        System.out.println("Vnesenata lista e: ");

        System.out.println(list.toString());

        izmeniLista(list);
        System.out.println("Izmenetata lista e: ");
        System.out.println(list.toString());
    }
}
