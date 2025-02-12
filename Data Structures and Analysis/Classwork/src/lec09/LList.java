package lec09;
// Example of a simple Linked List

class Node {
    int _value;
    Node _nextNode;

    Node(int val){          // Constructor
        _value = val;
        _nextNode = null;
    }
}

public class LList {
    Node _head;
    Node _tail;
    int _size;

    LList(int value) {           // constructor - creates the head node
        _head = new Node(value);
        _tail = _head;
        _size = 1;
    }

    // inserts new node with given value at head of LL; returns new _head;
    public Node insertNode(int value) {
        Node node = new Node(value);
        node._nextNode = _head;
        _head = node;
        _size++;
        return (_head);
    }

    // Returns pointer to the ith node, starting at i=0
    public Node getNode(int i) {
        if (i > (_size - 1))
            return null;
        Node ptr = _head;
        if (i == 0)
            return _head;
        else
            for (int j = 1; j <= i; j++) {
                ptr = ptr._nextNode;
            }
        return ptr;
    }

    /**
     * deleteNode takes an integer value, and starting from the _head of the Linked List
     * linearly searches for the value in the .value field. If found it deletes that
     * node and returns true. If not found it returns false.
     * example:
     * list= 40 -> 30 -> 20 -> 10
     * deleteNode(20)
     * list= 40 -> 30 -> 10
     * @param value
     * @return boolean
     */
    public boolean deleteNode(int value) {
        if (_head == null) {         // case 1. Empty list
            return (false);
        } else {                      // case 2. Non-empty
            if (_head == _tail) {     // case 2a. Only 1 node
                if (_head._value == value) {
                    _head = null;
                    _tail = null;
                    _size--;
                    return (true);
                } else {
                    return (false);
                }
            }
            else {                 // case 2b. 2+ nodes
                if (_head._value == value) { // case 2b.1 at head
                    _head = _head._nextNode;
                    _size--;
                    return (true);
                } else {                      // case 2b.2. not at head
                    Node previous = _head;
                    while (previous._nextNode != null) {
                        if (previous._nextNode._value == value) {
                            previous._nextNode = previous._nextNode._nextNode;
                            _size--;

                            if (previous._nextNode == null){
                                _tail = previous;
                            }
                            return (true);
                        }
                        else previous = previous._nextNode;
                    }
                    return (false);
                }
            }
        }
    }


    public String toString() {
        String list = "";
        Node current = _head;
        while(current != null) {
            if(current._nextNode == null)
                list+= current._value;
            else
                list += current._value + " -> ";
            current = current._nextNode;
        }
        return list;
    }


}
