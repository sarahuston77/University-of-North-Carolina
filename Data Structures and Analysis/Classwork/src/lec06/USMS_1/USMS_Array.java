package lec06.USMS_1;
import java.util.Scanner;
/**
 * Implements an Array based implementation of USMS: UNC CS Students Management
 System.
 */
public class USMS_Array {
    public static void main(String[] args) {
        AllCsStudents us = new AllCsStudents();
        us.menu();
    }
}
class CsStudent {
    static String _dept = "Computer Science";
    String _fName;
    String _lName;
    int _id;
    String _admitTerm;
}
class AllCsStudents {
    int _maxStudents = 1000;
    CsStudent[] _sList = new CsStudent[_maxStudents];
    int _studentCount;
    Scanner s = new Scanner(System.in);
    void menu() {
        boolean exit = false;
        do {
            System.out.println("\nWelcome to the UNC Students Management System(USMS)");
                    System.out.println("Press one of the following keys:");
            System.out.println("0 : For exiting.");
            System.out.println("1 : For enrolling a new student");
            System.out.println("2 : Print all students");
            System.out.println("3 : For searching for a student");
            int choice = s.nextInt();
            switch (choice) {
                case 0: {exit = true; break; }
                case 1: {addStudent(); break; }
                case 2: {printAllStudents(); break; }
                case 3: {searchStudent(); break; }
                default: {System.out.println("Invalid Entry."); break; }
            }
        } while (!exit);
    }
    void addStudent() {
        CsStudent st = new CsStudent();
        System.out.println("Enter first name:");
        st._fName = s.next();
        System.out.println("Enter last name of " + st._fName);
        st._lName = s.next();
        System.out.println("Enter student id (max 9 digits):");
        st._id = s.nextInt();
        System.out.println("Student: " + st._fName + " " + st._lName +
                " with id = " + st._id + " added.");
        _sList[_studentCount] = st;
        _studentCount++;
    }
    void printAllStudents(){
        System.out.println("Student count: " + _studentCount
                + ". Dept : " + CsStudent._dept);
        for (int i=0; i<_studentCount; i++){
            System.out.println(i+". "+_sList[i]._fName+" "
                    + _sList[i]._lName+", id="+_sList[i]._id);
        }
    }
    void searchStudent(){
        Scanner s = new Scanner(System.in);
        System.out.println("Searching an enrolled student:");
        System.out.println("Enter first or last name:");
        String name = s.nextLine();
        for (int i=0; i< _studentCount; i++){
            if (_sList[i]._fName.equals(name) || (_sList[i]._lName.equals(name))){
                System.out.println(i+". "+_sList[i]._fName+" "
                        +_sList[i]._lName+", id="+_sList[i]._id);
            }
        }
    }
}