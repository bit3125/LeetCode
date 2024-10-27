package round4.q048RotateImage;

//***REVIEW
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length != matrix.length) {
            return;
        }

        transpose(matrix);
        flip(matrix);
    }

    private void transpose(int[][] matrix) {

        int tmp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private void flip(int[][] matrix) {

        int tmp, k;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                k = matrix.length - 1 - j;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
            }
        }
    }
}