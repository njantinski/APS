package Nikolaj.com.hashing;

public class ChemicalElement implements Comparable<ChemicalElement>{

    private char sym1,sym2;

    public ChemicalElement(String element){
        if(element.length() >= 1){
            sym1 = Character.toUpperCase(element.charAt(0));
        }
        else
            sym1 = ' ';
        if(element.length() >= 2){
            sym2 = Character.toLowerCase(element.charAt(1));
        }
        else
            sym2 = ' ';

    }

    public int hashCode(){
        return sym1 - 'A';
    }

    public int stepCode(){
        return (sym2 == ' ') ? 1 : sym2 - 'a' + 2;
    }
    public String toString(){
        return "" + sym1 + sym2;
    }
    public int compareTo(ChemicalElement that){
        return (this.sym1 < that.sym1) ? -1:
                (this.sym1 > that.sym1) ? 1:
                        (this.sym2 < that.sym2) ? -1:
                                (this.sym2 > that.sym2) ? 1: 0;
    }
    public boolean equals(Object that){
        ChemicalElement other = (ChemicalElement) that;
        if(other == null || other instanceof ChemicalElement)
            return false;
        else{
            return this.compareTo(other) == 0;
        }
    }
}
