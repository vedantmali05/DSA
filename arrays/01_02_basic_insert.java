package arrays;

class Main {

    public static int[] bruteForce(int[] arr, int newElem, int index) {
        if (arr == null || arr.length == 0) {
            System.err.println("Invalid array input");
            return arr;
        }

        int len = arr.length;

        if (index < 0 || index >= len) {
            System.err.println("Array Index Out of Bounds");
            return arr;
        }

        if (index == len - 1) {
            int[] newArr = new int[len + 1];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            newArr[newArr.length - 1] = newElem;

            // Time: O(N) | Space: O(N) (Allocates new array and copies elements manually)
            return newArr;
        }

        for (int i = len - 1; i > index; i--) {
            int prev = i - 1;
            arr[i] = arr[prev];
        }
        arr[index] = newElem;
        ArrayUtils.arrayTraversal(arr, "Brute Force Insertion: ");

        // Time: O(N) worst-case (insert at index 0 requires N - 1 shifts), O(1)
        // best-case (index == len - 1)
        // Space: O(1) auxiliary space (in-place manipulation)
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 0, 0, 0 };

        bruteForce(arr, 100, 2);
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Inserting a book onto a tightly packed shelf. To make
 * space in the middle, you must physically push all subsequent books one slot
 * to the right. If there is no space left, you either drop the last book (lossy
 * insert) or get a larger shelf (lossless dynamic reallocation).
 * - Technical Analogy: Adding an item into a list widget in a mobile app UI layout. To insert a new card at a specific index, all cards below it must be shifted down to make room and keep the order consistent.
 * - Limitations & Tradeoffs: Inserting into static arrays is computationally
 * heavy (O(N) time) due to memory shifts. If insertions are frequent, dynamic
 * chains (like Linked Lists) are superior, exchanging higher memory overhead
 * for O(1) insertions.
 */