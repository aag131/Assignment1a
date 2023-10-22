/*
Alyssa Goodwin
CSS 342
Assignment 1a
Due: Oct 22, 2023
 */
class Node<Type> {
    private Type elem;
    private Node next;
    //Default constructor
    public Node() {
        elem = null;
        next = null;
    }

    //Constructor for Single Linked List application
    public Node(Type theElem, Node theNext) {
        if (theElem == null || theNext == null) {
            throw new NullPointerException("Cannot pass null value");
        }
        elem = theElem;
        next = theNext;
    }

    //Getter for element field
    public Type getElement() {
        return elem;
    }

    //Getter for next field
    public Node getNext() {
        return next;
    }


    //Setter for element field
    public void setElement(Type theElem) {
        if (theElem == null) {
            throw new NullPointerException("Cannot pass null element");
        }
        elem = theElem;
    }

    //Setter for next field
    public void setNext(Node theNext) {
        if (theNext == null) {
            throw new NullPointerException("Cannot pass null node");
        }
        next = theNext;
    }
    // checks if the node is empty if it's used in a singly linked list
    public boolean isEmptySLL() {
        return elem == null && next == null;
    }
}

