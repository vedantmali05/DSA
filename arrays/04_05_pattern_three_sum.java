package arrays;

import java.util.List;
import java.util.ArrayList;

class Main {

    // Helper method to sort array manually to avoid using built-in Arrays.sort()
    private static void selectionSort(int[] arr) {
        if (arr == null)
            return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] findUniqueTripletWithSum(int[] arr, int target) {

        if (arr == null || arr.length < 3) {
            System.err.println("Invalid Array input");
            return new int[0];
        }

        int i = 0;

        while (i < arr.length - 2) {
            int reducedTarget = target - arr[i];
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int twoSum = arr[j] + arr[k];

                if (twoSum == reducedTarget) {
                    return new int[] { arr[i], arr[j], arr[k] };
                } else if (twoSum < reducedTarget) {
                    j++;
                } else if (twoSum > reducedTarget) {
                    k--;
                }
            }

            i++;
        }

        // Time: O(N^2) worst-case, Space: O(1) auxiliary space (excluding manual selection sort)
        return new int[0];
    }

    public static List<List<Integer>> findAllTripletsWithSum(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            System.err.println("Invalid Array input");
            return new ArrayList<>();
        }

        List<List<Integer>> tripletList = new ArrayList<>();

        int i = 0;

        while (i < arr.length - 2) {
            // If duplicate elements exists, triplet can be found
            // But, these triplets will be duplicate too
            // As array is sorted, duplicate elements will be consecutive
            // Skip all the consecutive elements
            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }

            // Main logic
            int reducedTarget = target - arr[i];
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {

                int twoSum = arr[j] + arr[k];

                if (twoSum == reducedTarget) {

                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(arr[i]);
                    triplet.add(arr[j]);
                    triplet.add(arr[k]);
                    tripletList.add(triplet);
                    j++;
                    k--;

                    // Increment till the next unique element is found
                    // In case of consecutive duplicate elements
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (k > j && arr[k] == arr[k + 1])
                        k--;

                } else if (twoSum < reducedTarget) {
                    j++;
                } else if (twoSum > reducedTarget) {
                    k--;
                }
            }

            i++;
        }

        // Time: O(N^2) worst-case, Space: O(1) auxiliary space (excluding result list)
        return tripletList;
    }

    public static int findThreeSumClosest(int[] arr, int target) {

        if (arr == null || arr.length < 3) {
            System.err.println("Invalid Array input");
            return 0;
        }

        int i = 0;
        int closestSum = arr[0] + arr[1] + arr[2];

        while (i < arr.length - 2) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == target)
                    return sum;

                if (Math.abs(sum - target) < Math.abs(closestSum - target))
                    closestSum = sum;

                if (sum < target)
                    j++;
                else if (sum > target)
                    k--;
            }

            i++;
        }

        // Time: O(N^2) worst-case, Space: O(1) auxiliary space
        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int target = 0;

        ArrayUtils.arrayTraversal(arr, "Original Array: ");

        // Manual sort before running two-pointer based 3-Sum logic
        selectionSort(arr);
        ArrayUtils.arrayTraversal(arr, "Sorted Array: ");

        int[] triplet = findUniqueTripletWithSum(arr, target);
        if (triplet.length == 3) {
            System.out.println("Unique Triplet: [" + triplet[0] + ", " + triplet[1] + ", " + triplet[2] + "]");
        } else {
            System.out.println("Unique Triplet: Not found");
        }

        List<List<Integer>> allTriplets = findAllTripletsWithSum(arr, target);
        System.out.println("All Triplets with sum " + target + ": " + allTriplets);

        int[] arr2 = { -1, 2, 1, -4 };
        int target2 = 1;
        selectionSort(arr2);
        int closestSum = findThreeSumClosest(arr2, target2);
        System.out.println("Closest Sum to " + target2 + " in [-1, 2, 1, -4]: " + closestSum);
    }
}

/*
DESIGN NOTES: Three Sum and Closest Sum Pattern

Real-world Analogy:
- Finding a Trio of Balance Weights: Imagine you have a scale and three weights that must balance a target weight. You lock in the first weight (outer loop), then use two pointers to select the remaining two weights by moving inwards (heavier vs. lighter) until they balance the target weight as closely as possible.

Technical Analogy:
- Multi-Parameter Filter Matching: Booking platforms (like flight search) where the algorithm combines multiple criteria (price, flight duration, and layover time) to find a combination that matches a budget target or finds the closest match to a specific target budget.

Limitations & Tradeoffs:
- Sorted Input Dependency: The two-pointer traversal relies on a sorted array. If the array is unsorted, we must sort it first. The manual sorting step adds O(N log N) or O(N^2) time complexity.
- In-place Modification vs. Space: Sorting the array in-place modifies the original input. To preserve the original array, we would have to duplicate it, requiring O(N) extra space.
*/
