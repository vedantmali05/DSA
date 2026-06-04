package arrays;

class Main {

    public static int findFirstOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }

        // Time: O(N) worst-case, O(1) best-case
        // Space: O(1) auxiliary space
        return -1;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target)
                return i;
        }

        // Time: O(N) worst-case, O(1) best-case
        // Space: O(1) auxiliary space
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 5, 2, 7, 8, 2, 3 };
        int target = 2;

        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        System.out.println("Target: " + target);

        int firstIndex = findFirstOccurrence(arr, target);
        System.out.println("First occurrence index: " + firstIndex);

        int lastIndex = findLastOccurrence(arr, target);
        System.out.println("Last occurrence index: " + lastIndex);
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Imagine flipping through a deck of cards one by one from top to bottom looking for an Ace.
 *   - First Match: You stop as soon as you find the first Ace.
 *   - Last Match: You flip from the bottom of the deck to the top, stopping at the first Ace you see.
 * - Technical Analogy: Implementing a Ctrl+F search in a basic text editor. The search engine iterates character by character through the document buffer, searching forward (first match) or backward (last match) from the current cursor index until the search query matches.
 * - Limitations & Tradeoffs:
 *   - Linear search is highly flexible because it works on unsorted collections and requires no pre-processing.
 *   - However, it has an O(N) worst-case time complexity, making it slow for very large datasets compared to binary search (which is O(log N) but requires the array to be sorted).
 */
