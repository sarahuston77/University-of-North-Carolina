package assn03.assn03StarterCode;

// Starter Code provided with Assignment #3 for COMP210
// The given main method has some examples of how to create and modify the linked lists
// It contains suggestions on how to test your code after completing the TODO Tasks

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(60);
        list.add(30);
        System.out.println("list = " + list.toString());
        System.out.println("size of list = " + list.size());
        System.out.println("list contains 10?: " + list.contains(10));     // implemented
        System.out.println("list contains 50?: " + list.contains(50));
        System.out.println("set element at index 2 to be 10");
        list.set(2, 10);
        System.out.println("get element at index 2 = " + list.get(2));
        System.out.println("list = " + list.toString());
        System.out.println("Last Index of element 10 in list = " + list.lastIndexOf(10));

        list.remove(20);
        System.out.println("list after removing 20 = " + list.toString());

        System.out.println("index of '30' = " + list.indexOf(30));

        // Test task 1
        LinkedList list_t1 = new LinkedList();
        list_t1.add(5);
        list_t1.add(4);
        list_t1.add(3);
        System.out.println("list 1 = " + list.toString());
        System.out.println("list t1 = " + list_t1.toString());
        list.simpleMerge(list_t1);
        System.out.println("Task 1: list after simpleMerge with list1 = " + list.toString());

        // Test task 2
        System.out.println("list 1 = " + list.toString());
        list.removeAtIndex(1);  // TBD
        System.out.println("Task 2: list after removing element at index 1 = " + list.toString());

        // Test task 3
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println("list2 = " + list2.toString());
        System.out.println("Task 3: list == list2 ?: " + list.isEqual(list2));

        // Test task 4
        System.out.println("list before removing repeats = " + list2.toString());
        list2.removeRepeats();
        System.out.println("Task 4: list after removing repeats = " + list2.toString());

        // Test task 5
        LinkedList list5 = new LinkedList();
        list5.add(10);
        list5.add(9);
        list5.add(8);
        list5.add(7);
        System.out.println("list before reversing = " + list5.toString());
        list5.reverse();
        System.out.println("Task 5: list after reversing = " + list5.toString());

        // Test task 6
        System.out.println("list before merging = " + list.toString());
        System.out.println("list2 before merging = " + list2.toString());
        list.merge(list2);
        System.out.println("Task 6: list after merging = " + list.toString());
    }
}
