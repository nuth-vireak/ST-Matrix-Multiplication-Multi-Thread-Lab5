import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix{


    // ----------------------------------------------------------------------------------
    // Fields
    //-----------------------------------------------------------------------------------

    static Scanner input = new Scanner(System.in); // Scanner object to get user input

    static int[][] result;


    // ----------------------------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------------------------

    /**
     * Method to create matrix N rows and M columns
     * @param row number of rows
     * @param column number of columns
     * @return matrix with N rows and M columns
     */
    public static int[][] createMatrix(int row, int column) {

        int[][] matrix = new int[row][column]; // Initialize matrix with row and column size from parameters

        for (int i = 0; i < row; i++) { // Loop through each row
            for (int j = 0; j < column; j++) {  // Loop through each column
                System.out.print("Enter element [" + i + "][" + j + "]: "); // Prompt user to enter element
                matrix[i][j] = input.nextInt(); // Get user input for element
            }
        }

        // Display each matrix after creation
        System.out.println("Matrix----------------------");
        MultiThread.displayEachMatrix(row, column, matrix);
        System.out.println("----------------------------");

        return matrix;
    }

    /**
     * Method to perform matrix multiplication between two matrices
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return result of matrix multiplication
     */
    // creating 10 threads and waiting for them to complete then again repeat steps.
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int row1 = matrix1.length; // Get number of rows from matrix1
        int column1 = matrix1[0].length; // Get number of columns from matrix1
        int row2 = matrix2.length; // Get number of rows from matrix2
        int column2 = matrix2[0].length; // Get number of columns from matrix2

        // Use try-catch to catch exception if matrix multiplication is not possible
        try {
            if (column1 != row2) { // If number of columns in matrix1 is not equal to number of rows in matrix2
                System.out.println();
                System.out.println("------------------------------------ERROR-------------------------------------------------------");
                throw new Exception("Invalid matrix size. Number of columns in matrix 1 must be equal to number of rows in matrix 2.");
            }
            // Catch exception if matrix multiplication is not possible
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        result = new int[row1][column2]; // Initialize result matrix with row1 and column2 size

        // Create 10 threads
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new RowMultiply(result, matrix1, matrix2, i)));
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Method to generate random matrix N rows and M columns
     * @param n number of rows
     * @param m number of columns
     * @return matrix with N rows and M columns
     */
    public static int[][] autoGenerateMatrix(int n, int m) {

        int[][] matrix = new int[n][m]; // Initialize matrix with row and column size from parameters

        for (int i = 0; i < n; i++) { // Loop through each row
            for (int j = 0; j < m; j++) { // Loop through each column
                matrix[i][j] = (int) (Math.random() * 2); // Generate random number between 0 and 1
            }
        }

        return matrix;
    }
} // End of Matrix class