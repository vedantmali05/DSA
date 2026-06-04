package arrays;

class Main {

    public static int[] rotateOne(int[] arr, boolean isRightRotate) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int index = 0;
        int oppositeIndex = arr.length - 1;
        int step = 1;
        int val = arr[index];

        if (isRightRotate) {
            index = arr.length - 1;
            oppositeIndex = 0;
            step = -1;
            val = arr[index];
        }

        for (int i = index; i != oppositeIndex; i += step) {
            if (isRightRotate)
                arr[i] = arr[i - 1];
            else
                arr[i] = arr[i + 1];
        }

        arr[oppositeIndex] = val;

        // Time: O(N) linear scan
        // Space: O(1) auxiliary space (in-place manipulation)
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };

        ArrayUtils.arrayTraversal(arr, "Original Array: ");
        rotateOne(arr, false);
        ArrayUtils.arrayTraversal(arr, "Left Rotated Array: ");

        ArrayUtils.arrayTraversal(arr, "Original Array: ");
        rotateOne(arr, true);
        ArrayUtils.arrayTraversal(arr, "Left Rotated Array: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: A queue of people where the person at the front (index
 * 0)
 * steps out of line and moves to the very back, while everyone else shifts
 * one step forward to fill the gap.
 * - Technical Analogy: Round-robin event loop or task scheduler. The executor pulls a task from index 0, runs it, and then shifts all remaining tasks forward in the queue, appending the executed task to the tail.
 * - Limitations & Tradeoffs: The in-place shifting is simple and
 * space-efficient
 * (O(1) auxiliary space), but it requires O(N) shifts. Doing this sequentially
 * for K rotations leads to an inefficient O(N * K) time complexity. For large
 * K,
 * using block reversal or direct array copies is much more efficient.
 */
