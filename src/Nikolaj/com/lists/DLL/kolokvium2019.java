package Nikolaj.com.lists.DLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kolokvium2019 {
    public static DLL<Integer> smeniListi(DLL<Integer> list1, DLL<Integer> list2){
        DLL<Integer> newList = new DLL<>();
        DLLNode<Integer> tmp =  list1.getFirst();

        while(tmp != null){
            if(!(tmp.element % 2 == 0)){
                newList.insertFirst(tmp.element);
            }
            tmp = tmp.succ;
        }

        tmp = list2.getLast();
        DLLNode<Integer> node;
        node = newList.getFirst();

        while(tmp != null){
            node = newList.getFirst();
            if(tmp.element % 2 == 0){
                if(tmp.element > node.element)
                    newList.insertFirst(tmp.element);
                else{
                    while(tmp.element < node.element){
                        if(node.succ == null)
                            break;
                        node = node.succ;
                    }
                    if(node.succ == null){
                        if(node.element > tmp.element)
                            newList.insertLast(tmp.element);
                        else{
                            newList.insertBefore(tmp.element, node);
                        }
                    }
                    else{
                        newList.insertBefore(tmp.element, node);
                    }
                       }
                    }
                    tmp = tmp.pred;
                }
        return newList;
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
        System.out.println(smeniListi(list, list1).toString());
    }
}
