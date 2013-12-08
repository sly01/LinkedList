/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttest;

/**
 *
 * @author erkoc
 */
public class MainLinkList {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        
        theList.insertFirst("Bu birinci satirdir.");
        theList.insertFirst("Bu ikinci satirdir.");
        theList.insertFirst("Bu ucuncu satirdir.");
        theList.insertFirst("Bu dorduncu satirdir.");
        
        theList.displayList();
        /*
        while (!theList.isEmpty()) {            
            Link aLink = theList.deleteFirst();
            System.out.println("Deleted");
            aLink.displayLink();
            System.out.println("");
        }
        */
        Link f = theList.find("Bu ucuncu satirdir.");
        if(f != null)
            System.out.println("Found link with key " + f.data);
        else 
            System.out.println("Can't find link");
        
        Link d = theList.delete("Bu ikinci satirdir.");
        
        if(d != null)
            System.out.println("Deleted link with key " + d.data);
        else
            System.out.println("Can't delete link");
        
        theList.displayList();
    }
}
