package arrays;

class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Hoare Partition Scheme
     * Reorders the array around a pivot (chosen as the first element, arr[low]).
     * Returns the partition boundary index 'j' such that:
     * - All elements from low to j are <= pivot.
     * - All elements from j+1 to high are >= pivot.
     */
    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Advance i until we find an element >= pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Advance j until we find an element <= pivot
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                // Time: O(N) worst-case, average-case, and best-case
                // Space: O(1) auxiliary space
                return j;
            }

            swap(arr, i, j);

        }

    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 9, 1, 2, 8, 7 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        int pivotBoundary = partition(arr, 0, arr.length - 1);
        ArrayUtils.arrayTraversal(arr, "Partitioned Array: ");
        System.out.println("Partition boundary index (j): " + pivotBoundary);
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Sorting a stack of mixed coins (pennies and quarters) into two groups. You place your left hand on the left end and your right hand on the right end. The left hand moves right looking for a quarter, and the right hand moves left looking for a penny. Once both hands find one, they swap the coins and continue moving inward until they meet.
 * - Technical Analogy: Dual-pointer content filtering or bi-directional array scanning. When sorting or filtering elements from both ends simultaneously (e.g., placing active items on the left and inactive on the right), the two cursors move towards the center and swap elements when they are out of place, reducing unnecessary operations compared to a single-pointer sweep.
 * - Limitations & Tradeoffs:
 *   - Stable: No. Swapping elements over long distances can violate the relative order of duplicate elements.
 *   - In-place: Yes, it requires only O(1) auxiliary space.
 *   - Tradeoff: Hoare's scheme is more efficient than Lomuto because it performs around 3x fewer swaps on average. However, the partition index returned does not guarantee that the pivot is placed in its exact final sorted position; it only guarantees that all elements on the left side are <= pivot and all elements on the right side are >= pivot.
 */

