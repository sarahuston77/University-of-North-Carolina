package assn01;

// Import Scanner
import java.util.Scanner;

public class JavaStarter {
    public static void main(String[] args) {

        // Create a new instance of a Scanner that takes integer input from the user
        Scanner scanner = new Scanner(System.in);

        // Assign the input integer to variable
        int n = scanner.nextInt();

        // Test if the integer is 1, then print formatted string
        switch (n) {
            case 1:
                System.out.println("Hello, World\n");
                break;

                // Test if the integer is 2, then have user enter 2 doubles (a, b)
                // and another integer m on separate lines
            case 2:
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                int m = scanner.nextInt();

                System.out.println("a = " + a + ", b = " + b + ", m = " + m);
                break;

                // If integer is 3, then return a double = a*m^2 + bc
            case 3:
                double a_2 = scanner.nextDouble();
                double b_2 = scanner.nextDouble();
                int m_2 = scanner.nextInt();
                System.out.println(quadFun(a_2, b_2, m_2));

                break;
                // If integer is 4, then input a string and return it as all uppercase
            case 4:

                String s1 = scanner.next();
                System.out.println(stringFun1(s1));
                break;

                // If integer is 5, then concatenate substrings via positions and next 4 integers
            case 5:
                String s2 = scanner.next();
                int i1 = scanner.nextInt();
                int i2 = scanner.nextInt();
                int i3 = scanner.nextInt();
                int i4 = scanner.nextInt();

                System.out.println(stringFun2(s2, i1, i2, i3, i4));
                break;

                // Creates an array of double data type of size m and gets m real numbers from user.
                // Makes the numbers floats with 2 decimal places and enters them in the array.
            case 6:
                int m_3 = scanner.nextInt();
                double[] arr = new double[m_3];

                for (int index = 0; index < m_3; index++) {
                    arr[index] = scanner.nextDouble();
                }

                double sum = 0;
                for (Double value : arr) {
                    sum += value;
                }

                sum = sum / m_3;

                System.out.format("Average = " + "%.2f", sum);
                System.out.println();

                for (int index = m_3 - 1; index >= 0; index--) {
                    System.out.println("arr[" + index + "]" + "=" + arr[index]);
                }
                break;
        }
    }
    // Math function
    static double quadFun(double a, double b, int m) {
        return (a * (m * m) + b);
    }

    // Upper case function
    static String stringFun1(String s1) {
        return s1.toUpperCase();
    }

    // Combines strings using 2 pairs of new indexes
    static String stringFun2(String s1, int i1, int i2, int i3, int i4) {
        return s1.substring(i1, i2) + s1.substring(i3, i4);
    }
}