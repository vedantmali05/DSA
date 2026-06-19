package arrays;

class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, high, i);
        // Time: O(N) worst-case, average-case, and best-case
        // Space: O(1) auxiliary space
        return i;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        int pivotIdx = partition(arr, 0, arr.length - 1);
        ArrayUtils.arrayTraversal(arr, "Partitioned Array: ");
        System.out.println("Pivot index: " + pivotIdx);
    }
}

/*
 * DESIGN NOTES:
 * - Real-world Analogy: Organizing a line of students by height. You pick the last student in line (the pivot). You walk down the line from left to right, comparing each student to the pivot. If a student is shorter, you swap them to the front section of the line. At the end, you place the pivot student right after the last shorter student.
 * - Technical Analogy: Filtering a stream of data packages. As packages stream in, you want to push all packages with a priority lower than a threshold (the pivot) to the beginning of the buffer. You keep a pointer marking the end of the low-priority zone and advance it every time you swap a qualifying package in.
 * - Limitations & Tradeoffs:
 *   - Stable: No. Swapping elements across the array can change the relative order of duplicate elements.
 *   - In-place: Yes, it requires only O(1) auxiliary space as it swaps elements directly within the array.
 *   - Tradeoff: Lomuto is simpler to implement and understand than Hoare's scheme. However, it performs more swaps (specifically, when elements are already sorted or when there are duplicates, it can do redundant swaps) and is less efficient than Hoare's scheme in practice. It also degrades to O(N^2) behavior on already sorted arrays or arrays with all equal elements if used in Quick Sort without randomization.
 */