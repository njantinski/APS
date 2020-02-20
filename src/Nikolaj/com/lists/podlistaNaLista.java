package Nikolaj.com.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class podlistaNaLista {
    public static boolean proveriPodlista(SLL<Integer> lista, SLL<Integer> podlista, int dolzinaLista, int dolzinaPodlista){
        if(dolzinaPodlista > dolzinaLista){
            return false;
        }
        else{
            SLLNode<Integer> first = lista.getFirst();
            SLLNode<Integer> podListaFirst = podlista.getFirst();
            SLLNode<Integer> tmpNode = lista.getFirst();
            while(first != null){
                if(first.element == podListaFirst.element){
                    if(first == podlista.getFirst()){
                        first = tmpNode;
                    }
                    first = first.succ;
                    if(podListaFirst.succ == null){
                        return true;
                    }
                    podListaFirst = podListaFirst.succ;
                }else{
                    first = tmpNode.succ;
                    tmpNode = tmpNode.succ;
                    podListaFirst = podlista.getFirst();
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        int brLista;
        int brPodLista;

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

                System.out.println("Vnesi broj na clenovi na podlistata");

        citac = br.readLine();
        brPodLista = Integer.parseInt(citac);

        System.out.println("Vnesi gi elementite vo podlistata oddeleni so prazno mesto");
        citac = br.readLine();
        broevi = citac.split("\\s+");
        elementiLista = new int[broevi.length];
        for(int i = 0; i < broevi.length; i++){
            elementiLista[i] = Integer.parseInt(broevi[i]);
        }
        SLL<Integer> podLista = new SLL<>();
        for(int brojce : elementiLista){
            podLista.insertLast(brojce);
        }

        System.out.println(proveriPodlista(lista,podLista,brLista,brPodLista));




    }
}
