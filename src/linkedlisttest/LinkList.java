/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttest;

/**
 *
 * @author erkoc
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(String data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public Link find(String key) {
        Link current = first;
        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(String key) {
        Link current = first;
        Link previous = first;
        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;

            }
        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }
}
