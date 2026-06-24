package arrays;

public class ArrayUtils {
    public static void arrayTraversal(int[] arr) {
        arrayTraversal(arr, 0, arr == null ? -1 : arr.length - 1, "");
    }

    public static void arrayTraversal(int[] arr, String customString) {
        arrayTraversal(arr, 0, arr == null ? -1 : arr.length - 1, customString);
    }

    public static void arrayTraversal(int[] arr, int start, int end) {
        arrayTraversal(arr, start, end, "");
    }

    public static void arrayTraversal(int[] arr, int start, int end, String customString) {
        if (arr == null) {
            System.err.println("Array is null.");
            return;
        }
        
        if (arr.length == 0) {
            if (start != 0 || end != -1) {
                System.err.println("Invalid bounds for array traversal.");
                return;
            }
        } else {
            if (start < 0 || end >= arr.length || start > end) {
                System.err.println("Invalid bounds for array traversal.");
                return;
            }
        }
        
        String header = (customString == null || customString.isEmpty()) ? "Printing the array: " : customString;
        System.err.print(header);
        
        for (int i = start; i <= end; i++) {
            System.err.print(arr[i] + " ");
        }
        System.err.println();
    }

    public static void printMatrix(int[][] matrix) {
        printMatrix(matrix, "");
    }

    public static void printMatrix(int[][] matrix, String customString) {
        if (matrix == null) {
            System.out.println("null");
            return;
        }

        if (customString != null && !customString.isEmpty()) {
            System.out.println(customString);
        }

        for (int[] row : matrix) {
            if (row == null) {
                System.out.println("null");
                continue;
            }
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
