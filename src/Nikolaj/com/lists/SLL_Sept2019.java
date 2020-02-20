package Nikolaj.com.lists;


import java.util.Scanner;

// prasaj za ova
public class SLL_Sept2019 {
    public static void changeTheList(SLL<Integer> list) throws Exception {
        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> tmpHelper;

        while(tmp != null){
            tmpHelper = tmp;
            while(tmpHelper.succ != null){
                tmpHelper = tmpHelper.succ;
            }
            list.insertAfter(tmpHelper.element, tmp);
            list.delete(tmpHelper);
            tmp = tmp.succ.succ;
        }


    }

    public static void main(String[] args) {
        SLL<Integer> list = new SLL<Integer>();

        System.out.println("Vnesi kolku elementi sakas da ima listata");

        Scanner input = new Scanner(System.in);
        int a= input.nextInt();
        input.nextLine();
        System.out.println(a);

        for(int i = 0; i < a; i++){
            list.insertLast(input.nextInt());
        }

       try {
            changeTheList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SLLNode<Integer> node = list.getFirst();
        System.out.println(list.toString());
        while(node != null){
            System.out.println(node.element);
            node = node.succ;

        }
        input.close();
    }
}
