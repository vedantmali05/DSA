package arrays;

public class ArrayUtils {
    public static void arrayTraversal(int[] arr, String customString) {
        System.err.print(customString == "" ? "Printing the array: " : customString);
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i] + " ");
        }
        System.err.println();
    }
}
