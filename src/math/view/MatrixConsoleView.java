package math.view;

import math.controller.MathController;
import math.model.*;
import java.util.Scanner;

public class MatrixConsoleView extends BaseConsoleView {

    public MatrixConsoleView(MathController controller, Scanner scanner) {
        super(controller, scanner);
    }

    public void showMatrixMenu() {
        while (true) {
            showSectionHeader("MATRIX OPERATIONS");
            showMessage("1. 3x3 Matrix Operations");
            showMessage("2. 4x4 Matrix Operations");
            showMessage("3. Back to Main Menu");
            showMessage("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> showMatrix3x3Menu();
                case 2 -> showMatrix4x4Menu();
                case 3 -> { return; }
                default -> showError("Invalid option!");
            }
        }
    }

    private void showMatrix3x3Menu() {
        while (true) {
            showSectionHeader("3x3 MATRIX OPERATIONS");
            showMessage("1. Add Matrices");
            showMessage("2. Subtract Matrices");
            showMessage("3. Multiply Matrices");
            showMessage("4. Multiply by Scalar");
            showMessage("5. Transpose");
            showMessage("6. Determinant");
            showMessage("7. Inverse");
            showMessage("8. Multiply by Vector");
            showMessage("9. Back to Matrix Menu");
            showMessage("Choose operation: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> performMatrix3x3Addition();
                case 2 -> performMatrix3x3Subtraction();
                case 3 -> performMatrix3x3Multiplication();
                case 4 -> performMatrix3x3ScalarMultiplication();
                case 5 -> performMatrix3x3Transpose();
                case 6 -> performMatrix3x3Determinant();
                case 7 -> performMatrix3x3Inverse();
                case 8 -> performMatrix3x3VectorMultiplication();
                case 9 -> { return; }
                default -> showError("Invalid option!");
            }
        }
    }

