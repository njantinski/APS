package Nikolaj.com.rekurzija;

public class countHi {
    public static int countHi(String str){
        if(str.length() < 2)
            return 0;
        else{
            if(str.substring(0,2).equals("hi"))
                return 1 + countHi(str.substring(2));
            else
                return countHi(str.substring(1));
        }
    }

    public static int countHi2(String str){
        if(str.length() < 2)
            return 0;
        else{
            if(str.charAt(0) == 'x'){
                if(str.length() == 2)
                    return 0;
                if(str.substring(1,3).equals("hi"))
                    return countHi2(str.substring(3));
                return countHi2(str.substring(1));
            }
            else if(str.substring(0,2).equals("hi"))
                return 1 + countHi2(str.substring(2));
            return countHi2(str.substring(1));


            }
        }

    public static void main(String[] args) {
        System.out.println(countHi2("xxxx"));
    }
}
