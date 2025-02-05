package lec07;

import static java.lang.Math.random;

public class ComplexityArrays {
    public static void main(String[] args) {
        int max = 100;
        double[] a1 = new double[max];                    // 1 dimensional array
        double[][] a2 = new double[max][max];             // 2 dimensional array
        double[][][] a3 = new double[max][max][max];      // 3-dimensional array

        System.out.println(example1_Array(100, a1));
        System.out.println(example2_Array(100, a2));
        System.out.println(example3_Array(100, a3));
    }

    // Single 'for' loop
    static double example1_Array(int n, double[] a1) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            a1[i] = random();
            sum = sum + a1[i];
        }
        return sum;
    }

    // Doubly nested 'for' loop
    static double example2_Array(int n, double[][] a2) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a2[i][j] = random();
                sum = sum + a2[i][j];
            }
        }
        return sum;
    }

    // Triple nested 'for' loop
    static double example3_Array(int n, double[][][] a3) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a3[i][j][k] = random();
                    sum = sum + a3[i][j][k];
                }}}
        return sum;
    }
}
