package Nikolaj.com.rekurzija;

public class stringClean {
    public static String stringClean(String str){
        if(str.length() < 3) {
            if(str.charAt(0) == str.charAt(1))
                return Character.toString(str.charAt(0));
            return Character.toString(str.charAt(0)) + Character.toString(str.charAt(1));
        }
        else{
            if(str.charAt(0) == str.charAt(1))
                return stringClean(str.substring(1));
            else
                return str.charAt(0) + stringClean(str.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(stringClean("yyzzza"));
    }
}
