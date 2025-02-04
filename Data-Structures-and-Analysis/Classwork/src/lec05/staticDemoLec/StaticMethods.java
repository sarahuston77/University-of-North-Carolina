package lec05.staticDemoLec;

public class StaticMethods {
    public static void main(String[] args){

        // which statement will work?
        ClassB.staticMethod();

        ClassB b = new ClassB();
        b.nonStaticMethod();

    }
}

class ClassB {
    static void staticMethod() {
        System.out.println("This is a Static Method");
    }
    void nonStaticMethod() {
        System.out.println("This is a NON-Static Method");
    }
}
