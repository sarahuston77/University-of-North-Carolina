package lec04;
import java.util.Scanner;
public class ArrayFill {
    static int max = 10;
    static int[] list = new int[max];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nHow many numbers (integers) would you like to enter?");
        int n = s.nextInt();
        System.out.println("\nPlease enter " + n + " integers, each followed by a c/r");
        for (int i=0; i<n; i++){
            list[i] = s.nextInt();
        }
        System.out.println("\nHere are the numbers you entered in the array 'list[]':");
        for (int i=0; i<n; i++){
            System.out.println("list["+i+"] = " + list[i]);
        }
    }
}