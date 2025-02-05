package lec07;
// Example of Linear Search
public class LinearSearch {
    public static void main(String[] args) {
        int[] y = {20, 5, 9, 25, 10, 4, 61};
        int key = 10;         // The key to search for
        System.out.println(searchArray(y, key));
    }
    static int searchArray(int[] y, int key){
        for (int i = 0; i < y.length; i++) {
            if (y[i] == key) {
                return(i);
            }
        }
        return(-1);
    }
}
