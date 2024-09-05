package easy;

// accepted: 54.86% time and 57.13% memory

public class q2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length)
            return new int[][] {};

        int[][] matrix =  new int[m][n];
        for (int i = 0; i < original.length; i++) {
            matrix[i / n][i % n] = original[i];
        }
        return matrix;
    }
}
