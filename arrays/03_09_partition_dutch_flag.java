package arrays;

class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Dutch National Flag (3-way) Partition Scheme
     * Groups an array of 0s, 1s, and 2s in-place in a single pass.
     */
    public static void threeWayPartition(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid++, low++);
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high--);
            }
        }
        // Time: O(N) worst-case, average-case, and best-case
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 1, 2, 0, 1, 0, 2, 1 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        threeWayPartition(arr);
        ArrayUtils.arrayTraversal(arr, "Partitioned Array: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Sorting a pile of mixed recyclable materials (metal, plastic, and paper). You have a bin for metal on your far left, a bin for paper on your far right, and plastic accumulates in the middle. You inspect each item: toss metal to the left, paper to the right, and leave plastic in the middle.
 * - Technical Analogy: 3-way layout partitioning in UI rendering or data streaming. For instance, separating high-priority, medium-priority, and low-priority tasks in a scheduler's active buffer in a single pass, grouping them into distinct memory zones for fast access.
 * - Limitations & Tradeoffs:
 *   - Stable: No. Swapping elements across the array can disrupt the relative order of duplicate items.
 *   - In-place: Yes, it requires only O(1) auxiliary space.
 *   - Tradeoff: Extremely efficient when the array has only a few unique keys (like 3 distinct values), sorting them in O(N) time. However, it is not general-purpose and does not scale well if the number of distinct keys is large or arbitrary.
 */

