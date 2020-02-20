package Nikolaj.com.lists;

public class Polinom {
    Array<Integer> koeficienti;

    public Polinom(Array<Integer> koeficienti){
        this.koeficienti = koeficienti;
    }

    public Array<Integer> getKoeficienti() {
        return koeficienti;
    }

    public void setKoeficienti(Array<Integer> koeficienti) {
        this.koeficienti = koeficienti;
    }

    @Override
    public String toString() {
        String ret = new String();

        for(int i = 1; i <= this.koeficienti.get(0)*2 ; i+=2){
            ret += koeficienti.get(i) + "x^" + koeficienti.get(i+1) + " ";
        }
        return ret;
    }

    public Polinom sobiranjePolinomi(Polinom pom){

        Polinom prezultat;
        int m = this.koeficienti.get(0);
        int n = pom.koeficienti.get(0);

        Array<Integer> rezultat = new Array<Integer>(2*m+2*n +1);

        int i = 1,k=1,j=1;

        while( i <= 2*m && j <= 2*n){
            if(this.koeficienti.get(i + 1) == pom.koeficienti.get(j + 1)){
                rezultat.set(k + 1 , this.koeficienti.get( i + 1));
                rezultat.set(k , this.koeficienti.get(i) + pom.koeficienti.get(j));
                j+=2;
                k+=2;
                i+=2;
            } else{
                if( this.koeficienti.get(i + 1) > pom.koeficienti.get( j + 1)){
                    rezultat.set(k, this.koeficienti.get(i));
                    rezultat.set(k + 1,this.koeficienti.get(i + 1) );
                    i+=2;
                    k+=2;
                }
                else if( this.koeficienti.get( i + 1) < pom.koeficienti.get( j + 1 )){
                    rezultat.set(k, pom.koeficienti.get(j));
                    rezultat.set(k+1 , pom.koeficienti.get(j + 1));
                    j+=2; k+=2;
                }
            }
        }
        while(i <= 2*m){
            rezultat.set(k, this.koeficienti.get(i));
            rezultat.set(k + 1, this.koeficienti.get(i + 1));
            i+=2;
            k+=2;
        }

        while(j <= 2*n){
            rezultat.set(k, pom.koeficienti.get(j));
            rezultat.set( k + 1, pom.koeficienti.get(j +1));
            j+=2;
            k+=2;
        }
        rezultat.set(0,k/2);
        prezultat = new Polinom(rezultat);

        return prezultat;

    }
}
