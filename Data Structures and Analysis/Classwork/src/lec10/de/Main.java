package lec10.de;

// Data Encapsulation

public class Main {
    public static void main (String[] args){
        UncStudent s1 = new UncStudent();
        s1._fName = "Bob";
        s1._lName = "Allen";
        s1._age = 20;

        s1.setID(100);
    }
}
