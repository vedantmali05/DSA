package arrays;

class Main {

    public static void swap(int[][] matrix, int row, int col) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;

        // Time: O(1) worst-case
        // Space: O(1) auxiliary space
    }

    /**
     * Transposes a square matrix in-place.
     */
    public static void transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Invalid Matrix Input");
            return;
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] == null || matrix[row].length != matrix.length) {
                System.out.println("Invalid Matrix Input");
                return;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                swap(matrix, row, col);
            }
        }

        // Time: O(N^2) worst-case (where N is matrix.length)
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Original Matrix:");
        ArrayUtils.printMatrix(matrix);

        transpose(matrix);

        System.out.println("\nTransposed Matrix:");
        ArrayUtils.printMatrix(matrix);
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of a square dance floor where dancers are paired up symmetrically
 * across a diagonal line
 * running from the top-left to the bottom-right corner. To swap partners, each
 * dancer on one side
 * of the diagonal walks across the line and swaps places with their counterpart
 * directly opposite
 * them on the other side. Dancers standing exactly on the diagonal line remain
 * in place and just
 * spin around.
 * 
 * Technical Analogy:
 * - Image Manipulation: Performing a 90-degree rotation of a square image by
 * first transposing
 * its pixels across the main diagonal, and then reversing either the rows or
 * columns.
 * - Table Column Sorting & Rendering: Swapping the orientation of a database
 * table or pivot-grid
 * UI component where attributes and dimensions are mapped dynamically from row
 * headers to column headers.
 * 
 * Limitations & Tradeoffs:
 * - Square Matrix Requirement: In-place transposition is strictly limited to
 * square matrices (N x N).
 * For rectangular matrices (M x N), an in-place transpose is mathematically and
 * structurally
 * challenging because the memory layout size of the rows and columns must be
 * dynamically altered.
 * Therefore, rectangular transposition usually requires O(M * N) auxiliary
 * space to construct
 * a new matrix of size N x M.
 * - Mutability: This operation destructively mutates the input matrix in place.
 * If the original layout
 * must be preserved, a deep copy must be created beforehand.
 */
