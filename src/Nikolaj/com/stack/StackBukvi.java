package Nikolaj.com.stack;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class StackBukvi {

    public static int proveri_t_posle_s(char [] St) {
        ArrayStack<Character> stek = new ArrayStack<>(50);
        boolean paren = true;
        for(int i = 0; i < St.length; i++){
            if(St[i] == 'S'){
                if(paren){
                    if(!stek.isEmpty())
                    if(stek.peek() == 'T')
                        return 0;

                    stek.push(St[i]);
                    paren = false;
                }
                else if(!paren){
                    paren = true;
                }
            }
            if(St[i] == 'T'){
                if(paren){
                    if(stek.isEmpty())
                        return 0;
                    stek.pop();
                }
                if(!paren)
                    stek.push(St[i]);
            }
        }
        if(!stek.isEmpty()) {
            if(!(stek.pop() == 'S'))
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        char [] niza=new char[100];

        Scanner f=new Scanner(System.in);
        String st=f.next();
        niza=st.toCharArray();

        int rez= proveri_t_posle_s(niza);
        System.out.println(rez);
    }


}