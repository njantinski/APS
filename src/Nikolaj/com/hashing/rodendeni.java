package Nikolaj.com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class rodendeni {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, SLLNode<String>> mapa = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String vlez;
        for(int i = 0; i < n; i++){
            vlez = br.readLine();
            String[] covek = vlez.split("\\s+");
            String[] datum = covek[1].split("[.]");
            int mesec = Integer.parseInt(datum[1]);
            if(mapa.containsKey(mesec)){
                mapa.get(mesec).succ = new SLLNode<String>(covek[0],null);
            }
            else{
                mapa.put(mesec, new SLLNode<>(covek[0],null));
            }
        }
        int barajMesec= Integer.parseInt(br.readLine());
        if(mapa.get(barajMesec) == null){
            System.out.println("Nema takov mesec");
        }
        else{
            SLLNode<String> tmp = mapa.get(barajMesec);
            StringBuilder sb= new StringBuilder();
            while(tmp != null){
                sb.append(tmp.element);
                tmp = tmp.succ;
            }
            System.out.println(sb.toString());
        }
    }
}
