/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttest;

/**
 *
 * @author erkoc
 */
public class Link {
    
    public String data;
    public Link next;

    public Link() {
    }

    public Link(String data) {
        this.data = data;
    }
    public void displayLink(){
        System.out.println(data+" ");
    }

   
}
