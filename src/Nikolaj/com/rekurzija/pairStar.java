package Nikolaj.com.rekurzija;

public class pairStar {
    public static String pairStar(String str){
        if(str.length() < 2)
            return str;
        else if(str.charAt(0) != str.charAt(1))
            return str.substring(0,1) + pairStar(str.substring(1));
        else{
            String newStr = str.charAt(0) + "*" + str.substring(1);
            str = newStr;
            return str.substring(0,2)+ pairStar(str.substring(2));
        }
    }

    public static void main(String[] args) {
        System.out.println(pairStar("kkrekker"));
    }
}
