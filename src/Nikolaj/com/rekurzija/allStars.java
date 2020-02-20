package Nikolaj.com.rekurzija;

public class allStars {

    public String allStar(String str) {
        if(str.length() == 0)
            return str;
        if(str.length() == 1)
            return str;
        else{
            return str.charAt(0) + "*" + allStar(str.substring(1));
        }
    }

}
