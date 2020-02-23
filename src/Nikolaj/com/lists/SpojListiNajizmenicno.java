package Nikolaj.com.lists;

import java.util.Scanner;

public class SpojListiNajizmenicno {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SLL<Integer> lista1 = new SLL();
        System.out.println("Vnesi br elementi na prvata lista");
        int elementi = sc.nextInt();

        System.out.println("Vnesi gi elementite na listata:");
        for (int i = 0; i < elementi; i++) {
            lista1.insertLast(sc.nextInt());
        }
        SLL<Integer> lista2 = new SLL();
        System.out.println("Vnesi br elementi na vtorata lista");
        elementi = sc.nextInt();

        System.out.println("Vnesi gi elementite na listata:");
        for (int i = 0; i < elementi; i++) {
            lista2.insertLast(sc.nextInt());
        }
        System.out.println("Novata lista e: ");
        spojListi(lista1, lista2);
        System.out.println(lista1.toString());

    }


        public static SLL<Integer> spojListi(SLL<Integer> list1,
                                         SLL<Integer> list2){
        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();
        int counter1 = 0, counter2 = 0;
        boolean flag = true;

        while(node1 != null && node2 != null){
            while(counter1 < 2 && node1 != null){
                if(flag == true){
                    flag = false;
                    counter1++;
                    continue;
                }
                node1 = node1.succ;
                counter1++;
            }
            while(counter2 < 2 && node2 != null && node1 != null){
                list1.insertAfter(node2.element,node1);
                node2 = node2.succ;
                node1 = node1.succ;
                counter2++;

            }
            counter1 = 0;
            counter2 = 0;

        }

        if(node2 != null){
            while(node2 != null) {
                list1.insertLast(node2.element);
                node2 = node2.succ;
            }
        }


        return list1;
    }
}
