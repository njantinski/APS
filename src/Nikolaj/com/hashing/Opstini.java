package Nikolaj.com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Opstini {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(br.readLine());
        String line;
        HashMap<String, Opstina> mapa = new HashMap<>();

        for(int i = 0; i < n; i++){
            line = br.readLine();
            String[] vnes = line.split("\\s+");

            if(mapa.containsKey(vnes[0])){
                mapa.get(vnes[0]).dodadiMerenje(Double.parseDouble(vnes[1]));
            }
            else{
                mapa.put(vnes[0], new Opstina(Double.parseDouble(vnes[1])));
            }

        }
        line = br.readLine();
        if(!mapa.containsKey(line)){
            System.out.println("Nema dostapni merenja za toj grad!");
        }
        else{
            System.out.println(mapa.get(line).getProsek());
        }
    }
}

class Opstina{
    private double zbirMerenja;
    private int brMerenja;

    public Opstina(double zbirMerenja) {
        this.zbirMerenja = zbirMerenja;
        this.brMerenja = 1;
    }
    public void dodadiMerenje(double n){
        zbirMerenja += n;
        brMerenja++;
    }
    public double getProsek(){
        return zbirMerenja/ (double) brMerenja;
    }
}