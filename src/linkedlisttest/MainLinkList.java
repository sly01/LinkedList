/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author erkoc
 */
public class MainLinkList {

    public static void main(String[] args) {
        LinkedList liste = new LinkedList();
        String line = "";
        Scanner keyboard = new Scanner(System.in);
        do {            
            line = keyboard.nextLine();
            liste.add(line);
        } while (!line.equals("exit"));
        
        liste.removeLast();
       
        try {
             File file = new File("/home/erkoc/Desktop/proje/liste.txt");
             FileWriter fwriter = new FileWriter(file,true);
             BufferedWriter bw = new BufferedWriter(fwriter);
             for(Object satir : liste){
             bw.write(satir.toString()+ "\n");
             }
             bw.close();
        } catch (Exception hata) {
            hata.printStackTrace();
        }
        System.out.println("Dosya yazimi basari ile gerceklesmistir");
       
        System.out.println("\n Bitti");
    }
}
