package Nikolaj.com.rekurzija;

public class endX {
    public static String endX(String str){
        if(str.length() < 1)
            return "";
        else if(str.charAt(0) != 'x')
            return str.charAt(0) + endX(str.substring(1));
        else{
            return endX(str.substring(1) ) + 'x';
        }
    }

    public static void main(String[] args) {
        System.out.println(endX("xxre"));
    }
}
