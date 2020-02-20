package Nikolaj.com.stack;

import java.io.*;
import java.util.Scanner;

public class MatematickiIzraz {
    public static int presmetaj(String izraz){
        String number = "";
        boolean flagMnozi = false;
        ArrayStack<Integer> stek = new ArrayStack<>(100);
        for(int i = 0; i < izraz.length(); i++){
            if(Character.isDigit(izraz.charAt(i))){
                number += izraz.charAt(i);
            }
            if(izraz.charAt(i) == '+' || izraz.charAt(i) == '*'){
                stek.push(Integer.parseInt(number));
                number = "";
                if(flagMnozi){
                    stek.push(stek.pop()* stek.pop());
                    flagMnozi = false;
                }
                if(izraz.charAt(i) == '*'){
                    flagMnozi = true;
                }
            }
            if(i == izraz.length() - 1){
                if(flagMnozi){

                    stek.push(stek.pop()* Integer.parseInt(number));
                    flagMnozi = false;
                }
                else{
                    stek.push(Integer.parseInt(number));
                }
            }
        }

        while(true){
            int n = stek.pop();
            if(stek.isEmpty())
                return n;
            stek.push(n + stek.pop());
        }
    }

    public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      String izraz = sc.nextLine();

        System.out.println(presmetaj(izraz));
    }

}
