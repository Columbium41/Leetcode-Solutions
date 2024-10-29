package medium;

public class q36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[] b;

        for (int i = 0; i < 9; i++) {
            b = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (b[Character.getNumericValue(c) - 1]) {
                        return false;
                    }

                    b[Character.getNumericValue(c) - 1] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            b = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (b[Character.getNumericValue(c) - 1]) {
                        return false;
                    }

                    b[Character.getNumericValue(c) - 1] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            b = new boolean[9];

            for (int j = 0; j < 9; j++) {
                char c = board[(i / 3) * 3 + (j / 3)][((i % 3) * 3) + (j % 3)];
                if (c != '.') {
                    if (b[Character.getNumericValue(c) - 1]) {
                        return false;
                    }

                    b[Character.getNumericValue(c) - 1] = true;
                }
            }
        }

        return true;
    }
}
