package lec04;
public class Arrays {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 5};
        System.out.println(a.length);
        int sum = 0; // = sum of a[i]

        int i;
        for (i=0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("i = " + i);
        System.out.println("sum = " + sum);

        // Creates an array of integers of size 4
        int[] b;
        b = new int[4];
    }
}
