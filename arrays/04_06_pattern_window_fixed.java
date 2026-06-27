package arrays;

class Main {

    /**
     * Finds the maximum sum of any contiguous subarray of size K.
     * 
     * @param arr the input array of integers
     * @param k   the size of the sliding window
     * @return the maximum sum of a subarray of size K
     */
    public static int maxSubarraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k || k <= 0) {
            System.out.println("Invalid Input");
            return -1;
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int i = 1; i <= arr.length - k; i++) {
            windowSum = (windowSum - arr[i - 1]) + arr[i + k - 1];
            if (windowSum > maxSum)
                maxSum = windowSum;
        }

        // Time: O(N) worst-case (where N is arr.length)
        // Space: O(1) auxiliary space
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 1, 5, 1, 3, 2 };
        int k1 = 3;
        System.out.print("Array 1: ");
        ArrayUtils.arrayTraversal(arr1);
        System.out.println("Window Size K: " + k1);
        System.out.println("Max Subarray Sum: " + maxSubarraySum(arr1, k1));

        System.out.println();

        int[] arr2 = { 2, 3, 4, 1, 5 };
        int k2 = 2;
        System.out.print("Array 2: ");
        ArrayUtils.arrayTraversal(arr2);
        System.out.println("Window Size K: " + k2);
        System.out.println("Max Subarray Sum: " + maxSubarraySum(arr2, k2));
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of a moving passenger train with a fixed number of cars (size K). As the train 
 * moves forward along a track, a new group of passengers enters the front car, and a 
 * group of passengers leaves the rear car. The total passenger count on the train is 
 * updated in constant time by adding the newcomers and subtracting those who left.
 * 
 * Technical Analogy:
 * - Network Streaming: Calculating a moving average of packet delivery latencies within a 
 *   sliding window of the last K packets to monitor QoS.
 * - Image Processing & DSP: A moving average smoothing filter or kernel passing over an 
 *   audio waveform or a digital image row.
 * 
 * Limitations & Tradeoffs:
 * - Fixed Size Constraint: This O(N) optimization relies on the window size remaining constant 
 *   throughout the traversal. If the window size varies based on dynamic bounds (e.g., matching 
 *   a target sum), we must transition to a variable-size sliding window (two-pointer approach).
 * - Numeric Overflow: When summing large integers over large window sizes, the accumulator 
 *   windowSum can exceed standard 32-bit integer limits. Using a 64-bit long accumulator is 
 *   recommended in production to prevent overflow.
 */
