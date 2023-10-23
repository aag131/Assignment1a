import java.util.NoSuchElementException;

/*
Alyssa Goodwin
CSS 342
Assignment 1a
Due: Oct 22, 2023
 */
public class DLL<Type> {
    private Node<Type> head;
    private int count;
    //constructor
    public DLL() {
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
            head.prev = newNode;
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
            newNode.prev = curr;
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
        newNode.prev = curr;
        curr.next = newNode;
        newNode.next.prev = newNode;
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
        Node<Type> doomed = head;
        for (int i = 1; i < theIndex; i++) {
            doomed = doomed.next;
        }
        //change pointers
        doomed.prev.next = doomed.next;
        doomed.next.prev = doomed.prev;
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

    public void swap(int theIndex1, int theIndex2) { //TODO fully convert to DLL form
        //check if list is empty; I looked online to figure out what exception to use
        if (count == 0) {
            throw new NoSuchElementException("List is empty. So no element exists");
        }
        //check if index is within bounds
        if (theIndex1 >= count || theIndex1 < 0 || theIndex2 >= count || theIndex2 < 0) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        Node<Type> i1 = head;
        //find corresponding nodes. Accounting for if first index is at the start
        if (theIndex1 != 0) {
            for (int i = 0; i < theIndex1; i++) {
                i1 = i1.next;
            }
        }
        Node<Type> i2 = head;
        for (int i = 0; i < theIndex2; i++) {
                i2 = i2.next;
        }

        if (theIndex1 == 0 && theIndex2 != count - 1) {
            //saved pointer
            Node<Type> saver1 = i1.next;
            //reassign i1
            i1.next = i2.next;
            saver1.prev = i1;
            i1.prev = i2.prev;
            i1.prev.next = i1;
            //reassign i2
            i2.next = saver1;
            i2.next.prev = i2;
            i2.prev = null;
            head = i2;
        } else if (theIndex2 == count - 1 && theIndex1 != 0) {
            // saved pointers
            Node<Type> saver1 = i1.next;
            Node<Type> saver2 = i1.prev;
            // reassign node 1 or i1
            i1.next = i2.next;
            i1.prev = i2.prev;
            i2.prev.next = i1;
            //reassign node 2 or i2
            i2.next = saver1;
            i2.next.prev = i2;
            i2.prev = saver2;
            i2.prev.next = i2;
        } else if (theIndex2 == count - 1 && theIndex1 == 0) {
            // saved pointers
            Node<Type> saver1 = i1.next;
            Node<Type> saver2 = i1.prev;
            // reassign node 1 or i1
            i1.next = i2.next;
            i1.prev = i2.prev;
            i2.prev.next = i1;
            //reassign node 2 or i2
            i2.next = saver1;
            i2.next.prev = i2;
            i2.prev = null;
            head = i2;
        } else if (theIndex1 != theIndex2) {
            // saved pointers
            Node<Type> saver1 = i2.next;
            Node<Type> saver2 = i1.prev;
            //reassigning the .nexts
            i1.prev.next = i2;
            i2.next = i1.next;
            i2.prev.next = i1;
            i1.next = saver1;
            //reassigning the .previous
            i1.next.prev = i1;
            i1.prev = i2.prev;
            i2.next.prev = i2;
            i2.prev = saver2;
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

    // nested node class but for DLL
    class Node<Type> {
        private Type elem;
        private Node<Type> next;

        private Node<Type> prev;
        Node() {
            elem = null;
            next = null;
            prev = null;
        }

    }
}
