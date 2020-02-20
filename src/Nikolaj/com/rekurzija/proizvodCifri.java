package Nikolaj.com.rekurzija;

import org.w3c.dom.ls.LSOutput;

public class proizvodCifri {
    public static int proizvodCifri(int n){
        if(n < 10)
            return n;
        else return n%10 * proizvodCifri(n/10);
    }

    public static void main(String[] args) {
        System.out.println(proizvodCifri(33)/(double)33);
    }
}