package arrays;

class Main {

    /**
     * Frequency Count Pattern
     * Counts the occurrences of each element using their value as the index.
     * Assumes elements are non-negative.
     */
    public static int[] countFrequencies(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int[] freq = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        // Time: O(N + K) where N is the size of the array and K is the maximum element value
        // Space: O(K) auxiliary space to store frequencies
        return freq;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 3, 2, 4, 3, 0, 5, 2, 1, 27, 5 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        int[] freq = countFrequencies(arr);

        System.out.println("Frequencies:");
        for (int i = 0; i < freq.length; i++) {
            System.out.println("Element " + i + ": " + freq[i] + " times");
        }
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: A voting ballot counting box. You have distinct boxes labeled with candidate names or numbers. When you pick up a ballot with a vote for candidate 3, you place it directly in box 3. You don't need to search through all candidate boxes; you go straight to index 3.
 * - Technical Analogy: Keyboard keypress trackers or character frequency counters. When tracking keyboard inputs, keypress counts are mapped directly to keycode values in an index-based tracker array (like ASCII sizes), incrementing the corresponding key's count on every event.
 * - Limitations & Tradeoffs:
 *   - Stable: N/A (non-sorting algorithm).
 *   - In-place: No, requires O(K) auxiliary space where K is the maximum element in the array.
 *   - Tradeoff: Provides O(N) linear time frequency counting (constant O(1) lookup and increment per element). However, it is restricted to non-negative integers and suffers from massive memory overhead if the range is sparse and maximum element is very large (e.g., an array containing 1 and 1,000,000,000).
 */

