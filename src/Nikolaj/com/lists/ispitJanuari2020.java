package Nikolaj.com.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Email implements Comparable<Email>{
    private String type;
    private String title;
    private String text;

    public Email(String type, String title, String text) {
        this.type = type;
        this.title = title;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public int compareTo(Email o) {
        for(int i = 0; i < getTitle().length();i++){
            if((int)getTitle().charAt(i) < (int)o.getTitle().charAt(i)){
                return 1;
            }
            else if((int)getTitle().charAt(i) > (int)o.getTitle().charAt(i)){
                return -1;
            }
            else continue;
        }
        return 0;
    }
}


public class ispitJanuari2020 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Email> list = new SLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = "";

        for(int i = 0; i < n; i++) {
            line = br.readLine();
            String[] poraka = line.split("\\s+");

            SLLNode<Email> node = list.getFirst();
            if (poraka[0].equals("DEL")) {
                Email mail = new Email(poraka[0], poraka[1], "");
                while (node.element.compareTo(mail) != 0 && node != null)
                    node = node.succ;
                if (node != null && node.element.compareTo(mail) == 0)
                    list.delete(node);
                else continue;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int j = 2; j < poraka.length; j++) {
                    sb.append(poraka[j]).append(" ");
                }
                Email mail = new Email(poraka[0], poraka[1], sb.toString());


                if (node == null) {
                    list.insertFirst(mail);
                } else {
                    if (mail.compareTo(node.element) == 1) {
                        list.insertFirst(mail);
                    } else if (mail.compareTo(node.element) == 0) {
                        if (node.succ == null) {
                            list.delete(node);
                            list.insertLast(mail);
                        } else {
                            SLLNode<Email> tmp = node.succ;
                            if(list.getFirst() == node){
                                list.insertFirst(mail);
                            }
                            list.delete(node);
                            list.insertBefore(mail, tmp);
                        }
                    } else {
                        while (mail.compareTo(node.element) == -1 && node.succ != null)
                            node = node.succ;
                        if (mail.compareTo(node.element) == -1)
                            list.insertLast(mail);
                        else if (mail.compareTo(node.element) == 0) {
                            if (node.succ == null) {
                                list.delete(node);
                                list.insertLast(mail);
                            } else {
                                SLLNode<Email> tmp = node.succ;
                                list.delete(node);
                                list.insertBefore(mail, tmp);
                            }
                        } else
                            list.insertBefore(mail, node);
                    }

                }
            }

        }

        print(list);
    }

    public static void print(SLL<Email> list){
        SLLNode<Email> node = list.getFirst();
        int count = 1;
        if(node == null){
            System.out.println("(empty inbox)");
        }
        else {
            while (node != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(count).append(". ").append("[").append(node.element.getTitle()).append("]: ");
                if (node.element.getType().equals("SND")) {
                    sb.append("> ");
                }
                sb.append(node.element.getText());
                count++;
                System.out.println(sb.toString());
                node = node.succ;
            }
        }
    }
}
