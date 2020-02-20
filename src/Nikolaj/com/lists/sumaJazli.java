package Nikolaj.com.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class sumaJazli {
    public static void sumaJazli(SLL<Integer> lista, int m,int n){
        int brojac = 0;
        SLLNode<Integer> node = lista.getFirst();

        while(brojac < m){
            node = node.succ;
            brojac++;
        }
        int suma = 0;
        while(brojac <= n){

            suma += node.element;
            node = node.succ;
            brojac ++;
        }

        node = lista.getFirst();
        brojac = 0;
        while(node != null || node.succ != null){
            lista.insertAfter(suma,node);
            node = node.succ;
            if(node.succ.succ != null){
                node.succ = node.succ.succ;
            }
            else{
                node.succ = null;
                break;
            }
            node = node.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        int brLista;

        System.out.println("Vnesi broj na clenovi na listata");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String citac = br.readLine();
        brLista = Integer.parseInt(citac);


        System.out.println("Vnesi gi elementite vo listata oddeleni so prazno mesto");
        citac = br.readLine();
        String[] broevi = citac.split("\\s+");
        int[] elementiLista = new int[broevi.length];
        for(int i = 0; i < broevi.length; i++){
            elementiLista[i] = Integer.parseInt(broevi[i]);
        }
        SLL<Integer> lista = new SLL<>();
        for(int brojce : elementiLista){
            lista.insertLast(brojce);
        }
        System.out.println("Vnesi go brojot na elementite megju koi sakas da se presmeta suma");
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        sumaJazli(lista,m,n);
        System.out.println(lista.toString());
    }
}
