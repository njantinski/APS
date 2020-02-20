package Nikolaj.com.queue;

public class Konsultacii_g4 {

    private static void Konsultacii(ArrayQueue<String> redAps, ArrayQueue<String> redMms,
                                    ArrayQueue<String> redTip){
        String tip = "";

        while(!redAps.isEmpty() && !redTip.isEmpty()){
            if(tip.equals(redTip.peek())){
                tip = redTip.dequeue();
                redTip.enqueue(tip);
                redAps.enqueue(redAps.dequeue());
                if(!redMms.isEmpty()){
                    System.out.println(redMms.dequeue());
                }
                else{
                    tip =  redTip.dequeue();
                    System.out.println(redAps.dequeue());
                }
            }else{
                tip = redTip.dequeue();
                System.out.println(redAps.dequeue());
            }
        }
        while (!redMms.isEmpty())
            System.out.println(redMms.dequeue());
    }
}
