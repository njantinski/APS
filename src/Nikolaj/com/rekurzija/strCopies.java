package Nikolaj.com.rekurzija;

public class strCopies {
    public static boolean strCopies(String str, String sub, int n){
        if(str.length() < sub.length()){
            if(n == 0)
                return true;
            return false;
        }
        if(str.substring(0,sub.length()).equals(sub)){
            return strCopies(str.substring(1),sub, n -1);
        }
        else return strCopies(str.substring(1),sub, n );
    }

    public static void main(String[] args) {
        System.out.println(strCopies("catcowcat", "cat", 2));
    }
}
