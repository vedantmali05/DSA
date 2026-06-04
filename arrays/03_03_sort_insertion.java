package arrays;

class Main {

    public static void insertionSort(int[] arr) {
        // TODO: Implement Insertion Sort in O(N^2) time
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        insertionSort(arr);
        ArrayUtils.arrayTraversal(arr, "Sorted Array: ");
    }
}
