package arrays;

class Main {

    public static void conquer(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid + 1;

        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            // @_remember_diary.txt Assign & Increment Trick
            if (arr[idx1] <= arr[idx2])
                merged[x++] = arr[idx1++];
            else
                merged[x++] = arr[idx2++];
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // @_remember_diary.txt Multiple pointers in one loop trick
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);

        // Time: O(N log N) worst-case, average-case, and best-case
        // Space: O(N) auxiliary space
    }

    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        divide(arr, 0, arr.length - 1);
        ArrayUtils.arrayTraversal(arr, "Sorted Array: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Sorting a massive stack of examination papers. You divide the stack into two equal halves, hand them to two teaching assistants to sort, and then merge their sorted stacks. You do this by looking at the top paper of each stack, taking the one with the lower roll number, and placing it into a new, consolidated pile.
 * - Technical Analogy: Git Merge conflicts or browser history timeline assembly. When merging two sorted lists of events (like local commits and remote commits, or browsing history from two devices synced at different times) into a single unified timeline, we compare the timestamps at the front of each list and append the older event to the final chronological list.
 * - Limitations & Tradeoffs:
 *   - Stable: Yes, it preserves the relative order of duplicate elements because the conquer step uses a strict comparison (`arr[idx1] <= arr[idx2]`) which favors the left subarray's duplicate element.
 *   - In-place: No, it requires O(N) auxiliary space to store the merged elements temporarily.
 *   - Tradeoff: Merge Sort guarantees O(N log N) time complexity in all cases (worst, average, and best). However, it requires O(N) auxiliary memory to perform the merge operation, which makes it less memory-efficient than in-place algorithms like Quick Sort or Heap Sort, especially on memory-constrained systems.
 */
