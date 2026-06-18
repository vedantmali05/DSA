package arrays;

class Main {

    public static void quickSort(int[] arr, int si, int ei) {
        // TODO: Implement Quick Sort using partition scheme
    }

    public static void main(String[] args) {
        int[] arr = { 24, 9, 29, 14, 19, 27 };
        ArrayUtils.arrayTraversal(arr, "Input Array: ");
        quickSort(arr, 0, arr.length - 1);
        ArrayUtils.arrayTraversal(arr, "Sorted Array: ");
    }
}
