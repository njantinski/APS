package Nikolaj.com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sortStack {
    public static ArrayStack<Integer> sortStack(ArrayStack<Integer> stek) {
        ArrayStack<Integer> tmpStack = new ArrayStack<>(100);
        while(!stek.isEmpty()) {
            int tmp = stek.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() < tmp) {
                stek.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        return tmpStack;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputNums = input.split("\\s+");

        int[] stakBrojs = new int[inputNums.length];
        for(int i = 0; i < inputNums.length;i++){
            stakBrojs[i] = Integer.parseInt(inputNums[i]);
        }
        Stack<Integer> stek = new ArrayStack<>(100);
        for(int i : stakBrojs){
            stek.push(i);
        }

        stek = sortStack((ArrayStack<Integer>) stek);
        while(!stek.isEmpty()){
            System.out.print(stek.pop() + "\t");
        }
    }
}
