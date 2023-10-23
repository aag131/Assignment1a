import java.util.NoSuchElementException;

/*
Alyssa Goodwin
CSS 342
Assignment 1a
Due: Oct 22, 2023
 */
public class SLL<Type> {
    private Node<Type> head;
    private int count;
    //constructor
    public SLL() {
        count = 0;
        head = null;
    }

    void addFront(Type theElem) {
        // check for empty
        if (count == 0) {
            head = new Node<>();
            head.elem = theElem;
        } else {
            Node<Type> newNode = new Node<>();
            newNode.elem = theElem;
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    public void addRear(Type theElem) {
        if (count == 0) {
            addFront(theElem);
        } else {
            Node<Type> newNode = new Node<>();
            newNode.elem = theElem;
            Node<Type> curr = head;
            for (int i = 1; i < count; i++) {
                curr = curr.next;
            }
            curr.next = newNode;
            count++;
        }
    }

    public void add(int theIndex, Type theElem) {
        // check if index is in bounds, assumes that an index greater than count isn't valid
        if (theIndex > count || theIndex < 0) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        // check if list is empty, if so calls addIfEmpty
        if (count == 0) {
            addFront(theElem);
        }
        // check if index is at the end, if so calls addRear
        if (theIndex == count) {
            addRear(theElem);
        }
        Node<Type> newNode = new Node<>();
        newNode.elem = theElem;
        Node<Type> curr = head;
        for (int i = 1; i < theIndex; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
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
        Node<Type> doomed;
        Node<Type> curr = head;
        for (int i = 1; i < theIndex; i++) {
            curr = curr.next;
        }
        //change pointers
        doomed = curr.next;
        curr.next = curr.next.next;
        count--;
        return doomed.elem;
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
        Node<Type> curr = head;
        for (int i = 1; i <= theIndex; i++) {
            curr = curr.next;
        }
        return curr.elem;
    }

    public void swap(int theIndex1, int theIndex2) {
        //check if list is empty; I looked online to figure out what exception to use
        if (count == 0) {
            throw new NoSuchElementException("List is empty. So no element exists");
        }
        //check if index is within bounds
        if (theIndex1 >= count || theIndex1 < 0 || theIndex2 >= count || theIndex2 < 0) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        Node<Type> beforeI1 = head;
        Node<Type> beforeI2 = head;
        //find corresponding nodes. Accounting for if first index is at the start
        if (theIndex1 != 0) {
            for (int i = 0; i < theIndex1 - 1; i++) {
                beforeI1 = beforeI1.next;
            }
        }
        for (int i = theIndex1 - 1; i < theIndex2 - 1; i++) {
            beforeI2 = beforeI1.next;
        }
        Node<Type> i2 = beforeI2.next;
        if (theIndex1 == 0) {
            //changing pointers and using dummy value to not lose the soon-to-be replaced value
            Node<Type> saver = i2.next;
            i2.next = head.next;
            head.next = saver;
            beforeI2.next = head;
            head = i2;
        } else if (theIndex1 != theIndex2) {
            //changing the pointers before the swapped indices
            Node<Type> i1 = beforeI1.next;
            beforeI1.next = i2;
            beforeI2.next = i1;
            //updating the swapped nodes next pointers. Used a dummy node so a pointer isn't lost.
            Node<Type>saver = i1.next;
            i1.next = i2.next;
            i2.next = saver;
        }

    }

    @Override
    public String toString() {
        String result = "[" + head.elem;
        Node<Type> curr = head.next;
        for (int i = 1; i < count; i++) {
            result += ", " + curr.elem;
            curr = curr.next;
        }
        result += "]";
        return result;
    }

    // nested node class
    class Node<Type> {
        private Type elem;
        private Node<Type> next;
        Node() {
            elem = null;
            next = null;
        }

    }
}
