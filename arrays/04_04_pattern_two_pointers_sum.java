package arrays;

class Main {

    public static int[] findPairWithSumBruteForce(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    return new int[] { i, j };
            }
        }

        // Time: O(N^2) worst-case, Space: O(1) auxiliary space
        return new int[0];
    }

    public static int[] findPairWithSumTwoPointers(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[0];
        }

        // If target is more, increment left
        // If target is less, decrement right
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target)
                return new int[] { i, j };
            else if (sum < target)
                i++;
            else if (sum > target)
                j--;
        }

        // Time: O(N) worst-case, Space: O(1) auxiliary space
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int target = 70;

        ArrayUtils.arrayTraversal(arr, "Input Sorted Array: ");
        System.out.println("Target Sum: " + target);

        int[] bruteResult = findPairWithSumBruteForce(arr, target);
        if (bruteResult.length == 2) {
            System.out.println("Brute Force: Found pair at indices [" + bruteResult[0] + ", " + bruteResult[1] + "]");
        } else {
            System.out.println("Brute Force: No pair found");
        }

        int[] optimalResult = findPairWithSumTwoPointers(arr, target);
        if (optimalResult.length == 2) {
            System.out.println(
                    "Two Pointers: Found pair at indices [" + optimalResult[0] + ", " + optimalResult[1] + "]");
        } else {
            System.out.println("Two Pointers: No pair found");
        }
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Imagine a balance scale with two trays, one on the far left and one on the far right. You place weights on both trays.
 * If the total weight is too heavy (greater than target), you swap the right weight for a lighter weight (moving the right pointer inward).
 * If the total weight is too light (less than target), you swap the left weight for a heavier weight (moving the left pointer inward).
 * You repeat this until the scale is perfectly balanced.
 * 
 * Technical Analogy:
 * In user interfaces that display zoomable scale sliders or custom range selectors (e.g., video editors selecting a timeline range),
 * adjusting start (left) and end (right) handles inward or outward is done depending on whether the current selection length is larger or smaller than
 * the target width.
 * 
 * Limitations & Tradeoffs:
 * - Sorted Data Requirement: This pattern strictly relies on the array being sorted. If the array is unsorted, we would have to sort it first,
 *   taking O(N log N) time. Alternatively, we could use a hash map to achieve O(N) time complexity at the cost of O(N) auxiliary space.
 * - In-place Mutation Tradeoffs: If we sort the array in-place, the original indices of the elements are modified, which might be undesirable if the
 *   original indices need to be returned.
 */

