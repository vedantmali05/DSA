package arrays;

class Main {

    public static int[] computeSuffixSum(int[] arr) {
        if (arr == null) {
            return new int[0];
        }

        int[] suffix = new int[arr.length + 1];

        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = arr[i] + suffix[i + 1];
        }

        // Time: O(N) worst-case, Space: O(N) auxiliary space
        return suffix;
    }

    public static int rangeSum(int[] suffix, int L, int R) {
        if (suffix == null || suffix.length <= 1) {
            return 0;
        }

        if (L < 0 || R >= suffix.length - 1 || L > R) {
            System.err.println("Invalid range sum bounds.");
            return 0;
        }

        // Time: O(1) worst-case, Space: O(1) auxiliary space
        return suffix[L] - suffix[R + 1];
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };

        // DRY RUN Example, ignore
        // [150, 140, 120, 90, 50, 0]
        // L0........R2
        // 10 + 20 + 30 = 60
        // [L0] - [R2 + 1]

        ArrayUtils.arrayTraversal(arr, "Input Array: ");

        int[] suffix = computeSuffixSum(arr);

        if (suffix != null) {
            ArrayUtils.arrayTraversal(suffix, "Suffix Sum Array: ");
            // Example Query 1: sum from index 1 to 3 (20 + 30 + 40 = 90)
            System.out.println("Sum of range [1, 3]: " + rangeSum(suffix, 1, 3));

            // Example Query 2: sum from index 0 to 4 (10 + 20 + 30 + 40 + 50 = 150)
            System.out.println("Sum of range [0, 4]: " + rangeSum(suffix, 0, 4));
        }
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of a multi-leg flight itinerary or train route with multiple stops. If
 * you start at Station 0 and go to Station N,
 * you can pre-calculate the total distance remaining from each station to the
 * final destination (the suffix sum).
 * If you want to know the distance between Station L and Station R, you simply
 * take the total distance remaining at Station L
 * and subtract the distance remaining after you depart Station R (which is
 * stored at index R + 1).
 * 
 * Technical Analogy:
 * In dynamic viewport rendering (like virtual scrolling or rendering infinite
 * scroll content in web and mobile applications),
 * to instantly calculate the total height of unrendered elements below the
 * current scroll offset, we pre-calculate the
 * suffix sum of item heights. This allows us to adjust scrollbar heights and
 * position items accurately in constant time.
 * 
 * Limitations & Tradeoffs:
 * - Space Tradeoff: Requires O(N) extra space to store the suffix sum array.
 * - Precomputation Cost: O(N) initial setup time.
 * - Static Data Requirement: Suffix sum is optimal for queries on static
 * arrays. If any element in the original array
 * changes, the entire suffix sum array needs to be recalculated in O(N) time.
 * For dynamic range sum queries,
 * Fenwick Trees (Binary Indexed Trees) or Segment Trees are more appropriate.
 */
