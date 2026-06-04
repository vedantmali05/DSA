package arrays;

class Main {

    // Helper method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Stub for standard/unoptimized bubble sort
    public static void bubbleSortUnoptimized(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }

        // Time: O(N^2) worst-case, average-case, and best-case
        // Space: O(1) auxiliary space
    }

    // Stub for optimized bubble sort (early exit when no swaps occur)
    public static void bubbleSortOptimized(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                return;
        }

        // Time: O(N^2) worst-case and average-case, O(N) best-case
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        int[] arr1 = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("--- Test Unoptimized Bubble Sort ---");
        ArrayUtils.arrayTraversal(arr1, "Input Array: ");
        bubbleSortUnoptimized(arr1);
        ArrayUtils.arrayTraversal(arr1, "Sorted Array: ");

        int[] arr2 = { 11, 12, 22, 25, 34, 64, 90 }; // Already sorted array to test optimization
        System.out.println("\n--- Test Optimized Bubble Sort (Already Sorted) ---");
        ArrayUtils.arrayTraversal(arr2, "Input Array: ");
        bubbleSortOptimized(arr2);
        ArrayUtils.arrayTraversal(arr2, "Sorted Array: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Bubbles rising to the surface of a liquid. The largest bubble (largest number) rises to the top (end of the array) first, followed by the next largest, and so on. Or sorting a stack of folders by category number by repeatedly swapping adjacent out-of-order folders.
 * - Technical Analogy: Layout alignment pass in UI render engines. Some CSS flexbox or grid implementations perform adjacent measurement comparisons and swaps to sort elements by their flex order property during a rendering layout phase.
 * - Limitations & Tradeoffs:
 *   - O(N^2) worst-case time complexity makes it highly inefficient for large datasets compared to Merge Sort or Quick Sort.
 *   - It is a stable sort and sorts in-place with O(1) extra space.
 *   - The optimized version has an O(N) best-case time complexity, making it highly efficient if the array is already sorted or nearly sorted.
 */