package Nikolaj.com.rekurzija;

import java.io.File;
import java.io.FileFilter;
import java.sql.SQLOutput;

public class listFiles   {
    public static void main(String[] args) {
        File file = new File(".");
        printFilesRecursive(file);
    }

    private static void printFilesRecursive(File file) {
        File[] dirs = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        String[] files = file.list();
        System.out.println("Directory  " + file.getAbsolutePath());
        listFilesInDir(file);


        for(File f : dirs){
            printFilesRecursive(f);
        }
    }

    private static void listFilesInDir(File file) {
        String[] files = file.list();
        for(String f : files){
            System.out.println(f);
        }
    }
}
