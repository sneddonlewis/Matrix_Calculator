package io.lewiscodes.matrices;

import java.util.Scanner;

@Deprecated
public class Inputs {
    private static double[][] readMatrix(int rows, int cols, Scanner reader) {
        System.out.println("\tEnter each element of the matrix: ");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print((i + 1) + ", " + (j + 1) + " --> ");
                matrix[i][j] = reader.nextDouble();
            }
        }
        return matrix;
    }
    private static int readRows(Scanner reader) {
        System.out.print("\tEnter the number of rows in the matrix\n");
        System.out.print("--> ");
        return reader.nextInt();
    }
    private static int readColumns(Scanner reader) {
        System.out.print("\tEnter the number of columns in the matrix\n");
        System.out.print("--> ");
        return reader.nextInt();
    }
    // io.lewiscodes.matrices.Matrix io.lewiscodes.matrices.Inputs for processing calculations

    public static void multiplyMatrices(Scanner reader) {
        // io.lewiscodes.matrices.Matrix multiplication
        System.out.println("Let's start with the first matrix:");
        int fRows = Inputs.readRows(reader);
        int fCols = Inputs.readColumns(reader);
        double[][] fMatrix = Inputs.readMatrix(fRows, fCols, reader);
        System.out.println("Now for the second matrix:");
        int sRows = Inputs.readRows(reader);
        int sCols = Inputs.readColumns(reader);
        double[][] sMatrix = Inputs.readMatrix(sRows, sCols, reader);

        if (fCols != sRows) {
            // Matrices cannot be multiplied, print error
            System.out.println("\tERROR\n\tMatrices cannot be multiplied\n\tThe number of rows of a matrix must match the number of columns of another matrix in order to multiply them\n");
        } else {
            double[][] outputMatrix = Calculations.calculateMatrixMult(fRows, fCols, sCols, fMatrix, sMatrix);
            MatrixPrinter.printMatrix(outputMatrix);
        }
    }
    public static void mainTransposition(Scanner reader) {
        int rows = Inputs.readRows(reader);
        int cols = Inputs.readColumns(reader);
        double[][] matrix = Inputs.readMatrix(rows, cols, reader);
        double[][] outputMatrix = Calculations.calculateMainTransposition(matrix);
        MatrixPrinter.printMatrix(outputMatrix);
    }
    public static void sideTransposition(Scanner reader) {
        int rows = Inputs.readRows(reader);
        int cols = Inputs.readColumns(reader);
        double[][] matrix = Inputs.readMatrix(rows, cols, reader);
        double[][] outputMatrix = Calculations.calculateSideTransposition(matrix, cols, rows);
        MatrixPrinter.printMatrix(outputMatrix);
    }
    public static void verticalTransposition(Scanner reader) {
        int rows = Inputs.readRows(reader);
        int cols = Inputs.readColumns(reader);
        double[][] matrix = Inputs.readMatrix(rows, cols, reader);
        double[][] outputMatrix = Calculations.calculateVerticalTransposition(matrix, rows, cols);
        MatrixPrinter.printMatrix(outputMatrix);
    }
    public static void horizontalTransposition(Scanner reader) {
        int rows = Inputs.readRows(reader);
        int cols = Inputs.readColumns(reader);
        double[][] matrix = Inputs.readMatrix(rows, cols, reader);
        double[][] outputMatrix = Calculations.calculateHorizontalTransposition(matrix, rows, cols);
        MatrixPrinter.printMatrix(outputMatrix);
    }
    public static void determinantOfMatrix(Scanner reader) {
        int rows = Inputs.readRows(reader);
        int cols = Inputs.readColumns(reader);
        if (rows == cols) {
            double[][] matrix = Inputs.readMatrix(rows, cols, reader);
            double determinant = Calculations.calculateDeterminant(matrix);
            System.out.print("\tThe determinant is:\t");
            System.out.print(determinant + "\n");
        } else {
            System.out.println("Determinant can only be calculated on a square io.lewiscodes.matrices.Matrix");
        }

    }
    public static void inverseOfMatrix(Scanner reader) {
        int rows = Inputs.readRows(reader);
        int cols = Inputs.readColumns(reader);
        double[][] matrix = Inputs.readMatrix(rows, cols, reader);
        double determinant = Calculations.calculateDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("Inverse of the given matrix can't be found as it's determinant is 0!");
        } else {
            double[][] cofactorMatrix = Calculations.findCofactors(matrix);
            double[][] transposedCofactorMatrix = Calculations.calculateMainTransposition(cofactorMatrix);
            double[][] inverseMatrix = Calculations.calculateScalarMult(transposedCofactorMatrix, 1 / determinant);
            MatrixPrinter.printMatrix(inverseMatrix);
        }
    }
}
