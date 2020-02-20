package Nikolaj.com.rekurzija;

public class poramnuvanje {
    public static int poramnuvanje(int br){
        if(br < 10){
            if(br == 9)
                return 7;
            else return br;
        }
        else{
            int a = br%10;
            if(a == 9)
                a = 7;
            return a + poramnuvanje(br/10) * 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(poramnuvanje(934795));
    }
}
