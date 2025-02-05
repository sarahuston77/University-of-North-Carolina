package lec07;
// Example of O(n) Space Complexity, n=y.length
public class SpaceComplexity {
    public static void main(String[] args) {
        int[] a = {20, 5, 9, 25, 10, 4, 61};
        int x = 100;         // The number to search for
        System.out.println(copyArray(a, x)[0]);
    }
    static int[] copyArray(int[] y, int key){
        int[] z = new int[y.length];
        for (int i = 0; i < y.length; i++) {
            z[i] = y[i];
        }
        return z;
    }
}
