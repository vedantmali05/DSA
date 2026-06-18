package arrays;

class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {

        if (arr == null || arr.length < 1) {
            System.err.println("Array already sorted, or invalid array input");
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        // Time: O(N^2) worst-case and average-case, O(N) best-case
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        int[] arr = { 11, 12, 13, 5, 6 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        insertionSort(arr);
        ArrayUtils.arrayTraversal(arr, "Sorted Array: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Sorting a hand of playing cards. You hold the sorted cards in your left hand. You pick the next unsorted card from the table, compare it with the cards in your hand from right to left, shift the larger cards to the right, and insert the new card into its correct relative position.
 * - Technical Analogy: Real-time UI feed sorting or high-score leaderboards. When a new dynamic item (like a high score or a message) arrives in an already sorted UI stream, we scan the existing elements backwards, shift them down to make room, and insert the new item directly into its correct sorted position without needing to re-sort the entire list from scratch.
 * - Limitations & Tradeoffs:
 *   - Stable: Yes, it preserves the relative order of duplicate elements.
 *   - In-place: Yes, it sorts the array with O(1) auxiliary space.
 *   - Tradeoff: While highly inefficient (O(N^2)) for large, completely unsorted datasets compared to Quick Sort or Merge Sort, it is extremely efficient for small arrays (typically N < 10 to 15) or nearly sorted datasets. For this reason, hybrid production algorithms like Timsort use Insertion Sort for smaller chunks.
 */
