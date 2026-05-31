package arrays;

class Main {

    public static int[] removeDuplicatesBruteForce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int[] newArr = new int[arr.length];
        newArr[0] = arr[0];
        int x = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != newArr[x - 1]) {
                newArr[x] = arr[i];
                x++;
            }
        }

        // Time: O(N) linear time pass
        // Space: O(N) auxiliary space (allocates new temp array of size N)
        return newArr;
    }

    public static int[] removeDuplicatesInplace(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int curr = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[curr] == arr[i])
                continue;

            curr++;
            arr[curr] = arr[i];
        }

        // Time: O(N) linear scan
        // Space: O(1) auxiliary space (in-place manipulation)
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 2, 2, 3, 4, 4 };
        ArrayUtils.arrayTraversal(arr1, "Original Sorted Array 1: ");
        int[] res1 = removeDuplicatesBruteForce(arr1);
        ArrayUtils.arrayTraversal(res1, "After Brute Force: ");
        System.out.println();

        int[] arr2 = { 1, 1, 2, 2, 3, 4, 4 };
        ArrayUtils.arrayTraversal(arr2, "Original Sorted Array 2: ");
        int[] res2 = removeDuplicatesInplace(arr2);
        ArrayUtils.arrayTraversal(res2, "After In-Place: ");
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Imagine an assembly line of labeled boxes. As the boxes pass by, a worker marks down each new label they see.
 *   - Brute Force (Extra Space): The worker keeps a second row of boxes on a separate table, copying only the boxes with new labels. The second table has empty space at the end.
 *   - In-Place (Two Pointers): The worker operates directly on the main assembly line. The first pointer ("unique pointer") marks the end of the unique sorted sequence. As boxes roll past, if a box has a different label from the unique pointer's box, the worker slides it forward to sit right next to the unique pointer's box. The boxes at the end of the line remain unchanged ("dirty elements").
 * - Limitations & Tradeoffs: 
 *   - The in-place two-pointer approach is highly space-efficient (O(1) auxiliary space) and very fast (O(N) time complexity) because it modifies the array in a single traversal pass.
 *   - However, because arrays have a fixed size in Java, the in-place modification leaves trailing duplicate elements (referred to as "dirty ending elements") at the tail of the array. The caller must keep track of the unique size to avoid processing this garbage data.
 *   - The brute-force approach retains the original array untouched but incurs an O(N) memory overhead to allocate the secondary copy, and still leaves default unwritten zeros at its end if returned at full length.
 */
