package arrays;

class Main {

    public static int[] moveZerosBruteForce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int[] newArr = new int[arr.length];
        int x = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArr[x] = arr[i];
                x++;
            }
        }

        // Time: O(N) linear time pass
        // Space: O(N) auxiliary space (allocates newArr of size N)
        return newArr;
    }

    public static int[] moveZerosInplace(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int x = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[x] = arr[i];
                x++;
            }
        }

        for (int i = x; i < arr.length; i++) {
            arr[i] = 0;
        }

        // Time: O(N) linear time pass
        // Space: O(1) auxiliary space (in-place manipulation)
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 4, 5, 6, 9, 0, 0, 0, 2, 4 };
        ArrayUtils.arrayTraversal(arr1, "Original Array 1: ");
        int[] res1 = moveZerosBruteForce(arr1);
        ArrayUtils.arrayTraversal(res1, "After Brute Force: ");
        System.out.println();

        int[] arr2 = { 3, 4, 5, 0, 6, 7, 0, 9, 2, 4 };
        ArrayUtils.arrayTraversal(arr2, "Original Array 2: ");
        int[] res2 = moveZerosInplace(arr2);
        ArrayUtils.arrayTraversal(res2, "After In-Place: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Imagine sorting books on a shelf where some books have placeholder blanks (zeros). 
 *   - Brute Force: Taking a new empty shelf, walking along the original shelf, copying only actual books to the new shelf, and automatically leaving empty slots at the end.
 *   - In-Place: Walking along the shelf with a pointer. Whenever you see a real book, you slide it to the left-most available spot. Once all books are packed, you fill the remaining spots to the right with blank templates.
 * - Technical Analogy: Compacting active entries in a UI thread list. In a dashboard app showing active vs. deleted forum threads, the list manager shifts all active threads to the front of the viewport array, and pads the remaining trailing slots with empty visual placeholders.
 * - Limitations & Tradeoffs:
 *   - Brute Force: Easy to implement and completely safe for the original array, but incurs a linear O(N) space overhead.
 *   - In-Place: Time-optimal O(N) and space-optimal O(1), but it mutates the input array directly, which could affect other parts of the program relying on the original state.
 */