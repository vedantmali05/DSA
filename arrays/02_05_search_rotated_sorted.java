package arrays;

class Main {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[left] <= arr[mid]) {
                // Left one is sorted
                // (left...mid...x is sorted,
                // x+1...right is rotated to right)

                // Narrowing the array
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                // right one is sorted
                // (x+1...mid...right is sorted,
                // left...x is rotated to left)

                // Narrowing the array
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        // Time: O(log N) worst-case and average-case, O(1) best-case
        // Space: O(1) auxiliary space
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 16, 23, 38, 56, 72, 91, 2, 5, 8 };
        ArrayUtils.arrayTraversal(arr, "Rotated Sorted Input Array: ");

        int[] targets = { 23, 8, 91, 12, 100 };
        for (int target : targets) {
            int index = search(arr, target);
            System.out.println("Target: " + target + " -> Index: " + index);
        }
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Searching for a word in a dictionary that has been split in half and re-stacked out of order (e.g., T-Z at the front, followed by A-S). By checking the middle page, you can identify which section is sorted alphabetically and determine whether your target word lies in that contiguous section or the other.
 * - Technical Analogy: Circular Buffer UI Pagination. In a dashboard displaying logs in a circular ring buffer, logs wrap around after reaching capacity. Searching for a specific log ID requires identifying which segment of the buffer is contiguous.
 * - Limitations & Tradeoffs:
 *   - Assumes distinct elements to guarantee O(log N) time. If there are duplicates (e.g., { 2, 2, 2, 2, 0, 2 }), the algorithm cannot guarantee which half is sorted and degrades to O(N).
 *   - Requires constant-time O(1) index-based random access, making it unusable for lists like LinkedList.
 */
