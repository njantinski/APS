package Nikolaj.com.lists;

import java.util.Scanner;

public class PodeliLista {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        SLL<Integer> lista = new SLL();
        System.out.println("Vnesi elementi na listata");
        int elementi = sc.nextInt();

        System.out.println("Vnesi gi elementite na listata:");
        for(int i =0 ; i< elementi; i++){
            lista.insertLast(sc.nextInt());
        }
        System.out.println("Vnesi spored koj element sakas da bide podelena listata");
        int podelba = sc.nextInt();

        podeli(lista, podelba);
        System.out.println(lista.toString());
    }
    public static void podeli(SLL<Integer> lista, int n) throws Exception {
        int dolz = lista.length();
        lista.insertLast(n);

        SLLNode<Integer> node = lista.getFirst();
        SLLNode<Integer> tmp = node;

        for(int i = 0; i < dolz - 1; i++){
            if(node.element >= n){
                System.out.println("Node has the element: " + node.element);
                lista.insertLast(node.element);
                tmp = tmp.succ;

                lista.delete(node);
                node = tmp;
            }
            else{
                node = node.succ;
                tmp = node;
            }
        }
    }
}
