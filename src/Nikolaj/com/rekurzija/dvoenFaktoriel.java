package Nikolaj.com.rekurzija;

public class dvoenFaktoriel {
    public static int dvoenFaktoriel(int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        else{
            return n * dvoenFaktoriel(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(dvoenFaktoriel(6));
    }
}
