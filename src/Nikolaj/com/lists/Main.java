package Nikolaj.com.lists;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vnesi go brojot na clenovi na prviot polinom: ");
       // Integer g2 = new Integer(scanner.nextLine());
       int g1 = scanner.nextInt();
       scanner.nextLine();

        Array<Integer> nizaPolinom1 = new Array<Integer>((g1*2)+1);
        nizaPolinom1.set(0,g1);
        System.out.println("Vnesi go prvo koeficientot, a potoa stepenot na clenot vo polinomit: ");
        for(int i = 1; i<= 2*g1; i+=2){
            int br1 = scanner.nextInt();
            nizaPolinom1.set(i,br1);
            scanner.nextLine();
            br1= scanner.nextInt();
            scanner.nextLine();
            nizaPolinom1.set(i+1,br1);

        }
        Polinom polinom1 = new Polinom(nizaPolinom1);
        System.out.println(polinom1.toString());

        System.out.println("Vnesi go brojot na clenovi na vtoriot polinom: ");

        g1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println(g1);
        Array<Integer> nizaPolinom2 = new Array<Integer>((g1*2)+1);
        nizaPolinom2.set(0,g1);
        System.out.println("Vnesi go prvo koeficientot, a potoa stepenot na clenot vo polinomit: ");
        for(int i = 1; i<= 2*g1; i+=2){
            int br1 = scanner.nextInt();
            nizaPolinom2.set(i,br1);
            scanner.nextLine();
            br1= scanner.nextInt();
            scanner.nextLine();
            nizaPolinom2.set(i+1,br1);
        }
        System.out.println(nizaPolinom2.get(0));
        Polinom polinom2 = new Polinom(nizaPolinom2);
        System.out.println(polinom2.toString());

        Polinom zbir = polinom1.sobiranjePolinomi(polinom2);
        System.out.println(zbir.toString());

        }
    }
/*
3
        Vnesi go prvo koeficientot, a potoa stepenot na clenot vo polinomit:
        3
        3
        2
        1
        4
        0
        3x^3 2x^1 4x^0
        Vnesi go brojot na clenovi na vtoriot polinom:
        3
        3
        Vnesi go prvo koeficientot, a potoa stepenot na clenot vo polinomit:
        4
        4
        1
        3
        3
        1
        3*/
