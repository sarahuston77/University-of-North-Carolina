package lec08;
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
    int _size;
    Node _tail;

    LList(int value) {           // constructor - creates the head node
        _head = new Node(value);
        _size = 1;
        _tail = _head;
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
        if (i > (_size-1))
            return null;
        Node ptr = _head;
        if (i == 0)
            return _head;
        else
            for (int j=1; j <= i; j++){
            ptr = ptr._nextNode;
            }return ptr;
        }

    // Inserts new node with given value at tail of LL; returns new _tail;
    public Node insertNodeT(int value){
        Node node = new Node(value);
        _tail._nextNode = node;
        _tail = node;
        _size++;
        return(_tail);
    }
}