public class RowMultiply implements Runnable {
    private int[][] result;
    private int[][] matrix1;
    private int[][] matrix2;
    private int threadNumber;

    public RowMultiply(int[][] result, int[][] matrix1, int[][] matrix2, int threadNumber) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        int row1 = matrix1.length; // Get number of rows from matrix1
        int column1 = matrix1[0].length; // Get number of columns from matrix1
        int row2 = matrix2.length; // Get number of rows from matrix2
        int column2 = matrix2[0].length; // Get number of columns from matrix2

        // Perform matrix multiplication
        for (int i = threadNumber; i < row1; i += 10) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}

// change somethings
