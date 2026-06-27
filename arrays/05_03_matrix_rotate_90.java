package arrays;

class Main {

    /**
     * Rotates a square matrix 90 degrees clockwise using an auxiliary matrix (Pull style).
     * 
     * @param matrix the input square matrix
     * @return the rotated matrix
     */
    public static int[][] rotate90BruteForce(int[][] matrix) {
        if (!ArrayUtils.isValidSquareMatrix(matrix)) {
            return null;
        }

        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int row = 0; row < n; row++) {
            int revCol = n - 1;
            for (int col = 0; col < n; col++) {
                rotated[row][col] = matrix[revCol][row];
                revCol--;
            }
        }

        // Time: O(N^2) worst-case (where N is matrix.length)
        // Space: O(N^2) auxiliary space
        return rotated;
    }

    /**
     * Rotates a square matrix 90 degrees clockwise using an auxiliary matrix (Push style).
     * 
     * @param matrix the input square matrix
     * @return the rotated matrix
     */
    public static int[][] rotate90BruteForcePush(int[][] matrix) {
        if (!ArrayUtils.isValidSquareMatrix(matrix)) {
            return null;
        }

        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int row = 0; row < n; row++) {
            int rotatedColIdx = n - 1 - row;
            for (int col = 0; col < n; col++) {
                rotated[col][rotatedColIdx] = matrix[row][col];
            }
        }

        // Time: O(N^2) worst-case (where N is matrix.length)
        // Space: O(N^2) auxiliary space
        return rotated;
    }

    /**
     * Rotates a square matrix 90 degrees clockwise in-place.
     * 
     * @param matrix the input square matrix
     */
    public static void rotate90InPlace(int[][] matrix) {
        if (!ArrayUtils.isValidSquareMatrix(matrix)) {
            return;
        }

        transpose(matrix);
        reverseRows(matrix);

        // Time: O(N^2) worst-case (where N is matrix.length)
        // Space: O(1) auxiliary space
    }

    private static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;

        // Time: O(1) worst-case
        // Space: O(1) auxiliary space
    }

    private static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < row; col++) {
                swap(matrix, row, col, col, row);
            }
        }

        // Time: O(N^2) worst-case (where N is matrix.length)
        // Space: O(1) auxiliary space
    }

    private static void reverseRows(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            int left = 0;
            int right = matrix[row].length - 1;
            while (left < right) {
                swap(matrix, row, left, row, right);
                left++;
                right--;
            }
        }

        // Time: O(N^2) worst-case (where N is matrix.length)
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Original Matrix:");
        ArrayUtils.printMatrix(matrix1);

        System.out.println("\n--- Testing Brute-Force Rotation (Pull Style) ---");
        int[][] rotatedBrute = rotate90BruteForce(matrix1);
        System.out.println("Rotated (Pull Style):");
        ArrayUtils.printMatrix(rotatedBrute);

        System.out.println("\n--- Testing Brute-Force Rotation (Push Style) ---");
        int[][] rotatedBrutePush = rotate90BruteForcePush(matrix1);
        System.out.println("Rotated (Push Style):");
        ArrayUtils.printMatrix(rotatedBrutePush);

        // Resetting/using a fresh copy for in-place test
        int[][] matrix2 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("\n--- Testing In-Place Rotation ---");
        rotate90InPlace(matrix2);
        System.out.println("Rotated (In-Place):");
        ArrayUtils.printMatrix(matrix2);
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of a square grid of photo frames hung on a wall. To rotate the entire
 * grid 90 degrees clockwise without picking up the frames individually, you could 
 * first mirror the grid diagonally (swapping the top-right and bottom-left frames, 
 * etc.) and then reverse each row horizontally (flipping the left and right columns).
 * 
 * Technical Analogy:
 * - Image Processing & Canvas Manipulation: Rotating a user's uploaded profile picture 
 *   or canvas graphic 90 degrees clockwise in-place within a buffer before saving.
 * - Spreadsheet / UI Grid Rotation: Transposing and flipping dynamic columns/rows of 
 *   a pivot table UI widget to toggle horizontal and vertical data axes.
 * 
 * Limitations & Tradeoffs:
 * - Square Matrix Requirement: In-place rotation is strictly limited to square (N x N)
 *   matrices. For rectangular (M x N) matrices, an in-place rotation is extremely complex 
 *   because the dimensions change to N x M, which changes the layout in memory. Thus, 
 *   rectangular matrices usually require O(M * N) auxiliary space.
 * - Mutability: In-place rotation destroys the original matrix structure. If the original 
 *   layout must be preserved for other views or operations, a deep copy is necessary, 
 *   sacrificing the O(1) space optimization.
 */
