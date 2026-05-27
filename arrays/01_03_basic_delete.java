package arrays;

class Main {

    public static int[] deleteByIndex(int[] arr, int index) {

        if (arr == null || arr.length == 0) {
            System.err.println("Invalid array input");
            return arr;
        }

        int len = arr.length;

        if (index < 0 || index >= len) {
            System.err.println("Index Out of Bounds");
            return arr;
        }

        for (int i = index; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[len - 1] = 0;

        // Time: O(N) worst-case (deleting index 0 requires N - 1 shifts), O(1)
        // best-case (deleting last element)
        // Space: O(1) auxiliary space (in-place manipulation)
        return arr;
    }

    public static int[] deleteByValue(int[] arr, int value) {
        if (arr == null) {
            System.err.println("No array provided.");
            return arr;
        }

        int len = arr.length;
        int index = -1;

        for (int i = 0; i < len; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            deleteByIndex(arr, index);
        } else {
            System.err.println("Element not found: " + value);
        }

        // Time: O(N) (worst-case search + shift both take linear time)
        // Space: O(1) auxiliary space
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        ArrayUtils.arrayTraversal(arr, "Original Array: ");

        deleteByIndex(arr, 2);
        ArrayUtils.arrayTraversal(arr, "After Deleting by Index 2 (value 3): ");

        deleteByValue(arr, 5);
        ArrayUtils.arrayTraversal(arr, "After Deleting Value 5: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: A queue of customers waiting at a checkout. If the
 * person at index 2 cancels and leaves, everyone standing behind them must step
 * forward one step to close the gap, leaving an empty space at the very tail of
 * the line.
 * - Limitations & Tradeoffs: Element compaction has a linear O(N) overhead. If
 * maintaining index order is not a requirement, deletion can be optimized to
 * O(1) by swapping the target element with the last element and decrementing
 * the size parameter.
 */
