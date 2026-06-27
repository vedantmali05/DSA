package arrays;

class Main {

    /**
     * Searches for a target value in a 2D matrix where each row is sorted
     * in ascending order, and the first element of each row is greater than
     * the last element of the previous row.
     * 
     * @param matrix the input sorted M x N matrix
     * @param target the value to search for
     * @return true if the target is found, false otherwise
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (!ArrayUtils.isValidMatrix(matrix)) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = (rows * cols) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = matrix[mid / cols][mid % cols];

            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Time: O(log(R * C)) worst-case (where R is matrix.length and C is matrix[0].length)
        // Space: O(1) auxiliary space
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        System.out.println("Input Matrix:");
        ArrayUtils.printMatrix(matrix);

        int target1 = 3;
        System.out.println("\nSearching for " + target1 + ": " + searchMatrix(matrix, target1));

        int target2 = 13;
        System.out.println("Searching for " + target2 + ": " + searchMatrix(matrix, target2));

        int target3 = 60;
        System.out.println("Searching for " + target3 + ": " + searchMatrix(matrix, target3));

        int target4 = 0;
        System.out.println("Searching for " + target4 + ": " + searchMatrix(matrix, target4));
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of a multi-volume encyclopedia set stored across multiple shelves, where each 
 * shelf is filled from left to right, and the next shelf continues with higher alphabetical 
 * entries. To search for a word, instead of searching page-by-page, you calculate a midpoint 
 * volume and shelf, locate it, and decide whether to narrow your search to the shelves before 
 * or after it.
 * 
 * Technical Analogy:
 * - Memory Virtualization: Mapping a contiguous virtual memory space (1D index address) to physical 
 *   disk sectors or page indices in a grid (2D memory structure).
 * - Database Indexing: Searching in segmented B-tree indices where elements are partitioned across 
 *   fixed-size blocks.
 * 
 * Limitations & Tradeoffs:
 * - Continuity Requirement: This O(log(R * C)) method strictly requires the matrix to be fully sorted 
 *   across all rows sequentially (i.e., matrix[i][C-1] < matrix[i+1][0]). If rows and columns are only 
 *   individually sorted (e.g., Young Tableau), this 1D mapping breaks, and we must use O(R + C) search space 
 *   reduction instead.
 * - Integer Overflow: For extremely large matrices, R * C can overflow the standard 32-bit integer range in Java. 
 *   In such cases, binary search must be performed step-by-step using row/column indices instead of a single 1D flat index.
 */
