package arrays;

class Main {

    /**
     * Traverses the 2D matrix row by row.
     */
    public static void traverseRowByRow(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            System.out.println("Invalid Array input");
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                // We can also return directly to skip printing next, or print null
                System.out.println("null");
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Time: O(R * C) worst-case (where R is rows, C is average columns)
        // Space: O(1) auxiliary space
    }

    /**
     * Traverses the 2D matrix column by column.
     */
    public static void traverseColumnByColumn(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Invalid Array input");
            return;
        }

        int maxCols = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null && matrix[i].length > maxCols) {
                maxCols = matrix[i].length;
            }
        }

        for (int col = 0; col < maxCols; col++) {
            for (int row = 0; row <= matrix.length - 1; row++) {
                if (matrix[row] == null) {
                    System.out.print("null ");
                    continue;
                }

                if (col < matrix[row].length) {
                    System.out.print(matrix[row][col] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        // Time: O(R * C) worst-case (where R is rows, C is maxCols)
        // Space: O(1) auxiliary space
    }

    public static void main(String[] args) {
        // int[][] matrix = {
        // { 1, 2, 3 },
        // null,
        // { 4, 5 },
        // { 6, 7, 8, 9 }
        // };

        int[][] matrix = {
                { 1, 2, 3 },
                { 4 },
                { 5 }
        };

        System.out.println("Input Matrix:");
        ArrayUtils.printMatrix(matrix);

        System.out.println("\nRow-by-Row Traversal:");
        traverseRowByRow(matrix);

        System.out.println("\nColumn-by-Column Traversal:");
        traverseColumnByColumn(matrix);
    }
}

/*
 * DESIGN NOTES
 * 
 * Real-world Analogy:
 * Think of a rectangular neighborhood block layout where houses are arranged in streets (rows)
 * and avenues (columns). Walking down each street from house to house is row-by-row traversal
 * (like a mail carrier delivering mail). Visiting the first house of every street, then the second
 * house of every street, and so on, is column-by-column traversal (like garbage collection moving
 * avenue by avenue).
 * 
 * Technical Analogy:
 * - Row-by-row: Processing lines of text (word by word, line by line), or rendering items in a standard 
 *   web page layout where content flows left-to-right and wraps downward.
 * - Column-by-column: Spreadsheet calculation engines recalculating values down entire columns to 
 *   resolve formulas, or image processing filters transposing pixels/applying vertical blur kernels.
 * 
 * Limitations & Tradeoffs:
 * - CPU Cache Locality: Row-by-row traversal is significantly faster in modern architectures (like the JVM) 
 *   because multi-dimensional arrays are stored as rows in contiguous memory (row-major order). Accessing 
 *   elements sequentially in a row utilizes CPU cache prefetching. Column-by-column traversal constantly jumps 
 *   across different row references in memory, causing cache misses and significantly worse performance on large datasets.
 * - Ragged Array Complexity: If the grid has rows of varying sizes (ragged/uneven matrix), column-by-column 
 *   traversal requires pre-calculating the maximum column length and performing boundary checks on each row, 
 *   which introduces conditional overhead compared to simple row-by-row scanning.
 */
