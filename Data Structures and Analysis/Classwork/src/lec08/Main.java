package lec08;

public class Main {
    public static void main(String[] args){

        // Creating a Linked List of nodes:
        System.out.println("Inserting 10, 20, 30, 40 in a simple Linked List");
        LList list = new LList(10);
        list.insertNode(20);
        list.insertNode(30);
        list.insertNode(40);

        System.out.println("Value of node 0: " + list.getNode(0)._value);
        System.out.println("Value of node 1: " + list.getNode(1)._value);
        System.out.println("Value of node 2: " + list.getNode(2)._value);
        System.out.println("Value of node 3: " + list.getNode(3)._value);

        // Creating a Linked List of nodes:
        System.out.println("Inserting 10, 20, 30, 40 at Tail end:");
        LList list2 = new LList(10);
        list2.insertNodeT(20);
        list2.insertNodeT(30);
        list2.insertNodeT(40);

        System.out.println("Value of node 0: " + list2.getNode(0)._value);
        System.out.println("Value of node 1: " + list2.getNode(1)._value);
        System.out.println("Value of node 2: " + list2.getNode(2)._value);
        System.out.println("Value of node 3: " + list2.getNode(3)._value);

    }
}

