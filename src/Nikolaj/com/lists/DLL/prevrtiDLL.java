package Nikolaj.com.lists.DLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prevrtiDLL {
    public static void prevrti(DLL<Integer> list){
        DLL<Integer> newList = new DLL<>();
        DLLNode<Integer> node = list.getLast();


        while(node != null){
            if(node.element % 2 == 0){
                newList.insertLast(node.element);
            }
            node = node.pred;
        }
        node = list.getLast();
        while(node != null){
            if(node.element % 2 != 0){
                newList.insertLast(node.element);
            }
            node = node.pred;
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
        System.out.println();
        prevrti(list);
    }
}

