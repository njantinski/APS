package Nikolaj.com.queue;

import Nikolaj.com.lists.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kolokvium_g2 {
    public static void kolokviumG2(ArrayQueue<String> asistenti,ArrayQueue<String> predmeti
    ,ArrayQueue<Integer> brAsistenti, ArrayQueue<String> otsutniAsistenti){


        while(!predmeti.isEmpty()){
            System.out.println(predmeti.dequeue());
            int br = brAsistenti.dequeue();
            System.out.println(br);


            int i = 0;
            while(i < br){
                if(proveriOtsuten(asistenti.peek(), otsutniAsistenti)){
                    asistenti.enqueue(asistenti.dequeue());
                }
                else{
                    System.out.println(asistenti.peek());
                    asistenti.enqueue(asistenti.dequeue());
                    i++;
                }
            }
        }
    }

    private static boolean proveriOtsuten(String asistent, ArrayQueue<String> otsutniAsistenti){
        String otsuten = otsutniAsistenti.dequeue();
        otsutniAsistenti.enqueue(otsuten);
        if(otsuten.equals(asistent)){
            return true;
        }
        else{
            while(!otsutniAsistenti.peek().equals(otsuten)){
                if(otsutniAsistenti.peek().equals(asistent)){
                    return true;
                }
                else{
                    otsutniAsistenti.enqueue(otsutniAsistenti.dequeue());
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayQueue<String> asistenti = new ArrayQueue<>(100);
        ArrayQueue<String> otsutniAsistenti = new ArrayQueue<>(100);
        ArrayQueue<String> predmeti = new ArrayQueue<>(100);
        ArrayQueue<Integer> brAsistentiPredmet = new ArrayQueue<>(100);
        int brPredmeti = 0;
        int brOtsutni;


        System.out.println("Vnesi br na asistenti");
        int brAsistenti = Integer.parseInt(br.readLine());
        System.out.println("Vnesi gi asistentite po redosled: najmal -> najstar");

        for(int i = 0; i < brAsistenti; i++){
            asistenti.enqueue(br.readLine());
        }

        System.out.println("Vnesi br na predmeti");
        brPredmeti = Integer.parseInt(br.readLine());

        System.out.println("Vnesi go imeto na predmetot i brojot na potrebni asistenti razdeleni so prazno mesto");

        for(int i = 0; i < brPredmeti; i++){
            String[] vnes = br.readLine().split("\\s+");
            predmeti.enqueue(vnes[0]);
            brAsistentiPredmet.enqueue(Integer.parseInt(vnes[1]));
        }

        System.out.println("Vnesi broj na otsutni asistenti, a potoa vnesi gi nivnite iminja");
        brOtsutni = Integer.parseInt(br.readLine());

        for(int i = 0; i < brOtsutni;i++){
            otsutniAsistenti.enqueue(br.readLine());
        }
        kolokviumG2(asistenti,predmeti,brAsistentiPredmet,otsutniAsistenti);
    }
}
