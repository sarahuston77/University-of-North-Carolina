package lec10;

// Example of a class trying to run methods in a different package

import lec10.de.UncStudent;

public class Main2 {
    public static void main (String[] args){
        UncStudent s1 = new UncStudent();
        s1._age = 21;
        System.out.println(s1.getID());
    }
}
