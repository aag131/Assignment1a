import java.util.NoSuchElementException;

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
        if (theElem == null) {
            throw new NullPointerException("Cannot pass null element");
        }
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
        // checks if elem is null
        if (theElem == null) {
            throw new NullPointerException("Cannot pass null element");
        }
        // check if index is in bounds, assumes that an index greater than count isn't valid
        if (theIndex > count || theIndex < 0) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        // check if list is empty, if so calls addIfEmpty
        if (count == 0) {
            addIfEmpty(theElem);
        }
        // check if index is at the end, if so calls addRear
        if (theIndex == count) {
            addRear(theElem);
        }
        Node newNode = new Node();
        newNode.elem = theElem;
        Node curr = head;
        for (int i = 0; i < theIndex; i++) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = curr.next;
        count++;
    }

    public Type delete(int theIndex) {
        //check if list is empty; I looked online to figure out what exception to use
        if (count == 0) {
            throw new NoSuchElementException("List is empty. So no element exists");
        }
        //check if index is within bounds
        if (theIndex >= count || theIndex < 0) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        //increment through
        Node doomed = null;
        Node curr = head;
        for (int i = 0; i < theIndex; i++) {
            curr = curr.next;
        }
        //change pointers
        doomed = curr.next;
        curr.next = curr.next.next;
        count--;
        return (Type) doomed.elem;
    }

    public Type get(int theIndex) {
        //check if list is empty; I looked online to figure out what exception to use
        if (count == 0) {
            throw new NoSuchElementException("List is empty. So no element exists");
        }
        //check if index is within bounds
        if (theIndex >= count || theIndex < 0) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        Type result;
        Node curr = head;
        for (int i = 0; i <= theIndex; i++) {
            curr = curr.next;
        }
        return (Type) curr.elem;
    }

    public void swap(int theIndex1, int theIndex2) {
        //TODO write swap
    }

    @Override
    public String toString() {
        String result = "[ ";
        Node curr = head;
        for (int i = 0; i < count; i++) {
            result += ", " + curr.elem;
            curr = curr.next;
        }
        result += "]";
        return result;
    }

    // private helper method to specifically add an item if the linked list is empty.
    private void addIfEmpty(Type theElem) {
        head = new Node();
        head.elem = theElem;
        count++;
    }

    // nested node class
    class Node<T> {
        private Type elem;
        private Node next;

        Node() {
            elem = null;
            next = null;
        }

    }
}
