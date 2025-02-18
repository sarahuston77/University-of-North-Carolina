package assn03.assn03StarterCode;

public interface Node {

    int getValue();

    void setValue(int value);

    Node getNext();

    void setNext(Node next);

    default boolean hasNext() {
        return (getNext() != null);
    }
}