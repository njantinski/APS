package Nikolaj.com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubstring {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        HashMap<String,Integer> subStrings = new HashMap<String, Integer>();

        String line = br.readLine();
        for(int i = 0; i < line.length();i++){
            for(int j = i + 1; j <= line.length(); j++){
                if(!subStrings.containsKey(line.substring(i,j))){
                    subStrings.put((line.substring(i,j)),1);
                }
                else{
                    int momentalno = subStrings.get((line.substring(i,j)));
                    momentalno +=1;
                    subStrings.put((line.substring(i,j)),momentalno);
                }
            }
        }

        Map.Entry<String, Integer> max = null;
        for(Map.Entry<String, Integer> kurac : subStrings.entrySet()){
            if(max == null || (kurac.getValue() > max.getValue() )||(
                    kurac.getValue() == max.getValue()&&max.getKey().length()< kurac.getKey().length())){
                max = kurac;
            }
        }
        System.out.println(max.getKey());
    }
}
