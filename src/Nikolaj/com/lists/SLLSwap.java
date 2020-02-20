package Nikolaj.com.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SLLSwap {
    public static void swap(SLL<Integer> list,int First, int second){
        SLLNode<Integer> tmp1, tmp1Before = null, tmp1After, tmp2Before = null, tmp2After,tmp2 ;
        tmp1 = list.getFirst();
        tmp1After = tmp1.succ;

        while(!tmp1.element.equals(First) && tmp1.succ != null){
            tmp1Before = tmp1;
            tmp1 = tmp1.succ;
            tmp1After = tmp1.succ;
        }
        //printNodes(tmp1Before, tmp1, tmp1After);
        if(tmp1.element != First){
            System.out.println("elementot ne postoi vo nizata");
            return;
        }

        tmp2 = list.getFirst();
        tmp2After = tmp1.succ;
        while(!tmp2.element.equals(second) && tmp2.succ != null){
            tmp2Before = tmp2;
            tmp2 = tmp2.succ;
            tmp2After = tmp2.succ;
        }
        if(tmp2.element != second){
            System.out.println("elementot ne postoi vo nizata");
            return;
        }
      //  printNodes(tmp2Before, tmp2, tmp2After);
        if(tmp1.succ.equals(tmp2) && tmp1.element.equals(list.getFirst())){
            list.setFirst(tmp2);
            tmp2Before.succ = tmp1;
            tmp1.succ = tmp2.succ;
            tmp2.succ = tmp1;
        }
        else if(tmp1.succ.equals(tmp2)){
            tmp1Before.succ = tmp2;
            tmp2Before.succ = tmp1;
            tmp1.succ = tmp2.succ;
            tmp2.succ = tmp1;
        }
         else if(tmp1.element.equals(list.getFirst().element)){
            list.setFirst(tmp2);
            tmp2Before.succ = tmp1;
            tmp1.succ = tmp2.succ;
            tmp2.succ = tmp1After;
        }
       else {

            tmp2Before.succ = tmp1;
            tmp1.succ = tmp2.succ;
            tmp1Before.succ = tmp2;
            tmp2.succ = tmp1After;
            if(tmp1.element.equals(list.getFirst())){
                list.setFirst(tmp2);
            }

        }

    }
   /* public static void printNodes(SLLNode<Integer> before, SLLNode<Integer> node, SLLNode<Integer> after){
        System.out.println("The nodes are: " + before.element + "-> " + node.element + "->" + after.element);
    }*/

    public static void main(String[] args) throws IOException {
        System.out.println("Enter lists elements: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(input);

        SLL<Integer> list = new SLL<>();
        input = br.readLine();
        String[] brs = input.split("\\s+");
        int brojs[] = new int[brs.length];

        for(int i = 0; i < brojs.length; i ++){
            brojs[i]= Integer.parseInt(brs[i]);
        }
        for(int i = 0; i < num; i++){
            list.insertLast(brojs[i]);
        }
        System.out.println(list.toString());

        swap(list,4,5);
        System.out.println(list.toString());

    }

}
