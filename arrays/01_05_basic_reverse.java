package arrays;

class Main {

    public static int[] reverseInplace(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.err.println("Invalid array input");
            return arr;
        }

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        // Time: O(N) linear scan (swaps N/2 elements)
        // Space: O(1) auxiliary space (in-place reversal using two pointers)
        return arr;
    }

    public static int[] reverseCopy(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.err.println("Invalid array input");
            return arr;
        }

        int len = arr.length;
        int[] reversedArr = new int[len];
        int j = len - 1;

        for (int i = 0; i < len; i++) {
            reversedArr[i] = arr[j];
            j--;
        }

        // Time: O(N) linear scan (copies N elements)
        // Space: O(N) auxiliary space (allocates new array of size N)
        return reversedArr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ArrayUtils.arrayTraversal(arr, "Original Array: ");
        reverseInplace(arr);
        ArrayUtils.arrayTraversal(arr, "In-place Reversed Array: ");

        int[] arr2 = { 10, 20, 30, 40, 50 };
        ArrayUtils.arrayTraversal(arr2, "Original Array 2: ");
        int[] reversed = reverseCopy(arr2);
        ArrayUtils.arrayTraversal(reversed, "Out-of-place Reversed Array: ");
        ArrayUtils.arrayTraversal(arr2, "Original Array 2 after reverseCopy: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Reversing the order of cars in a train. Two workers
 * start at the front and back, swap the first and last cars, and walk towards
 * each other, swapping cars step by step until they meet in the middle.
 * - Limitations & Tradeoffs: This in-place two-pointer algorithm is highly
 * efficient (O(N) time and O(1) space), but it is destructive as it
 * permanently alters the original array. If preserving the original array is
 * necessary, you must allocate a new array of size N, swapping O(N)
 * auxiliary space for data preservation.
 */
