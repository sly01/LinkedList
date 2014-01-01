package linkedlisttest;

import javax.swing.JOptionPane;

public class LinkList {

    public Link first = new Link();
    public Link current = new Link();
    public int counter = 0;

    public LinkList() {
        first = null;
        current = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayList() {//command
        System.out.println("List (first-->last): ");
        try {
            Link temp = first;
            while (temp != null) {
                temp.displayLink();
                temp = temp.next;
            }
            System.out.println("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There is a problem while printing all list");
        }

    }

    public Link find(String key) {
        try {
            Link temp = first;
            while (temp != null) {
                if (temp.data.equals(key)) {
                    return temp;
                } else {
                    temp = temp.next;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Finding problem");
        }
        return null;
    }

    public void goTop() {//command l
        try {
            current = first;
            counter = 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Go Top problem");
        }

    }

    public void delete() {//command a
        try {
            if (current == first) {
                first = first.next;
                first.previous = null;
                current = first;
                counter = 1;

            } else {
                if (current.next == null) {
                    current = current.previous;
                    current.next = null;
                    counter--;

                } else {
                    Link temp = current;
                    temp = temp.next;
                    current = current.previous;
                    current.next = temp;
                    temp.previous = current;
                    counter--;

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Deleting problem");
        }
    }

    public void addAfterCurrent(String newData) {//command d
        try {
            Link newLink = new Link(newData);
            if (counter == 0) {//ba�ta
                newLink.previous = null;
                newLink.next = null;
                first = newLink;
                current = first;
                counter = 1;
            } else {
                if (current.next == null) {//sonda
                    current.next = newLink;
                    newLink.next = null;
                    newLink.previous = current;

                } else {//di�er

                    newLink.previous = current;
                    newLink.next = current.next;
                    current.next = newLink;
                    newLink.next.previous = newLink;


                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Add After Current problem");
        }
    }

    public void goLine(int line) {//command g
        try {
            current = first;
            for (counter = 1; counter < line; counter++) {
                if (current.next != null) {
                    current = current.next;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Go line problem");
        }

    }

    public void addBeforeCurrent(String newData) {//command i
        try {
            Link newLink = new Link(newData);
            if (counter == 0) {
                first = newLink;
                current = first;
                counter = 1;

            } else {
                if (counter == 1) {
                    newLink.next = first;
                    first.previous = newLink;
                    counter++;
                    current = first;
                    first = newLink;
                } else {
                    newLink.next = current;
                    newLink.previous = current.previous;
                    current.previous.next = newLink;
                    current.previous = newLink;
                    counter++;
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Add before current problem");
        }


    }

    public void moveForward(int moveForward) {//command m
        try {
            for (int i = 0; i < moveForward; i++) {
                if (current.next != null) {
                    current = current.next;
                    counter++;
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Move Forward problem");
        }


    }

    public void displayCurrent() {//command P
        try {
            current.displayLink();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Display Current problem");
        }

    }

    public void replaceText(String oldText, String newText) {//command s
        try {
            Link temp = first;
            while (!temp.data.equals(oldText)) {
                temp = temp.next;

            }
            if (temp.data.equals(oldText)) {
                temp.data = newText;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Replace Text problem");
        }


    }

    public void copyCurrentData(int line) {//command t
        try {
             Link temp = first;
        for (int i = 1; i < line; i++) {
            temp = temp.next;
            temp.data = current.data;
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Copy Current Data problem");
        }
       
    }

    public void goBottom() {//command #
        try {
             current = first;
        counter = 1;
        while (current.next != null) {
            current = current.next;
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Go Bottom problem");
        }
       
    }

    public void goUp() {//command +
        try {
            if (current.previous != null) {
            current = current.previous;

            counter--;
        }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Go Up problem");
        }
        
    }

    public void goDown() {//command -
        try {
            if (current.next != null) {
            current = current.next;
            counter++;
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Go Down problem");
        }
        
    }

    public void addLast(String newData) {
        try {
            Link newLink = new Link(newData);
        Link temp = first;
        if (first == null) {
            newLink.next = null;
            newLink.previous = null;
            first = newLink;
            current = first;
            counter = 1;

        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = newLink;
                newLink.next = null;
                newLink.previous = temp;
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Add Last problem");
        }
        
    }
}