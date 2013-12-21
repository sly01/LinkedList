package linkedlisttest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Scanner;


public class MainLinkList {

    public static void main(String[] args) {
        LinkList list =new LinkList();
        
        list.addAfterCurrent("1");     
        
        list.addAfterCurrent("4");
        list.addAfterCurrent("3");
        list.addAfterCurrent("2");
        list.displayList();
        list.displayCurrent();
       
        list.goDown();
        list.displayCurrent();
        
        
       
    }
}