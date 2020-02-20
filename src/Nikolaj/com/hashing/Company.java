package Nikolaj.com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Company {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vlez;
        HashMap<String, Integer> parovi = new HashMap<>();
        int n = Integer.parseInt(br.readLine());


        for(int i =0; i< n; i++){
            vlez = br.readLine();
            String[] par = vlez.split(" ");
            if(!par[0].equals(par[1])) {
                if (!parovi.containsKey(par[1])) {
                    parovi.put(par[1], 1);
                } else {
                    int novVlez = parovi.get(par[1]) + 1;
                    parovi.put(par[1], novVlez);
                }
            }
        }
        System.out.println(parovi.toString());
    }
}
