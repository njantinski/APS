package Nikolaj.com.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class rotateN {
    public static void rotate(SLL<Integer> list, int n){

        for(int i = 0; i < n; i++){
            SLLNode<Integer> node = null ;
            SLLNode<Integer> nodeSucc =  list.getFirst();
            while(nodeSucc.succ != null){
                node = nodeSucc;
                nodeSucc = nodeSucc.succ;
            }
            node.succ = null;
            nodeSucc.succ = list.getFirst();
            list.setFirst(nodeSucc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vnesi go prvo brojot na elementi vo listata, a potoa elementite");
        String input = br.readLine();
        int elemNums = Integer.parseInt(input);

        input = br.readLine();
        String[] listElemsStr = input.split("\\s+");
        int[] listElemsInt = new int[listElemsStr.length];
        for(int i = 0; i < listElemsStr.length; i++){
            listElemsInt[i] = Integer.parseInt(listElemsStr[i]);
        }
        SLL<Integer> list = new SLL<>();
        for(int i = 0; i < elemNums; i++){
            list.insertLast(listElemsInt[i]);
        }
        System.out.println(list.toString());

        rotate(list, 3);
        System.out.println("List after rotation: \n" + list.toString());

    }
}
