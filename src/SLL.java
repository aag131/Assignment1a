/*
Alyssa Goodwin
CSS 342
Assignment 1a
Due: Oct 22, 2023
 */
public class SLL<Type> {
    private Node head;
    private int count;
    //constructor
    public SLL() {
        count = 0;
        head = null;
    }

    void addFront(Type theElem) {
        // not adding a throw for null since it's in node class
        if (count == 0) {
            addIfEmpty(theElem);
        } else {
            Node newNode = new Node();
            newNode.elem = theElem;
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    public void addRear(Type theElem) {
        if (count == 0) {
            addIfEmpty(theElem);
        } else {
            Node newNode = new Node();
            newNode.elem = theElem;
            Node curr = head;
            for (int i = 0; i < count; i++) {
                curr = curr.next;
            }
            curr.next = newNode;
            count++;
        }
    }

    public void add(int theIndex, Type theElem) {
        //TODO write add
        count++;
    }

    public Type delete(int theIndex) {
        //TODO write delete
        count--;
        return null;
    }

    public Type get(int theIndex) {
        //TODO write get
        return null;
    }

    public void swap(int theIndex1, int theIndex2) {
        //TODO write swap
    }

    @Override
    public String toString() {
        //TODO write toString
        return "";
    }

    // private helper method to specifically add an item if the linked list is empty.
    private void addIfEmpty(Type theElem) {
        head = new Node();
        head.elem = theElem;
        count++;
    }


    class Node<T> {
        private Type elem;
        private Node next;

        Node() {
            elem = null;
            next = null;
        }
    }
}
