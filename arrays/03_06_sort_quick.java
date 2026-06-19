package arrays;

class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, high, i);
        // Time: O(N) worst-case, average-case, and best-case
        // Space: O(1) auxiliary space
        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
        // Time: O(N log N) average-case, O(N^2) worst-case
        // Space: O(log N) average-case auxiliary space due to call stack, O(N) worst-case
    }

    public static void main(String[] args) {
        int[] arr = { 24, 9, 29, 14, 19, 27 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        quickSort(arr, 0, arr.length - 1);
        ArrayUtils.arrayTraversal(arr, "Sorted Array: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Organizing a library shelf. You select one book as a pivot, then place all books that are alphabetically earlier than it to its left, and all books that are alphabetically later to its right. You then recursively repeat this process for the left and right sections.
 * - Technical Analogy: File system searching or directory tree categorization. In quicksort, we recursively sub-divide the problem into partitions around a pivot, similar to how files are partitioned into folders based on specific attributes (like prefix or date range) to speed up navigation.
 * - Limitations & Tradeoffs:
 *   - Stable: No. Elements are swapped over large distances across the pivot, which easily disrupts the relative order of duplicate items.
 *   - In-place: Yes, it sorts the array without using extra auxiliary arrays (O(1) extra space per call), though it does require call stack space.
 *   - Space Complexity: O(log N) average stack space due to recursive calls, but degrades to O(N) in the worst case (e.g., when the array is already sorted and we pick the extreme element as the pivot).
 *   - Time Complexity: O(N log N) on average, but degrades to O(N^2) in the worst case.
 */

