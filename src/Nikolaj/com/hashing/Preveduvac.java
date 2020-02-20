package Nikolaj.com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Preveduvac{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        CBHT<String, String> recnik = new CBHT<>(n);

        for(int i = 0; i < n; i++){
            String vrednost = br.readLine();
            String[] mapEntry = vrednost.split("\\s+");
            recnik.insert(mapEntry[1],mapEntry[0]);
        }

        String line = br.readLine();
        while(!line.equals("KRAJ")){
            SLLNode<MapEntry<String, String>> kluc = recnik.search(line);
            if(kluc == null)
                System.out.println("/");
            else{
                System.out.println(kluc.element.value);
            }
            line = br.readLine();
        }


    }


}