    private void performMatrix3x3Addition() {
        showSectionHeader("MATRIX ADDITION");
        Matrix3f m1 = readMatrix3f("Enter first matrix");
        Matrix3f m2 = readMatrix3f("Enter second matrix");

        Matrix3f result = controller.addMatrices(m1, m2);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix3x3Subtraction() {
        showSectionHeader("MATRIX SUBTRACTION");
        Matrix3f m1 = readMatrix3f("Enter first matrix");
        Matrix3f m2 = readMatrix3f("Enter second matrix");

        Matrix3f result = controller.subtractMatrices(m1, m2);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix3x3Multiplication() {
        showSectionHeader("MATRIX MULTIPLICATION");
        Matrix3f m1 = readMatrix3f("Enter first matrix");
        Matrix3f m2 = readMatrix3f("Enter second matrix");

        Matrix3f result = controller.multiplyMatrices(m1, m2);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix3x3ScalarMultiplication() {
        showSectionHeader("MATRIX SCALAR MULTIPLICATION");
        Matrix3f m = readMatrix3f("Enter matrix");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        Matrix3f result = controller.multiplyMatrix(m, scalar);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix3x3Transpose() {
        showSectionHeader("MATRIX TRANSPOSE");
        Matrix3f m = readMatrix3f("Enter matrix");

        Matrix3f result = controller.transposeMatrix(m);
        showMessage("Transposed matrix:");
        showMessage(result.toString());
    }

    private void performMatrix3x3Determinant() {
        showSectionHeader("MATRIX DETERMINANT");
        Matrix3f m = readMatrix3f("Enter matrix");

        float determinant = controller.matrixDeterminant(m);
        showMessage("Determinant = " + determinant);
    }

    private void performMatrix3x3Inverse() {
        showSectionHeader("MATRIX INVERSE");
        Matrix3f m = readMatrix3f("Enter matrix");

        try {
            Matrix3f inverse = controller.inverseMatrix(m);
            showMessage("Inverse matrix:");
            showMessage(inverse.toString());
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performMatrix3x3VectorMultiplication() {
        showSectionHeader("MATRIX-VECTOR MULTIPLICATION");
        Matrix3f m = readMatrix3f("Enter matrix");
        Vector3f v = readVector3f("Enter vector");

        Vector3f result = controller.multiplyMatrixVector(m, v);
        showMessage("Result: " + result);
    }

    private void showMatrix4x4Menu() {
        while (true) {
            showSectionHeader("4x4 MATRIX OPERATIONS");
            showMessage("1. Add Matrices");
            showMessage("2. Subtract Matrices");
            showMessage("3. Multiply Matrices");
            showMessage("4. Multiply by Scalar");
            showMessage("5. Transpose");
            showMessage("6. Determinant");
            showMessage("7. Inverse");
            showMessage("8. Multiply by Vector");
            showMessage("9. Back to Matrix Menu");
            showMessage("Choose operation: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> performMatrix4x4Addition();
                case 2 -> performMatrix4x4Subtraction();
                case 3 -> performMatrix4x4Multiplication();
                case 4 -> performMatrix4x4ScalarMultiplication();
                case 5 -> performMatrix4x4Transpose();
                case 6 -> performMatrix4x4Determinant();
                case 7 -> performMatrix4x4Inverse();
                case 8 -> performMatrix4x4VectorMultiplication();
                case 9 -> { return; }
                default -> showError("Invalid option!");
            }
        }
    }

    private void performMatrix4x4Addition() {
        showSectionHeader("MATRIX ADDITION");
        Matrix4f m1 = readMatrix4f("Enter first matrix");
        Matrix4f m2 = readMatrix4f("Enter second matrix");

        Matrix4f result = controller.addMatrices(m1, m2);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix4x4Subtraction() {
        showSectionHeader("MATRIX SUBTRACTION");
        Matrix4f m1 = readMatrix4f("Enter first matrix");
        Matrix4f m2 = readMatrix4f("Enter second matrix");

        Matrix4f result = controller.subtractMatrices(m1, m2);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix4x4Multiplication() {
        showSectionHeader("MATRIX MULTIPLICATION");
        Matrix4f m1 = readMatrix4f("Enter first matrix");
        Matrix4f m2 = readMatrix4f("Enter second matrix");

        Matrix4f result = controller.multiplyMatrices(m1, m2);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix4x4ScalarMultiplication() {
        showSectionHeader("MATRIX SCALAR MULTIPLICATION");
        Matrix4f m = readMatrix4f("Enter matrix");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        Matrix4f result = controller.multiplyMatrix(m, scalar);
        showMessage("Result:");
        showMessage(result.toString());
    }

    private void performMatrix4x4Transpose() {
        showSectionHeader("MATRIX TRANSPOSE");
        Matrix4f m = readMatrix4f("Enter matrix");

        Matrix4f result = controller.transposeMatrix(m);
        showMessage("Transposed matrix:");
        showMessage(result.toString());
    }

    private void performMatrix4x4Determinant() {
        showSectionHeader("MATRIX DETERMINANT");
        Matrix4f m = readMatrix4f("Enter matrix");

        float determinant = controller.matrixDeterminant(m);
        showMessage("Determinant = " + determinant);
    }

    private void performMatrix4x4Inverse() {
        showSectionHeader("MATRIX INVERSE");
        Matrix4f m = readMatrix4f("Enter matrix");

        try {
            Matrix4f inverse = controller.inverseMatrix(m);
            showMessage("Inverse matrix:");
            showMessage(inverse.toString());
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performMatrix4x4VectorMultiplication() {
        showSectionHeader("MATRIX-VECTOR MULTIPLICATION");
        Matrix4f m = readMatrix4f("Enter matrix");
        Vector4f v = readVector4f("Enter vector");

        Vector4f result = controller.multiplyMatrixVector(m, v);
        showMessage("Result: " + result);
    }
}

