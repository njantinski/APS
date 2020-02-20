package Nikolaj.com.rekurzija;

public class maxCifra {

    public static int maxCifra(int n){
        if(n < 10)
            return n;
        else{
         int max = maxCifra(n / 10);
         if(n % 10 > max)
             return n%10;
         else return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxCifra(23));
    }

}
