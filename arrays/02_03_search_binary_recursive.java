package arrays;

class Main {

    // Public wrapper method
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }

    // Recursive helper method
    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        // 1. BASE CASE: Target not found (search range is exhausted)
        if (left > right) return -1;

        // Calculate mid safely
        int mid = left + (right - left) / 2;

        // 2. BASE CASE: Target found at mid
        if (arr[mid] == target) return mid;

        // 3. RECURSIVE CASES: Call helper with updated bounds
        else if (arr[mid] < target) return binarySearchHelper(arr, target, mid + 1, right);
        else if (arr[mid] > target) return binarySearchHelper(arr, target, left, mid - 1);

        // Time: O(log N) worst-case and average-case, O(1) best-case
        // Space: O(log N) auxiliary space (due to function call frames on the Call Stack)
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int target = 23;

        ArrayUtils.arrayTraversal(arr, "Sorted Input Array: ");
        System.out.println("Target: " + target);

        int result = binarySearch(arr, target);
        System.out.println("Target found at index: " + result);
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Checking a page in a physical dictionary recursively. You open the dictionary at the middle page. If the word isn't there, you hand the left half or right half of the book to an assistant and tell them to repeat the exact same task.
 * - Technical Analogy: Recursive `git bisect` sessions. In large automated test pipelines, bisect engines divide git ranges and spawn new sub-pipelines to run the tests on the middle commit, calling itself recursively with the filtered branch commit history.
 * - Limitations & Tradeoffs:
 *   - The recursive approach is conceptually clean and mirrors the mathematical definition of divide-and-conquer.
 *   - However, it has an O(log N) auxiliary space complexity due to the recursive stack memory overhead. For extremely deep recursions, this can risk a StackOverflowError, making the iterative O(1) space binary search preferred in production environments.
 */
