package Nikolaj.com.lists;

import java.util.Scanner;

public class formatiranjeBroj {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        SLL<Integer> lista = new SLL();
        System.out.println("Vnesi elementi na listata");
        int elementi = sc.nextInt();

        System.out.println("Vnesi gi elementite na listata:");
        for (int i = 0; i < elementi; i++) {
            lista.insertLast(sc.nextInt());
        }
        System.out.println(lista.toString());
        formatList(lista);
        System.out.println("");
        System.out.println(lista.toString());

    }


    public static void formatList(SLL<Integer> list) throws Exception {
        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> helper = list.getFirst();
        String s = "";
        int iteracija = list.length();

        for(int i = 0; i < iteracija ; i++){
            if(tmp.element != -1 && iteracija != i+1){
                s += tmp.element;
                helper = helper.succ;
                list.delete(tmp);
                tmp = helper;
            }
            else if(tmp.element == -1 && iteracija != i+1 && !(s.equals(""))){
                helper = helper.succ;
                int newNumb = Integer.parseInt(s);
                list.insertLast(newNumb);
                s = "";
                list.delete(tmp);
                tmp = helper;

            }
            else if(tmp.element != -1 && iteracija == i+1 && !(s.equals(""))){
                int newNumb = Integer.parseInt(s);
                list.insertLast(newNumb);
                s = "";
            }
            else if(tmp.element == -1 && iteracija == i+1 && s.equals("")){

                list.delete(tmp);

            }
        }
    }
}