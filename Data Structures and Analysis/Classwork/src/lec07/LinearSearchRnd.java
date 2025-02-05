package lec07;

import static java.lang.Math.random;

// Example of Linear Search based on Random numbers
public class LinearSearchRnd {
    public static void main(String[] args) {
        int n = 6000000;        // size of array b[] 6Million
//        int n = 10000000;        // size of array b[] 10M
        // int n = 500000000;        // size of array b[] 500M
        double m = 1.0;         // m*n = range of numbers entered
        int b[] = new int[n];
        int repeat = 10;      // number of times to repeat the experiment
//        int repeat = 100;      // number of times to repeat the experiment
        for (int j = 0; j < repeat; j++) {
            int x = (int) (m * n * random());
            for (int i = 0; i < n; i++) {
                b[i] = (int) (m * n * random());
            }
            long startTime = System.nanoTime();
            System.out.println("\nStartTime=" + startTime);
            System.out.println(x + " found in array b[" + n + "] at index= " + searchArray(b, x));
            searchArray(b, x);
            long endTime = System.nanoTime();
            System.out.println("EndTime = " + endTime);
            long duration = endTime - startTime;
            long durationInMicro = duration / 1000;
            long durationInMilli = duration / 1000000;
//            System.out.println("Duration: " + durationInMicro + " microseconds");
            System.out.println("Duration: " + durationInMilli + " milliseconds");
//            System.out.println(durationInMicro );
        }
    }
    static int searchArray(int[] y, int key){
        for (int i = 0; i < y.length; i++) {
            if (y[i] == key) {
                return(i);
            }}
        return(-1);
    }
}
