package Nikolaj.com.rekurzija;

public class noX {
    public static String noX(String str){
        if(str.length() == 0)
            return str;

        else{
            if(str.charAt(0) == 'x')
                return noX(str.substring(1));
            else
                return str.charAt(0) + noX(str.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(noX("xnxx"));
    }
}
