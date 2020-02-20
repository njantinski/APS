package Nikolaj.com.lists.DLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spoiListi {
    public static void spoiListi(DLL<Integer> list1, DLL<Integer> list2) {
        DLLNode<Integer> node1 = list1.getFirst();
        DLLNode<Integer> node2 = list2.getLast();
        DLL<Integer> newList = new DLL<>();

        while (node1 != null && node2 != null) {
          if (node1.element % 2 == 0) {
                newList.insertLast(node1.element);
            }
            if (node2.element % 2 == 0) {
                newList.insertLast(node2.element);
            }
            node1 = node1.succ;
            node2 = node2.pred;
        }
        if (node1 != null) {
            while (node1 != null) {
                if (node1.element % 2 == 0) {
                    newList.insertLast(node1.element);
                }
                node1 = node1.succ;
            }
        }
        if (node2 != null) {
            while (node2 != null) {
                if (node2.element % 2 == 0) {
                    newList.insertLast(node2.element);
                }
                node2 = node2.pred;
            }

        }
        node1 = list1.getFirst();
        while(node1 != null){
            if(node1.element %2 != 0){
                newList.insertLast(node1.element);
            }
            node1 = node1.succ;
        }
        node2 = list2.getLast();
        while(node2 != null){
            if(node2.element %2 != 0){
                newList.insertLast(node2.element);
            }
            node2 = node2.pred;
        }
        System.out.println(newList.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bf.readLine();
        String[] chars = str1.split(" ");

        DLL<Integer> list = new DLL<>();

        for(int i = 0; i < chars.length;i++){
            list.insertLast(Integer.parseInt(chars[i]));
        }
        System.out.println(list.toString());

        String str2 = bf.readLine();
        String[] charz = str2.split(" ");
        DLL<Integer> list1 = new DLL<>();
        for(int i = 0; i < charz.length;i++){
            list1.insertLast(Integer.parseInt(charz[i]));
        }
        spoiListi(list,list1);
    }
}
