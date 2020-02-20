package Nikolaj.com.rekurzija;

public class changePi {
    public static String piString(String izraz){
       if(izraz.length() <= 1)
           return izraz;
       if(izraz.substring(0,2) == "pi")
           return "3.14" + piString(izraz.substring(2));
       return izraz.charAt(0) + piString(izraz.substring(1));


    }

}
