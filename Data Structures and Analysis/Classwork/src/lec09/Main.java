package lec09;

public class Main {
    public static void main(String[] args){

        // Creating a Linked List of nodes:
        System.out.println("Inserting 10, 20, 30, 40 in a simple Linked List");
        LList list = new LList(10);
        list.insertNode(20);
        list.insertNode(30);
        list.insertNode(40);

        System.out.println(list.toString());

        list.deleteNode(30);
        System.out.println("30 deleted: " + list.toString());

        list.deleteNode(40);
        System.out.println("40 deleted: " + list.toString());

        list.deleteNode(10);
        System.out.println("10 deleted: " + list.toString());

        list.deleteNode(20);
        System.out.println("20 deleted: " + list.toString());

        list.deleteNode(10);
        System.out.println("10 deleted: " + list.toString());
    }
}

