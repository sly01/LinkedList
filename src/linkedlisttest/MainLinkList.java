package linkedlisttest;

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
        LinkList list =new LinkList();
        
        list.addAfterCurrent("1");     

        list.addAfterCurrent("4");
        list.addAfterCurrent("3");
        list.addAfterCurrent("2");
        list.displayList();
        System.out.println(list.current.data);
        list.goBottom();
        System.out.println(list.current.data);
        list.addLast("5");
        list.addLast("6");
        list.displayCurrent();
        list.displayList();
        //list.goDown();
        //list.displayCurrent();
        //writeInFile(list);
        //System.out.println("-----------*--------------");
        //File file = new File("/Users/erkoc/Desktop/proje/test.txt");
        //readFromFile(file);
       
    }
    
    public static void writeInFile(LinkList list){
        try {
            File file = new File("/Users/erkoc/Desktop/proje/test.txt");
            FileWriter fwriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fwriter);
            Link temp = list.first;
            while(temp != null){
                bw.write(temp.data);
                bw.newLine();
                temp = temp.next;
            }
            bw.close();
        } catch (Exception hata) {
            System.out.println("There is error while writing to file");
        }
    }
    public static void readFromFile(File file){
        try {
                        
			 BufferedReader reader = new BufferedReader(new FileReader(file));
			 String line = "";
			 StringBuffer readedLine = new StringBuffer();
			 while((line=reader.readLine())!=null){
				 readedLine.append(line + "\n");
			 }
			 reader.close();
			 System.out.println(readedLine);
			 
		} catch (Exception e) {
			         JOptionPane.showMessageDialog(null, "There is a proble while reading");
		}
        
    }
}