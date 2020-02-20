package Nikolaj.com.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Konsultacii_g3 {
    private static void konsultacii(ArrayQueue<String> prasanje, ArrayQueue<String> zadaca,
                                    ArrayQueue<String> prasanjeZadaca){
        boolean samoPrasanja = true;

        while(!prasanje.isEmpty() || !zadaca.isEmpty() || !prasanjeZadaca.isEmpty()){
            // se prima student so kratko prasanje
            if(!prasanje.isEmpty()){
                System.out.println(prasanje.dequeue());
            }
            // ako nema se prima student so kratko prasanje i zadaca
            // i se stava na kraj od redicata so zadaci
            else if( !prasanjeZadaca.isEmpty()){
                String studentZadaca = prasanjeZadaca.dequeue();
                zadaca.enqueue(studentZadaca);
                System.out.println();
            }
            // po ova 1 student prasal prasanje i sega e na red
            // student so zadaci
            if(!zadaca.isEmpty()){
                System.out.println(zadaca.dequeue());
            }
            // ako nema student so zadaci, se zema student so prasanja i
            // zadaci i po usluzuvanjeto se stava na kraj od redicata so prasanja
            else if(!prasanjeZadaca.isEmpty()){
                String studentPrasanje = prasanjeZadaca.dequeue();
                System.out.println(studentPrasanje);
                prasanje.enqueue(studentPrasanje);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int brPrasanja, brZadaci, brPrasanjaZadaci;


        ArrayQueue<String> prasanje = new ArrayQueue<>(100);
        ArrayQueue<String> zadaci = new ArrayQueue<>(100);
        ArrayQueue<String> prasanjeZadaci = new ArrayQueue<>(100);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vnesi br na studenti za prasanja");
        brPrasanja = Integer.parseInt(br.readLine());


        System.out.println("vnesi gi studentite za prasanja");
        for(int i = 0; i < brPrasanja; i++){
            prasanje.enqueue(br.readLine());
        }

        System.out.println("Vnesi br na studenti za zadaci");
        brZadaci = Integer.parseInt(br.readLine());

        System.out.println("vnesi gi studentite za zadaci");
        for(int i = 0; i < brZadaci; i++){
            zadaci.enqueue(br.readLine());
        }


        System.out.println("Vnesi br na studenti za prasanja i zadaci");
        brPrasanjaZadaci = Integer.parseInt(br.readLine());
        for(int i = 0; i < brPrasanjaZadaci; i++){
            prasanjeZadaci.enqueue(br.readLine());
        }

        konsultacii(prasanje, zadaci, prasanjeZadaci);
    }
}
