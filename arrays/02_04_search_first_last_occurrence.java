package arrays;

class Main {

    public static int findFirstOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int result = -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Time: O(log N) worst-case and average-case, O(1) best-case
        // Space: O(1) auxiliary space
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int result = -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Time: O(log N) worst-case and average-case, O(1) best-case
        // Space: O(1) auxiliary space
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 23, 23, 38, 56, 72, 91 };
        int target = 23;

        ArrayUtils.arrayTraversal(arr, "Sorted Input Array: ");
        System.out.println("Target: " + target);

        int firstIndex = findFirstOccurrence(arr, target);
        System.out.println("First occurrence index: " + firstIndex);

        int lastIndex = findLastOccurrence(arr, target);
        System.out.println("Last occurrence index: " + lastIndex);
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Checking for the first and last editions of a specific publication volume on a library shelf. When you locate a volume matching your target year, you scan leftwards to identify the first edition printed, or scan rightwards to find the final updated revision.
 * - Technical Analogy: Range Query Indexing. Databases search for key ranges (e.g., records between timestamps X and Y) by finding the first boundary using a first-occurrence search and the ending boundary using a last-occurrence search on a B-Tree index.
 * - Limitations & Tradeoffs:
 *   - Both algorithms require pre-sorted inputs.
 *   - They use O(1) extra space because of the iterative implementation, which is highly efficient and avoids call stack overflow risk compared to recursive bounds search.
 *   - A simple alternative for finding the range of duplicate elements is finding the first occurrence, then scanning linearly to the right until the element changes. However, in the worst case (e.g., all array elements are duplicates), this fallback deteriorates to O(N), whereas doing two binary searches maintains O(log N) complexity.
 */
