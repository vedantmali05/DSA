package arrays;

class Main {

    public static int[] computePrefixSum(int[] arr) {

        int[] prefix = new int[arr.length + 1];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = arr[i - 1] + prefix[i - 1];
        }

        // Time: O(N) worst-case, Space: O(N) auxiliary space
        return prefix;
    }

    public static int rangeSum(int[] prefix, int L, int R) {
        // Time: O(1) worst-case, Space: O(1) auxiliary space
        return prefix[R + 1] - prefix[L];
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");

        int[] prefix = computePrefixSum(arr);

        // Example Query 1: sum from index 1 to 3 (20 + 30 + 40 = 90)
        System.out.println("Sum of range [1, 3]: " + rangeSum(prefix, 1, 3));

        // Example Query 2: sum from index 0 to 4 (10 + 20 + 30 + 40 + 50 = 150)
        System.out.println("Sum of range [0, 4]: " + rangeSum(prefix, 0, 4));
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of milestone markers along a highway. Instead of measuring the distance between any two exits by
 * driving and counting miles from scratch every time, you pre-calculate the distance from the starting point (Exit 0)
 * to every exit. If exit A is at mile 10 and exit B is at mile 60, the distance between them is simply 60 - 10 = 50 miles.
 * 
 * Technical Analogy:
 * In a web browser or rendering engine, when positioning a list of variable-width text spans or blocks horizontally,
 * we can precompute the accumulated width (prefix sum of widths) to instantly find the X-coordinate offset of any
 * element or the total width of a selection range.
 * 
 * Limitations & Tradeoffs:
 * - Space Tradeoff: Requires O(N) extra space to store the prefix sum array.
 * - Precomputation Cost: O(N) initial setup cost.
 * - Static Data Requirement: Highly efficient for query-heavy scenarios on static data. However, if the underlying array
 *   is updated frequently, updating the prefix sum array takes O(N) time in the worst case, making it inefficient.
 *   For dynamic range sum queries, structures like Fenwick Trees (Binary Indexed Trees) or Segment Trees are preferred.
 */
