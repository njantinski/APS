package Nikolaj.com.lists;

class Koeficienti implements Comparable<Koeficienti>{
    int koef;
    int exp;

    public Koeficienti(int koef, int exp) {
        this.koef = koef;
        this.exp = exp;
    }
    public Koeficienti soberiKoeicienti(Koeficienti k1){
        Koeficienti ret = new Koeficienti(this.koef + k1.koef, this.exp);
        return ret;
    }


    @Override
    public int compareTo(Koeficienti k1) {
        if(this.koef > k1.koef)
            return 1;
        else if(this.koef == k1.koef)
            return 0;
        else
            return -1;
    }

}
public class PolinomLista{
    SLL<Koeficienti> koeficienti = new SLL<Koeficienti>();

    public PolinomLista(SLL<Koeficienti> koeficienti) {
        this.koeficienti = koeficienti;
    }

    public SLL<Koeficienti> getKoeficienti() {
        return koeficienti;
    }

    public PolinomLista soberi(PolinomLista p1){

        SLLNode<Koeficienti> tmp1 = this.koeficienti.getFirst();
        SLLNode<Koeficienti> tmp2 = p1.koeficienti.getFirst();

        SLL<Koeficienti> rezultantnaLista = new SLL<Koeficienti>();
        while(tmp1 != null && tmp2 != null){
            if(tmp1.element.compareTo(tmp2.element) == 1){
                rezultantnaLista.insertLast(tmp1.element);
                tmp1 = tmp1.succ;
            }
            if(tmp1.element.compareTo(tmp2.element) == 0){
                rezultantnaLista.insertLast(tmp2.element.soberiKoeicienti(tmp1.element));
                tmp1 = tmp1.succ;
                tmp2 = tmp2.succ;
            }
            else {
                rezultantnaLista.insertLast(tmp2.element);
                tmp2 = tmp2.succ;
            }
        }
        while(tmp1 != null){
            rezultantnaLista.insertLast(tmp1.element);
            tmp1 = tmp1.succ;

        }
        while(tmp2 != null){
            rezultantnaLista.insertLast(tmp2.element);
            tmp2 = tmp2.succ;
        }
        PolinomLista rezultat = new PolinomLista(rezultantnaLista);
        return rezultat;
    }

    public static void main(String[] args) {

    }
}