package Nikolaj.com.rekurzija;

public class fibDynamic {
    public static int fibDynamic(int br, int[] fibNiza){
        if(fibNiza[br] != 0){
            return fibNiza[br];
        }
        else{
            if(br == 1 || br == 2)
                return 1;
            else {
                int rez = fibDynamic(br - 1,fibNiza) + fibDynamic(br - 2,fibNiza);
                fibNiza[br] = rez;
                return rez;
            }
        }
    }

    public static void main(String[] args) {
        int[] niza = new int[31];
        System.out.println(fibDynamic(30,niza));
    }
}
