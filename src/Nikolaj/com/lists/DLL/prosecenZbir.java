package Nikolaj.com.lists.DLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prosecenZbir {
    public static void prosecenZbir(DLL<Integer> lista1, DLL<Integer> lista2){
        DLLNode<Integer> tmp = lista1.getFirst();
        int suma = 0;
        int brElem = 0;
        while(tmp != null){
            suma += tmp.element;
            brElem ++;
            tmp = tmp.succ;
        }
        // naogjas prosek na prva lista
        double prosek1 = suma/ (double) brElem;

        brElem = 0;
        suma = 0;
        tmp = lista2.getFirst();
        while(tmp != null){
            brElem ++;
            suma += tmp.element;
            tmp = tmp.succ;
        }
        // naogas prosek na vtora lista
        double prosek2 = suma/ (double) brElem;

        // vnesuvas od prva lista
        brElem = 0;
        tmp = lista1.getFirst();
        DLL<Integer> novaLista = new DLL<>();
        // vnesuvas od prva lista
        double vkupenZbir = prosek1 + prosek2;
        int zbirElems = 0;
        while(zbirElems < vkupenZbir){
            if((zbirElems += tmp.element) > vkupenZbir){
                break;
            }
            novaLista.insertLast(tmp.element);

            tmp = tmp.succ;

        }

        // vnesuvas od vtora lista
        brElem = 0;
        tmp = lista2.getLast();
        zbirElems = 0;
        while(zbirElems < vkupenZbir){
            if((zbirElems += tmp.element) > vkupenZbir){
                break;
            }
            novaLista.insertLast(tmp.element);

            tmp = tmp.pred;

        }
        System.out.println(novaLista.toString());


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista1 = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();
        String cita = br.readLine();
        String[] elem = cita.split("\\s+");
        int[] elems = new int[elem.length];
        for(int i = 0; i < elem.length;i++){
            elems[i] = Integer.parseInt(elem[i]);
        }

        for(int i = 0; i < elems.length;i++){
            lista1.insertLast(elems[i]);
        }


        cita = br.readLine();
        elem = cita.split("\\s+");
        elems = new int[elem.length];
        for(int i = 0; i < elem.length;i++){
            elems[i] = Integer.parseInt(elem[i]);
        }

        for(int i = 0; i < elems.length;i++){
            lista2.insertLast(elems[i]);
        }
        prosecenZbir(lista1,lista2);
    }
}
