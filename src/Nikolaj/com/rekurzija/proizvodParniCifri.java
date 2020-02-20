package Nikolaj.com.rekurzija;

public class proizvodParniCifri {
    public static int proizvodParni(int broj){
        if(broj < 1000)
            return (broj/10) % 10;
        else {
            return (broj / 10) % 10 * proizvodParni(broj / 100);
        }
    }

    public static void main(String[] args) {
        System.out.println(proizvodParni(301030));
    }
}
