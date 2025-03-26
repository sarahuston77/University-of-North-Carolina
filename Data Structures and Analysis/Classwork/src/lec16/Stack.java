package lec16;

public class Stack <T extends Comparable<T>>{
    private Node<T> _top;
    private int _size;

    // pushes a node to the top of the stack
    public int push(T value){
        Node<T> node = new Node<>();
        node._value = value;
        node._lowerNode = _top;
        _top = node;
        _size++;
        return (_size-1);
    }

    public Node<T> replace(T value1, T value2){
        Node<T> pointer = _top;

        while(pointer != null){
            if (pointer._value.compareTo(value1)==0){
                pointer._value = value2;
                return (pointer);
            }
            pointer = pointer._lowerNode;
        }
        return (null);
    }
}
