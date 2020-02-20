package Nikolaj.com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Statistika {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> lugje = new HashMap<>(n,(float)0.5);
        HashMap<String, Integer> sportovi = new HashMap<>(n,(float)0.5);

        int brFudbal = 0;
        String line;

        for(int i = 0; i < n; i++){
            line = br.readLine();
            String[] vlez = line.split("\\s+");

            if(lugje.containsKey(vlez[0])){
                if(vlez[1].equals("fudbal")){
                    brFudbal++;
                }
                int brojSport = sportovi.get(vlez[1]);
                sportovi.put(vlez[1],++brojSport);
                continue;
            }
            else{
                if(vlez[1].equals("fudbal")){
                    brFudbal++;
                }
                lugje.put(vlez[0],vlez[1]);
                sportovi.put(vlez[1],1);
            }
        }

        Map.Entry<String, Integer> maxEntry = null;
        for(Map.Entry<String, Integer> mp : sportovi.entrySet()){
            if(maxEntry == null || mp.getValue() >= maxEntry.getValue()){
                maxEntry = mp;
            }
        }

        System.out.println("Najvekje lugje go sakaat sportot: " + maxEntry.getKey());
        System.out.println("Fudbal sakaat: " + brFudbal + " lugje");
    }
}
