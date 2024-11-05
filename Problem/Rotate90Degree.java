package Problem;

public class Rotate90Degree {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Original Matrix::");
        printMatrix(mat);
        rotate(mat);
        System.out.println("90 degree Rotate Matrix:");
        printMatrix(mat);
        

    }

    static void rotate(int mat[][]) {
        // 1. Transpose
        // 2. Reverse each row

        transpose(mat);
        for (int row = 0; row < mat.length; row++) {
            reverseRow(mat, row);
        }
    }

    private static void reverseRow(int[][] mat, int row) {
        int i = 0;
        int j = mat[row].length - 1;
        while (i < j) {
            int val = mat[row][i];
            mat[row][i] = mat[row][j];
            mat[row][j] = val;
            i++;
            j--;
        }
    }

    private static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat[0].length; j++) {
                // swap
                int val = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = val;
            }
        }
    }

    static void printMatrix(int[][] mat) {
        // print the matrix
        for (int[] nums : mat) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
