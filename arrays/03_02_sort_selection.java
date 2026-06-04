package arrays;

class Main {

    // Helper method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }

        // Time: O(N^2) worst-case, average-case, and best-case
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        selectionSort(arr);
        ArrayUtils.arrayTraversal(arr, "Sorted Array: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Sorting a hand of playing cards. You scan the unsorted cards to find the smallest one, place it at the far left, then scan the remaining cards to find the next smallest, and so on.
 * - Technical Analogy: Widget layout rendering. In a system sorting dashboard widgets based on a priority weight factor where writing/rendering a widget to screen is costly, finding the highest priority widget first and writing it next minimizes expensive layout redraw swaps.
 * - Limitations & Tradeoffs:
 *   - Unlike Bubble Sort or Insertion Sort, Selection Sort's best-case time complexity is still O(N^2) because it always has to scan the remaining unsorted subarray to find the minimum.
 *   - It is unstable (swapping can change the relative order of equal elements).
 *   - However, it is highly efficient when memory write operations (swaps) are extremely expensive, as it guarantees at most N - 1 swaps.
 */
