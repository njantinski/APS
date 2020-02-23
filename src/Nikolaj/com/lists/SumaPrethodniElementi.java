package Nikolaj.com.lists;

import java.util.Scanner;

public class SumaPrethodniElementi {

    private static void sumBefore(SLL<Integer> list) {
        SLLNode<Integer> node = list.getFirst();
        int sum = 0;
        int goal = node.element;
        int counter = 0;
        while(node != null){

            if(counter != goal && node !=null){
                sum += node.element;
                counter++;
            }
            else{
                list.insertBefore(sum, node);
                counter = 1;
                sum = node.element;
                goal = node.element;
            }
            node= node.succ;
        }
    }


    public static void main(String[] args) {
        System.out.println("Vnesi kolku elementi sakas da ima listata");
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        SLL<Integer> List = new SLL<>();

        for(int i = 0; i < numbers; i++){
            List.insertLast(sc.nextInt());
        }
        System.out.println(List.toString());

        sumBefore(List);
        System.out.println(List.toString());
    }
}
