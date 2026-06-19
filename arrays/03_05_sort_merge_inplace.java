package arrays;

class Main {

    public static void conquer(int[] arr, int si, int mid, int ei) {
        int idx1 = si;
        int idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] > arr[idx2]) {
                int curr = arr[idx2];
                for (int i = idx2; i > idx1; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[idx1] = curr;
                idx1++;
                mid++;
                idx2++;
            } else {
                idx1++;
            }
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

        // Time: O(N^2 log N) worst-case due to O(N) shifts per merge
        // Space: O(log N) stack space (no auxiliary array)
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
 * - Real-world Analogy: Sorting a hand of playing cards that you pick up one at a time. Each time you pick a new card, you slide it leftward past every card that is larger, shifting those cards one position to the right to make room. No extra table space is needed — you rearrange within the hand itself.
 * - Technical Analogy: Insertion into a sorted segment of a database index without rebuilding the index. When a new, smaller-valued record must be placed earlier in a sorted block, the existing records are shifted one slot to the right in-place before the new record is written at the correct position — analogous to how this merge inserts each out-of-order right-half element back into the left half by shifting.
 * - Limitations & Tradeoffs:
 *   - Stable: Yes, the backward shift loop preserves the relative order of equal elements because equal elements are never swapped past each other.
 *   - In-place: Yes, it requires only O(log N) stack space for recursion and O(1) extra memory during the merge step — no auxiliary array is allocated.
 *   - Tradeoff: The in-place merge step uses a right-shift loop that costs O(N) per element inserted from the right half, making the overall merge O(N^2) instead of O(N). Combined with the O(log N) recursion depth, the total time complexity degrades to O(N^2 log N) — significantly worse than the O(N log N) auxiliary version. This variant is therefore best used only when memory is extremely constrained and the extra time cost is acceptable.
 */