package lec05.staticDemoLec;

class ClassA {
    static int _staticVar = 20;
    int _nonStaticVar = 30;
}
public class StaticVariables {
    public static void main(String[] args) {

   // Which of these statements will work?

      System.out.println(ClassA._staticVar);
      ClassA classA = new ClassA();
      System.out.println(classA._nonStaticVar);

    }
}














 //       ClassAC cA = new ClassAC();               // instantiating ClassA and creating object cA
 //       System.out.println(cA.nonStaticVar);    // nonStaticVar can only be accessed via an object


