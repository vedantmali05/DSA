package arrays;

class Main {

    /**
     * Performs a spiral traversal of the given 2D matrix and prints the elements.
     * 
     * @param matrix the input M x N matrix
     */
    public static void printSpiral(int[][] matrix) {
        if (!ArrayUtils.isValidMatrix(matrix)) {
            return;
        }

        int currTopRow = 0;
        int currBottomRow = matrix.length - 1;
        int currLeftCol = 0;
        int currRightCol = matrix[0].length - 1;

        while (currTopRow <= currBottomRow && currLeftCol <= currRightCol) {
            for (int col = currLeftCol; col <= currRightCol; col++) {
                System.out.println(matrix[currTopRow][col] + " ");
            }
            currTopRow++;
            for (int row = currTopRow; row <= currBottomRow; row++) {
                System.out.println(matrix[row][currRightCol] + " ");
            }
            currRightCol--;
            if (currTopRow <= currBottomRow) {
                for (int col = currRightCol; col >= currLeftCol; col--) {
                    System.out.println(matrix[currBottomRow][col] + " ");
                }
                currBottomRow--;
            }
            if (currLeftCol <= currRightCol) {
                for (int row = currBottomRow; row >= currTopRow; row--) {
                    System.out.println(matrix[row][currLeftCol] + " ");
                }
                currLeftCol++;
            }
        }

        // Time: O(R * C) worst-case (where R is matrix.length and C is matrix[0].length)
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 2, 3, 4 },
                { 5, 6, 100, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        System.out.println("Original Matrix 1:");
        ArrayUtils.printMatrix(matrix1);

        System.out.println("\nSpiral Traversal 1:");
        printSpiral(matrix1);
        System.out.println();

        int[][] matrix2 = {
                { 1, 2, 3 },
        };

        System.out.println("\nOriginal Matrix 2:");
        ArrayUtils.printMatrix(matrix2);

        System.out.println("\nSpiral Traversal 2:");
        printSpiral(matrix2);
        System.out.println();
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of peeling an apple or orange in a single continuous spiral ribbon from the 
 * outside edge down to the core, or navigating a winding labyrinth that starts at the 
 * outer perimeter and spirals inwards to the center.
 * 
 * Technical Analogy:
 * - Graphic Path Tracing: Rasterization rendering techniques that fill circular or path 
 *   regions from the outside boundaries inward.
 * - Data Serialization: Flattening a 2D sensory input layout (like a camera sensor grid) 
 *   into a single 1D stream of pixel data in a clockwise order for transmission.
 * 
 * Limitations & Tradeoffs:
 * - Rectangular Grid Assumption: The boundary-shrinking approach works efficiently for 
 *   regular rectangular or square grids, but fails on highly irregular, non-rectangular, 
 *   or ragged matrices where rows have mismatched sizes or missing elements.
 * - Cache Locality: Spiral traversal alternates between row sweeps (good cache locality) 
 *   and column sweeps (poor cache locality, jumping across row references). On large datasets, 
 *   this leads to frequent cache misses compared to simple row-by-row traversal.
 */
