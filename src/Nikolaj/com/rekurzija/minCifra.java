package Nikolaj.com.rekurzija;

public class minCifra {
    public static int minCifra(int n){
        if(n < 10)
            return n;
        else{
            int min = minCifra(n/10);
            if(min < n%10)
                return min;
            else return n%10;
        }
    }

    public static void main(String[] args) {
        System.out.println(minCifra(133455510));
    }
}
