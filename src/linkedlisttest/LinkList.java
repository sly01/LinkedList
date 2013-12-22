package linkedlisttest;

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
        Link temp = first;
        while (temp != null) {
            temp.displayLink();
            temp = temp.next;
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

    public void goTop() {//command l
        current = first;
        counter = 1;
    }

    public void delete() {//command a
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
    }

    public void addAfterCurrent(String newData) {//command d
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

    }

    public void goLine(int line) {//command g
        current = first;
        for (counter = 1; counter < line; counter++) {
            if(current.next!=null){
            current = current.next;
            }else break;
        }
    }

    public void addBeforeCurrent(String newData) {//command i
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

    }

    public void moveForward(int moveForward) {//command m
        for (int i = 0; i < moveForward; i++) {
            if(current.next!=null){
                current = current.next;
                counter++;
            }else
                break;
        }

    }

    public void displayCurrent() {//command P
        current.displayLink();
    }

    public void replaceText(String oldText, String newText) {//command s
        Link temp = first;
        while (!temp.data.equals(oldText)) {
            temp = temp.next;

        }
        if (temp.data.equals(oldText)) {
            temp.data = newText;
        }

    }

    public void copyCurrentData(int line) {//command t
        Link temp = first;
        for (int i = 1; i < line; i++) {
            temp = temp.next;
            temp.data = current.data;
        }
    }

    public void goBottom() {//command #
        current = first;
        counter = 1;
        while (current.next != null) {
            current = current.next;
        }
    }

    public void goUp() {//command +
        if (current.previous != null) {
            current = current.previous;

            counter--;
        }
    }

    public void goDown() {//command -
        if (current.next != null) {
            current = current.next;
            counter++;
        }
    }

    public void addLast(String newData) {
        Link newLink = new Link(newData);
        Link temp = first;
        if (first == null) {
            newLink.next = null;
            newLink.previous = null;
            first = newLink;

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
    }
}