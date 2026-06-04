package arrays;

class Main {

    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }

        // Time: O(log N) worst-case and average-case, O(1) best-case
        // Space: O(1) auxiliary space
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
 * - Real-world Analogy: Looking up a word in a physical dictionary. Instead of flipping through page-by-page from the start, you open the book to the middle, check if your target word comes before or after the page, and throw away the irrelevant half.
 * - Technical Analogy: Running a `git bisect` session to locate the exact commit that introduced a bug. The version control system checks out the middle commit in the range, tests it, and discards the clean/working half of the history to narrow down the culprit commit logarithmically.
 * - Limitations & Tradeoffs:
 *   - Binary search is extremely fast with O(log N) search times.
 *   - However, it strictly requires the dataset to be sorted beforehand. Pre-sorting the array takes O(N log N) time, which makes binary search inefficient if we only perform a few searches on a frequently changing dataset.
 */
