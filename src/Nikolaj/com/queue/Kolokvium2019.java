package Nikolaj.com.queue;

import Nikolaj.com.lists.Array;
import Nikolaj.com.stack.ArrayStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kolokvium2019 {
    public static final int MAX = 100;
    public static void modifyQueue(ArrayQueue<Integer> queue, int n){
        ArrayStack<Integer> stack = new ArrayStack<>(MAX);
        for(int i = 0; i < n; i++){
            stack.push(queue.dequeue());
        }
        for(int i = 0; i < n; i++){
            queue.enqueue(stack.pop());
        }
        for(int i = 0; i < (queue.size() - n); i++){
            stack.push(queue.dequeue());
            queue.enqueue(stack.pop());
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Vnesi br na elementi vo redot");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int brElem = Integer.parseInt(str);

        ArrayQueue<Integer> queue = new ArrayQueue<>(MAX);
        System.out.println("Vnesi gi elementite vo redot");
        str = br.readLine();
        String[] brs = str.split("\\s+");
        int[] broeviRed = new int[brElem];
        for(int i = 0; i < brs.length;i++){
            broeviRed[i] = Integer.parseInt(brs[i]);
        }
        System.out.print("Vnesenite broevi se: ");
        for(int i = 0; i < brElem; i++){
            System.out.print(broeviRed[i] + "\t");
        }
        System.out.println("Vnesi do koj broj sakas da gi modificiras: ");
        int n = Integer.parseInt(str = br.readLine());

        for(int i = 0; i < brElem; i++){
            queue.enqueue(broeviRed[i]);
        }
        modifyQueue(queue,n);
        while(queue.peek() != null){
            System.out.print(queue.dequeue() + "\t");
        }

    }
}
