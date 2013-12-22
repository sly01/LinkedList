package linkedlisttest;

import com.sun.xml.internal.ws.api.pipe.NextAction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MainLinkList {

    public static void main(String[] args) {
        LinkList list = new LinkList();
       
        int secim = 0;
        String line = "";
        String komut = "";
        Scanner choice = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        Scanner command = new Scanner(System.in);
        menu();
        while (secim != 3) {
            
            secim = choice.nextInt();
            if(secim != 3){
            switch (secim) {
                case 1:
                    do {
                        line = keyboard.nextLine();
                        if(line.equals("exit")){
                            break;
                        }
                        else
                        list.addLast(line);
                    } while (!line.equals("exit"));
                    break;

                case 2:
                    commandMenu();
                    komut = command.nextLine();
                    switch (komut) {
                        case "l":
                            System.out.println("Going to the top");
                            list.goTop();
                            break;
                        case "d":
                            System.out.println("Inserting after curent:");
                            Scanner subData = new Scanner(System.in);
                            list.addAfterCurrent(subData.nextLine());
                            break;
                        case "a":
                            System.out.println("Deleting current list");
                            list.delete();
                            break;
                        case "g":
                            System.out.println("Insert line number to go");
                            Scanner linNum = new Scanner(System.in);
                            list.goLine(linNum.nextInt());
                            break;
                        case "?":
                            commandMenu();
                            break;
                        case "m":
                            System.out.println("Please insert forwardline:");
                            Scanner forwaredLine = new Scanner(System.in);
                            list.moveForward(forwaredLine.nextInt());
                            break;
                        case "i":
                            System.out.println("Please enter the data:");
                            Scanner addBeforeCurrentData = new Scanner(System.in);
                            list.addBeforeCurrent(addBeforeCurrentData.nextLine());
                            break;
                        case "p":
                            list.displayCurrent();
                            break;
                        case "s":
                            System.out.println("Please enter the current data:");
                            Scanner oldData = new Scanner(System.in);
                            System.out.println("Please enter the new data:");
                            Scanner newData = new Scanner(System.in);
                            list.replaceText(oldData.nextLine(), newData.nextLine());
                            break;
                        case "w":
                            System.out.println("Please enter the fileName:");
                            Scanner fileName = new Scanner(System.in);
                            writeInFile(list,fileName.nextLine());
                            break;
                        case "r!":
                            System.exit(0);
                            break;
                        case "#":
                            list.goBottom();
                            break;
                        case "+":
                            list.goUp();
                            break;
                        case "-":
                            list.goDown();
                            break;
                        case "?text":
                            System.out.println("Please enter searching text");
                            Scanner text = new Scanner(System.in);
                            if(list.find(text.nextLine()) != null){
                                JOptionPane.showMessageDialog(null, "You found it");
                            }
                            else
                                JOptionPane.showMessageDialog(null, "You can't find it");
                            break;
                    }

                    break;
            }
            System.out.println("Please enter the choice");
            }
            
        }


    }

    public static void writeInFile(LinkList list,String name) {
        try {
            File file = new File("/Users/erkoc/Desktop/proje/"+name+".txt");
            FileWriter fwriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fwriter);
            Link temp = list.first;
            while (temp != null) {
                bw.write(temp.data);
                bw.newLine();
                temp = temp.next;
            }
            bw.close();
        } catch (Exception hata) {
            System.out.println("There is error while writing to file");
        }
    }

    public static void readFromFile(File file) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            StringBuffer readedLine = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                readedLine.append(line + "\n");
            }
            reader.close();
            System.out.println(readedLine);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There is a proble while reading");
        }

    }

    public static void menu() {
        System.out.println("Please select your choice");
        System.out.println("1-Insertion Mode");
        System.out.println("2-Command Mode");
        System.out.println("3-Exit");

    }

    public static void commandMenu() {
        System.out.println("l- Go to top");
        System.out.println("d- Inserting after current");
        System.out.println("a- Delete current line");
        System.out.println("g- Go to a numbered line ");
        System.out.println("?- Get help");
        System.out.println("m- Move current line after some other line");
        System.out.println("i- Insert lines before current line");
        System.out.println("p- Display current line");
        System.out.println("s- Replace text with another text");
        System.out.println("w- Write file to disk");
        System.out.println("r!- Exit with write");
        System.out.println("#- Go to last line");
        System.out.println("- -Go down one line");
        System.out.println("+- Go up one line");
        System.out.println("?text -Search forward for a pattern");
    }
}
