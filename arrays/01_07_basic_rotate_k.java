package arrays;

class Main {

    public static int[] rotateKLeft(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        k = k % arr.length;
        if (k < 0) {
            k += arr.length;
        }
        if (k == 0)
            return arr;

        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = 0; i < k; i++) {
            arr[arr.length - k + i] = temp[i];
        }

        // Time: O(N) linear scan (copies and shifts N elements)
        // Space: O(k) auxiliary space (allocates new array slice of size K)
        return arr;
    }

    public static int[] rotateKRight(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        k = k % arr.length;
        if (k < 0) {
            k += arr.length;
        }
        if (k == 0)
            return arr;

        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[arr.length - k + i];
        }

        for (int i = arr.length - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }

        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

        // Time: O(N) linear scan (copies and shifts N elements)
        // Space: O(k) auxiliary space (allocates new array slice of size K)
        return arr;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] rotateLeftBlockReversal(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        k = k % arr.length; // Scale k to fit array length bounds
        if (k == 0)
            return arr;

        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        // Time: O(N) linear time reversal passes
        // Space: O(1) auxiliary space (in-place manipulation)
        return arr;
    }

    public static int[] rotateRightBlockReversal(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        k = k % arr.length; // Handle k >= n
        if (k == 0)
            return arr;

        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, 0, arr.length - 1);

        // Time: O(N) linear time reversal passes
        // Space: O(1) auxiliary space (in-place manipulation)
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
        int k = 3;

        ArrayUtils.arrayTraversal(arr, "Original Array: ");
        int[] res1 = rotateKLeft(arr, k);
        ArrayUtils.arrayTraversal(res1, "Left Rotated Array (K=" + k + "): ");

        int[] arr2 = { 10, 20, 30, 40, 50, 60, 70 };
        ArrayUtils.arrayTraversal(arr2, "Original Array 2: ");
        rotateKRight(arr2, k);
        ArrayUtils.arrayTraversal(arr2, "Right Rotated Array (K=" + k + "): ");

        int[] arr3 = { 10, 20, 30, 40, 50, 60, 70 };
        ArrayUtils.arrayTraversal(arr3, "Original Array 3: ");
        rotateLeftBlockReversal(arr3, 2);
        ArrayUtils.arrayTraversal(arr3, "Left Block Reversal Rotated (K=2): ");

        int[] arr4 = { 10, 20, 30, 40, 50, 60, 70 };
        ArrayUtils.arrayTraversal(arr4, "Original Array 4: ");
        rotateRightBlockReversal(arr4, 2);
        ArrayUtils.arrayTraversal(arr4, "Right Block Reversal Rotated (K=2): ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Reversing book sections on a shelf. To rotate a shelf
 * of books left by K positions, you can reverse the first K books, reverse
 * the remaining N-K books, and then reverse the entire shelf.
 * - Technical Analogy: Column cyclic scrolling in horizontal UI grid views or
 * spreadsheet components. When a user scrolls past K columns, the renderer
 * rotates the column data indices by K positions using block reversal to keep
 * memory moves minimal and in-place.
 * - Limitations & Tradeoffs: The block reversal algorithm is highly optimized
 * because it performs exactly 3 array reversal passes (O(N) operations total)
 * and requires only O(1) auxiliary space. Compared to shifting elements
 * one-by-one
 * K times (O(N * K)), block reversal is significantly faster for large K.
 */
