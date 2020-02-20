package Nikolaj.com.rekurzija;

public class countABC {
    public static int countABC(String str){
        if(str.length() < 3)
            return 0;
        if(str.substring(0,3).equals("abc"))
            return 1 + countABC(str.substring(3));
        if(str.substring(0,3).equals("aba"))
            return 1 + countABC(str.substring(3));
        return countABC(str.substring(1));


    }

    public static void main(String[] args) {
        System.out.println(countABC("abaxxaba"));
    }
}
