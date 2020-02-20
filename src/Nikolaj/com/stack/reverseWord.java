package Nikolaj.com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseWord {
    public static String reverse(String s){
        ArrayStack<Character> stek = new ArrayStack<>(100);
        if(s.length() > 100){
            return "Pregolem zbor";
        }
        else{
            for(int i = 0; i < s.length(); i++){
                stek.push(Character.toLowerCase(s.charAt(i)));
            }
            StringBuilder prevrtenZbor = new StringBuilder();
            for(int i = 0; i < s.length();i ++){
                prevrtenZbor.append(stek.pop());
            }
            return prevrtenZbor.toString();
        }
    }
    public static boolean palindrome(String s){
        return s.toLowerCase().equals(reverse(s));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String citaj = br.readLine();
        System.out.println("Zborot " + citaj + " e palindrom: " + palindrome(citaj));
    }
}
