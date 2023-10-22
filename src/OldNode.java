/*
Alyssa Goodwin
CSS 342
Assignment 1a
Due: Oct 22, 2023
 */
class OldNode<Type> {
    private Type elem;
    private OldNode next;
    //Default constructor
    public OldNode() {
        elem = null;
        next = null;
    }

    //Constructor for Single Linked List application
    public OldNode(Type theElem, OldNode theNext) {
        if (theElem == null || theNext == null) {
            throw new NullPointerException("Cannot pass null value");
        }
        elem = theElem;
        next = theNext;
    }

    //Getter for element field
    public Type elem() {
        return elem;
    }

    //Getter for next field
    public OldNode next() {
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
    public void setNext(OldNode theNext) {
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

