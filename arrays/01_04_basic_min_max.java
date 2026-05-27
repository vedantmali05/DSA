package arrays;

class Main {

    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.err.println("Invalid array input");
            return new int[0];
        }

        int len = arr.length;

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < len; i++) {
            if (arr[i] > max)
                max = arr[i];
            else if (arr[i] < min)
                min = arr[i];
        }

        // Time: O(N) single-pass (visits each element exactly once)
        // Space: O(1) auxiliary space (only uses two scalar variables)
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 7, 6 };

        findMinMax(arr);
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: A talent scout checking a lineup of players to find the
 * tallest and shortest. The scout scans from left to right, comparing each
 * player's height to the current records in their notebook and updating the
 * entries.
 * - Limitations & Tradeoffs: On an unsorted array, we must search all elements,
 * forcing O(N) time. If the array is pre-sorted, finding min/max simplifies to
 * O(1) by reading `arr[0]` and `arr[len-1]`. For highly dynamic datasets with
 * frequent min/max requests, heaps or balanced binary search trees (BSTs) are
 * superior.
 */
