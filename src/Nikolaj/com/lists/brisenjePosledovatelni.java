package Nikolaj.com.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class brisenjePosledovatelni {
    public static void brisiPosledovatelni(SLL<Integer> list) throws Exception {
        SLLNode<Integer> node = list.getFirst();
        SLLNode<Integer> helper = list.getFirst();

        while(node.succ != null || helper == null){
            helper = helper.succ;
            if(node.element % 2 == 0 && helper.element % 2 == 0){
                list.delete(helper);
                if(node.succ != null) {
                    node = node.succ;
                    helper = node;
                }
            }else if(node.element % 2 == 1 && helper.element % 2 == 1){
                list.delete(helper);
                if(node.succ != null) {
                    node = node.succ;
                    helper = node;
                }
            }
            else{
                node = node.succ;
            }
        }
    }

    public static void main(String[] args) throws Exception {
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

        brisiPosledovatelni(lista);
        System.out.println(lista.toString());
    }
}
