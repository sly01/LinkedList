/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttest;

import Ui.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author erkoc
 */
public class MainLinkList {

    static LinkedList editor;

    public static void main(String[] args) {
        editor = new LinkedList();
        String line = "";
        menu();
        int secim=0;
        String komut = "";
        Scanner choice = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        Scanner command = new Scanner(System.in);
        while (secim != 3) {
            
            secim = choice.nextInt();
            switch (secim) {
               
                case 1:
                    do {
                        line = keyboard.nextLine();
                        editor.add(line);
                    } while (!line.equals("exit"));
                    editor.removeLast();
                    break;

                case 2:
                    komut = command.nextLine();
                    switch(komut){
                        case "save":
                            writeInFile("test");
                            break;
                        case "quit":
                            System.exit(0);
                            break;
                    }
                    break;
               
            }
            System.out.println("Please enter the choice:");

        }

        

    }

    public static void menu() {
        System.out.println("Please select your choice");
        System.out.println("1-Insertion Mode");
        System.out.println("2-Command Mode");
        System.out.println("3-Exit");

    }

    public static void writeInFile(String filename) {
        try {
            File file = new File("/Users/erkoc/Desktop/proje/" + filename + ".txt");
            FileWriter fwriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fwriter);
            for (Object satir : editor) {
                bw.write(satir.toString() + "\n");
            }
            bw.close();
        } catch (Exception hata) {
            System.out.println("There is error while writing to file");
        }
    }
}