import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MultiThread {


    // ----------------------------------------------------------------------------------
    // Fields
    //-----------------------------------------------------------------------------------

    static Scanner input = new Scanner(System.in);

    static int row1 = 0;
    static int column1 = 0;
    static int row2 = 0;
    static int column2 = 0;
    static int[][] matrix1;
    static int[][] matrix2;
    static int[][] result;


    // ----------------------------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------------------------

    /**
     * This method is used to display the menu
     */
    public static void createMenu() {

        System.out.println();
        System.out.println("MENU------------------------");
        System.out.println("1. Create matrix");
        System.out.println("2. Auto Generate matrix");
        System.out.println("3. Multiply matrix");
        System.out.println("4. Clear matrix");
        System.out.println("5. Exit");
        System.out.println("----------------------------");
    }

    /**
     * This method is used to display each matrix
     * @param row number of rows
     * @param column number of columns
     * @param matrix matrix to be displayed
     */
    public static void displayEachMatrix(int row, int column, int[][] matrix) {

        for (int i = 0; i < row; i++) { // Loop through each row
            System.out.print("| "); // Print left border
            for (int j = 0; j < column; j++) { // Loop through each column
                System.out.print(matrix[i][j] + " "); // Print element
            }

            System.out.print("|"); // Print right border
            System.out.println(); // Print new line
        }
    }

    /**
     * This method is used to display Matrix 1 and Matrix 2
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     */
    public static void displayAllMatrix(int[][] matrix1, int[][] matrix2) {

        System.out.println();
        System.out.println("Matrix * Matrix-------------");
        displayEachMatrix(matrix1.length, matrix1[0].length, matrix1); // Display matrix1
        System.out.println("*");
        displayEachMatrix(matrix2.length, matrix2[0].length, matrix2); // Display matrix2
        System.out.println("----------------------------");
    }

    /**
     * This method is used to handle the menu selection, call the appropriate method, and display the result
     */
    public static void menuSelection() {

        while (true) { // Loop until user selects option 5 to exit

            createMenu(); // call createMenu method to display menu

            System.out.print("Enter your choice: "); // Prompt user to enter choice
            int choice = input.nextInt(); // Get user input for choice

            switch (choice) { // Switch statement to handle menu selection

                // Create matrix
                case 1 -> {

                    System.out.println();
                    System.out.println("Matrix 01-------------------");
                    System.out.print("Enter number of rows: "); // Prompt user to enter number of rows
                    row1 = input.nextInt(); // Get user input for number of rows

                    System.out.print("Enter number of columns: "); // Prompt user to enter number of columns
                    column1 = input.nextInt(); // Get user input for number of columns

                    System.out.println();

                    matrix1 = Matrix.createMatrix(row1, column1); // Call createMatrix method to create matrix1

                    System.out.println();
                    System.out.println("Matrix 02-------------------");
                    System.out.print("Enter number of rows: "); // Prompt user to enter number of rows
                    row2 = input.nextInt(); // Get user input for number of rows

                    System.out.print("Enter number of columns: "); // Prompt user to enter number of columns
                    column2 = input.nextInt(); // Get user input for number of columns

                    System.out.println();

                    matrix2 = Matrix.createMatrix(row2, column2); // Call createMatrix method to create matrix2

                    displayAllMatrix(matrix1, matrix2); // Call displayAllMatrix method to display matrix1 and matrix2
                }

                // Generate matrix
                case 2 -> {

                    System.out.println();
                    System.out.println("Matrix 01-------------------");
                    System.out.print("Enter number of rows: "); // Prompt user to enter number of rows
                    row1 = input.nextInt(); // Get user input for number of rows

                    System.out.print("Enter number of columns: "); // Prompt user to enter number of columns
                    column1 = input.nextInt(); // Get user input for number of columns

                    matrix1 = Matrix.autoGenerateMatrix(row1, column1); // Call autoGenerateMatrix method to create matrix1

                    System.out.println();
                    System.out.println("Matrix 02-------------------");
                    System.out.print("Enter number of rows: "); // Prompt user to enter number of rows
                    row2 = input.nextInt(); // Get user input for number of rows

                    System.out.print("Enter number of columns: "); // Prompt user to enter number of columns
                    column2 = input.nextInt(); // Get user input for number of columns

                    matrix2 = Matrix.autoGenerateMatrix(row2, column2); // Call autoGenerateMatrix method to create matrix2

                    displayAllMatrix(matrix1, matrix2); // Call displayAllMatrix method to display matrix1 and matrix2
                }

                // Multiply matrix
                case 3 -> {

                    // start timer
                    Date start = new Date();

                    if (matrix1 == null || matrix2 == null) { // Check if matrix1 or matrix2 is null
                        System.out.println();
                        System.out.println("Please create matrix first");

                    } else { // If matrix1 and matrix2 is not null then proceed to multiply matrix

                        result = Matrix.multiply(matrix1, matrix2); // Call multiply method to multiply matrix1 and matrix2

                        System.out.println();
                        System.out.println();
                        System.out.println("RESULT----------------------");
                        displayEachMatrix(result.length, result[0].length, result); // Call displayEachMatrix method to display result
                        System.out.println("----------------------------");
                        System.out.println();
                    }

                    Date end = new Date();

                    long timeTaken = end.getTime() - start.getTime();

                    System.out.println();
                    System.out.println("EXECUTION TIME--------------");
                    System.out.println(timeTaken + " ms");
                    System.out.printf("%02d min, %02d sec, %03d ms%n",
                            TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                            TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken)),
                            timeTaken % 1000);

                    System.out.println("----------------------------");
                }

                // Clear matrix
                case 4 -> {

                    matrix1 = null;
                    matrix2 = null;
                    result = null;

                    System.out.println();
                    System.out.println("Matrix cleared");
                }

                // Exit
                case 5 -> System.exit(0);
            }

        } // end while loop
    } // End of menuSelection()
} // End of SingleThread.java