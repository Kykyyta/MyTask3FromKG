package math.view;

import math.controller.MathController;
import math.model.*;

import java.util.Scanner;

public class MathInteractiveView {

    private final MathController controller;
    private final Scanner scanner;

    public MathInteractiveView(MathController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== MATH LINEAR ALGEBRA LIBRARY ===");
        showMainMenu();
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Vector Operations");
            System.out.println("2. Matrix Operations");
            System.out.println("3. Linear Algebra");
            System.out.println("4. Error Handling Demonstration"); // НОВЫЙ ПУНКТ!
            System.out.println("5. Run All Tests");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> showVectorMenu();
                case 2 -> showMatrixMenu();
                case 3 -> showLinearAlgebraMenu();
                case 4 -> demonstrateErrorHandling(); // НОВЫЙ ВЫЗОВ!
                case 5 -> runTests();
                case 6 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void showVectorMenu() {
        while (true) {
            System.out.println("\n=== VECTOR OPERATIONS ===");
            System.out.println("1. 2D Vector Operations");
            System.out.println("2. 3D Vector Operations");
            System.out.println("3. 4D Vector Operations");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> showVector2dMenu();
                case 2 -> showVector3dMenu();
                case 3 -> showVector4dMenu();
                case 4 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void showVector2dMenu() {
        while (true) {
            System.out.println("\n=== 2D VECTOR OPERATIONS ===");
            System.out.println("1. Add Vectors");
            System.out.println("2. Subtract Vectors");
            System.out.println("3. Dot Product");
            System.out.println("4. Multiply by Scalar");
            System.out.println("5. Divide by Scalar");
            System.out.println("6. Length");
            System.out.println("7. Normalize");
            System.out.println("8. Distance between vectors");
            System.out.println("9. Back to Vector Menu");
            System.out.print("Choose operation: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> performVector2dAddition();
                case 2 -> performVector2dSubtraction();
                case 3 -> performVector2dDotProduct();
                case 4 -> performVector2dScalarMultiplication();
                case 5 -> performVector2dScalarDivision();
                case 6 -> performVector2dLength();
                case 7 -> performVector2dNormalization();
                case 8 -> performVector2dDistance();
                case 9 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void performVector2dAddition() {
        System.out.println("=== VECTOR ADDITION ===");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        Vector2f result = controller.addVectors(v1, v2);
        System.out.println("Result: " + v1 + " + " + v2 + " = " + result);
    }

    private void performVector2dSubtraction() {
        System.out.println("=== VECTOR SUBTRACTION ===");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        Vector2f result = controller.subtractVectors(v1, v2);
        System.out.println("Result: " + v1 + " - " + v2 + " = " + result);
    }

    private void performVector2dDotProduct() {
        System.out.println("=== DOT PRODUCT ===");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        float result = controller.dotProduct(v1, v2);
        System.out.println("Result: " + v1 + " · " + v2 + " = " + result);
    }

    private void performVector2dScalarMultiplication() {
        System.out.println("=== SCALAR MULTIPLICATION ===");
        Vector2f v = readVector2f("Enter vector");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        Vector2f result = controller.multiplyVector(v, scalar);
        System.out.println("Result: " + v + " * " + scalar + " = " + result);
    }

    private void performVector2dScalarDivision() {
        System.out.println("=== SCALAR DIVISION ===");
        Vector2f v = readVector2f("Enter vector");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        try {
            Vector2f result = controller.divideVector(v, scalar);
            System.out.println("Result: " + v + " / " + scalar + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performVector2dLength() {
        System.out.println("=== VECTOR LENGTH ===");
        Vector2f v = readVector2f("Enter vector");

        float length = controller.vectorLength(v);
        System.out.println("Length of " + v + " = " + length);
    }

    private void performVector2dNormalization() {
        System.out.println("=== VECTOR NORMALIZATION ===");
        Vector2f v = readVector2f("Enter vector");

        try {
            Vector2f normalized = controller.normalizeVector(v);
            System.out.println("Normalized " + v + " = " + normalized);
            System.out.println("Length of normalized vector: " + controller.vectorLength(normalized));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performVector2dDistance() {
        System.out.println("=== DISTANCE BETWEEN VECTORS ===");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        float distance = controller.distance(v1, v2);
        System.out.println("Distance between " + v1 + " and " + v2 + " = " + distance);
    }

    private void showVector3dMenu() {
        while (true) {
            System.out.println("\n=== 3D VECTOR OPERATIONS ===");
            System.out.println("1. Add Vectors");
            System.out.println("2. Subtract Vectors");
            System.out.println("3. Dot Product");
            System.out.println("4. Cross Product");
            System.out.println("5. Multiply by Scalar");
            System.out.println("6. Divide by Scalar");
            System.out.println("7. Length");
            System.out.println("8. Normalize");
            System.out.println("9. Distance between vectors");
            System.out.println("10. Back to Vector Menu");
            System.out.print("Choose operation: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> performVector3dAddition();
                case 2 -> performVector3dSubtraction();
                case 3 -> performVector3dDotProduct();
                case 4 -> performVector3dCrossProduct();
                case 5 -> performVector3dScalarMultiplication();
                case 6 -> performVector3dScalarDivision();
                case 7 -> performVector3dLength();
                case 8 -> performVector3dNormalization();
                case 9 -> performVector3dDistance();
                case 10 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void performVector3dAddition() {
        System.out.println("=== VECTOR ADDITION ===");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        Vector3f result = controller.addVectors(v1, v2);
        System.out.println("Result: " + v1 + " + " + v2 + " = " + result);
    }

    private void performVector3dSubtraction() {
        System.out.println("=== VECTOR SUBTRACTION ===");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        Vector3f result = controller.subtractVectors(v1, v2);
        System.out.println("Result: " + v1 + " - " + v2 + " = " + result);
    }

    private void performVector3dDotProduct() {
        System.out.println("=== DOT PRODUCT ===");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        float result = controller.dotProduct(v1, v2);
        System.out.println("Result: " + v1 + " · " + v2 + " = " + result);
    }

    private void performVector3dCrossProduct() {
        System.out.println("=== CROSS PRODUCT ===");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        Vector3f result = controller.crossProduct(v1, v2);
        System.out.println("Result: " + v1 + " × " + v2 + " = " + result);
    }

    private void performVector3dScalarMultiplication() {
        System.out.println("=== SCALAR MULTIPLICATION ===");
        Vector3f v = readVector3f("Enter vector");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        Vector3f result = controller.multiplyVector(v, scalar);
        System.out.println("Result: " + v + " * " + scalar + " = " + result);
    }

    private void performVector3dScalarDivision() {
        System.out.println("=== SCALAR DIVISION ===");
        Vector3f v = readVector3f("Enter vector");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        try {
            Vector3f result = controller.divideVector(v, scalar);
            System.out.println("Result: " + v + " / " + scalar + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performVector3dLength() {
        System.out.println("=== VECTOR LENGTH ===");
        Vector3f v = readVector3f("Enter vector");

        float length = controller.vectorLength(v);
        System.out.println("Length of " + v + " = " + length);
    }

    private void performVector3dNormalization() {
        System.out.println("=== VECTOR NORMALIZATION ===");
        Vector3f v = readVector3f("Enter vector");

        try {
            Vector3f normalized = controller.normalizeVector(v);
            System.out.println("Normalized " + v + " = " + normalized);
            System.out.println("Length of normalized vector: " + controller.vectorLength(normalized));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performVector3dDistance() {
        System.out.println("=== DISTANCE BETWEEN VECTORS ===");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        float distance = controller.distance(v1, v2);
        System.out.println("Distance between " + v1 + " and " + v2 + " = " + distance);
    }

    private void showVector4dMenu() {
        while (true) {
            System.out.println("\n=== 4D VECTOR OPERATIONS ===");
            System.out.println("1. Add Vectors");
            System.out.println("2. Subtract Vectors");
            System.out.println("3. Dot Product");
            System.out.println("4. Multiply by Scalar");
            System.out.println("5. Divide by Scalar");
            System.out.println("6. Length");
            System.out.println("7. Normalize");
            System.out.println("8. Convert to/from 3D");
            System.out.println("9. Back to Vector Menu");
            System.out.print("Choose operation: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> performVector4dAddition();
                case 2 -> performVector4dSubtraction();
                case 3 -> performVector4dDotProduct();
                case 4 -> performVector4dScalarMultiplication();
                case 5 -> performVector4dScalarDivision();
                case 6 -> performVector4dLength();
                case 7 -> performVector4dNormalization();
                case 8 -> performVectorConversion();
                case 9 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void performVector4dAddition() {
        System.out.println("=== VECTOR ADDITION ===");
        Vector4f v1 = readVector4f("Enter first vector");
        Vector4f v2 = readVector4f("Enter second vector");

        Vector4f result = controller.addVectors(v1, v2);
        System.out.println("Result: " + v1 + " + " + v2 + " = " + result);
    }

    private void performVector4dSubtraction() {
        System.out.println("=== VECTOR SUBTRACTION ===");
        Vector4f v1 = readVector4f("Enter first vector");
        Vector4f v2 = readVector4f("Enter second vector");

        Vector4f result = controller.subtractVectors(v1, v2);
        System.out.println("Result: " + v1 + " - " + v2 + " = " + result);
    }

    private void performVector4dDotProduct() {
        System.out.println("=== DOT PRODUCT ===");
        Vector4f v1 = readVector4f("Enter first vector");
        Vector4f v2 = readVector4f("Enter second vector");

        float result = controller.dotProduct(v1, v2);
        System.out.println("Result: " + v1 + " · " + v2 + " = " + result);
    }

    private void performVector4dScalarMultiplication() {
        System.out.println("=== SCALAR MULTIPLICATION ===");
        Vector4f v = readVector4f("Enter vector");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        Vector4f result = controller.multiplyVector(v, scalar);
        System.out.println("Result: " + v + " * " + scalar + " = " + result);
    }

    private void performVector4dScalarDivision() {
        System.out.println("=== SCALAR DIVISION ===");
        Vector4f v = readVector4f("Enter vector");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        try {
            Vector4f result = controller.divideVector(v, scalar);
            System.out.println("Result: " + v + " / " + scalar + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performVector4dLength() {
        System.out.println("=== VECTOR LENGTH ===");
        Vector4f v = readVector4f("Enter vector");

        float length = controller.vectorLength(v);
        System.out.println("Length of " + v + " = " + length);
    }

    private void performVector4dNormalization() {
        System.out.println("=== VECTOR NORMALIZATION ===");
        Vector4f v = readVector4f("Enter vector");

        try {
            Vector4f normalized = controller.normalizeVector(v);
            System.out.println("Normalized " + v + " = " + normalized);
            System.out.println("Length of normalized vector: " + controller.vectorLength(normalized));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performVectorConversion() {
        System.out.println("=== VECTOR CONVERSION ===");
        System.out.println("1. 3D to 4D");
        System.out.println("2. 4D to 3D");
        System.out.print("Choose conversion: ");

        int choice = readInt();

        if (choice == 1) {
            Vector3f v3 = readVector3f("Enter 3D vector");
            Vector4f v4 = controller.vector3fTo4f(v3);
            System.out.println("Converted to 4D: " + v4);
        } else if (choice == 2) {
            Vector4f v4 = readVector4f("Enter 4D vector");
            try {
                Vector3f v3 = controller.vector4fTo3f(v4);
                System.out.println("Converted to 3D: " + v3);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private void showMatrixMenu() {
        while (true) {
            System.out.println("\n=== MATRIX OPERATIONS ===");
            System.out.println("1. 3x3 Matrix Operations");
            System.out.println("2. 4x4 Matrix Operations");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> showMatrix3x3Menu();
                case 2 -> showMatrix4x4Menu();
                case 3 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void showMatrix3x3Menu() {
        while (true) {
            System.out.println("\n=== 3x3 MATRIX OPERATIONS ===");
            System.out.println("1. Add Matrices");
            System.out.println("2. Subtract Matrices");
            System.out.println("3. Multiply Matrices");
            System.out.println("4. Multiply by Scalar");
            System.out.println("5. Transpose");
            System.out.println("6. Determinant");
            System.out.println("7. Inverse");
            System.out.println("8. Multiply by Vector");
            System.out.println("9. Back to Matrix Menu");
            System.out.print("Choose operation: ");

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
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void performMatrix3x3Addition() {
        System.out.println("=== MATRIX ADDITION ===");
        Matrix3f m1 = readMatrix3f("Enter first matrix");
        Matrix3f m2 = readMatrix3f("Enter second matrix");

        Matrix3f result = controller.addMatrices(m1, m2);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix3x3Subtraction() {
        System.out.println("=== MATRIX SUBTRACTION ===");
        Matrix3f m1 = readMatrix3f("Enter first matrix");
        Matrix3f m2 = readMatrix3f("Enter second matrix");

        Matrix3f result = controller.subtractMatrices(m1, m2);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix3x3Multiplication() {
        System.out.println("=== MATRIX MULTIPLICATION ===");
        Matrix3f m1 = readMatrix3f("Enter first matrix");
        Matrix3f m2 = readMatrix3f("Enter second matrix");

        Matrix3f result = controller.multiplyMatrices(m1, m2);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix3x3ScalarMultiplication() {
        System.out.println("=== MATRIX SCALAR MULTIPLICATION ===");
        Matrix3f m = readMatrix3f("Enter matrix");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        Matrix3f result = controller.multiplyMatrix(m, scalar);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix3x3Transpose() {
        System.out.println("=== MATRIX TRANSPOSE ===");
        Matrix3f m = readMatrix3f("Enter matrix");

        Matrix3f result = controller.transposeMatrix(m);
        System.out.println("Transposed matrix:");
        System.out.println(result);
    }

    private void performMatrix3x3Determinant() {
        System.out.println("=== MATRIX DETERMINANT ===");
        Matrix3f m = readMatrix3f("Enter matrix");

        float determinant = controller.matrixDeterminant(m);
        System.out.println("Determinant = " + determinant);
    }

    private void performMatrix3x3Inverse() {
        System.out.println("=== MATRIX INVERSE ===");
        Matrix3f m = readMatrix3f("Enter matrix");

        try {
            Matrix3f inverse = controller.inverseMatrix(m);
            System.out.println("Inverse matrix:");
            System.out.println(inverse);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performMatrix3x3VectorMultiplication() {
        System.out.println("=== MATRIX-VECTOR MULTIPLICATION ===");
        Matrix3f m = readMatrix3f("Enter matrix");
        Vector3f v = readVector3f("Enter vector");

        Vector3f result = controller.multiplyMatrixVector(m, v);
        System.out.println("Result: " + result);
    }

    private void showMatrix4x4Menu() {
        while (true) {
            System.out.println("\n=== 4x4 MATRIX OPERATIONS ===");
            System.out.println("1. Add Matrices");
            System.out.println("2. Subtract Matrices");
            System.out.println("3. Multiply Matrices");
            System.out.println("4. Multiply by Scalar");
            System.out.println("5. Transpose");
            System.out.println("6. Determinant");
            System.out.println("7. Inverse");
            System.out.println("8. Multiply by Vector");
            System.out.println("9. Back to Matrix Menu");
            System.out.print("Choose operation: ");

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
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void performMatrix4x4Addition() {
        System.out.println("=== MATRIX ADDITION ===");
        Matrix4f m1 = readMatrix4f("Enter first matrix");
        Matrix4f m2 = readMatrix4f("Enter second matrix");

        Matrix4f result = controller.addMatrices(m1, m2);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix4x4Subtraction() {
        System.out.println("=== MATRIX SUBTRACTION ===");
        Matrix4f m1 = readMatrix4f("Enter first matrix");
        Matrix4f m2 = readMatrix4f("Enter second matrix");

        Matrix4f result = controller.subtractMatrices(m1, m2);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix4x4Multiplication() {
        System.out.println("=== MATRIX MULTIPLICATION ===");
        Matrix4f m1 = readMatrix4f("Enter first matrix");
        Matrix4f m2 = readMatrix4f("Enter second matrix");

        Matrix4f result = controller.multiplyMatrices(m1, m2);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix4x4ScalarMultiplication() {
        System.out.println("=== MATRIX SCALAR MULTIPLICATION ===");
        Matrix4f m = readMatrix4f("Enter matrix");
        System.out.print("Enter scalar: ");
        float scalar = readFloat();

        Matrix4f result = controller.multiplyMatrix(m, scalar);
        System.out.println("Result:");
        System.out.println(result);
    }

    private void performMatrix4x4Transpose() {
        System.out.println("=== MATRIX TRANSPOSE ===");
        Matrix4f m = readMatrix4f("Enter matrix");

        Matrix4f result = controller.transposeMatrix(m);
        System.out.println("Transposed matrix:");
        System.out.println(result);
    }

    private void performMatrix4x4Determinant() {
        System.out.println("=== MATRIX DETERMINANT ===");
        Matrix4f m = readMatrix4f("Enter matrix");

        float determinant = controller.matrixDeterminant(m);
        System.out.println("Determinant = " + determinant);
    }

    private void performMatrix4x4Inverse() {
        System.out.println("=== MATRIX INVERSE ===");
        Matrix4f m = readMatrix4f("Enter matrix");

        try {
            Matrix4f inverse = controller.inverseMatrix(m);
            System.out.println("Inverse matrix:");
            System.out.println(inverse);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performMatrix4x4VectorMultiplication() {
        System.out.println("=== MATRIX-VECTOR MULTIPLICATION ===");
        Matrix4f m = readMatrix4f("Enter matrix");
        Vector4f v = readVector4f("Enter vector");

        Vector4f result = controller.multiplyMatrixVector(m, v);
        System.out.println("Result: " + result);
    }

    private void showLinearAlgebraMenu() {
        while (true) {
            System.out.println("\n=== LINEAR ALGEBRA ===");
            System.out.println("1. Solve Linear System (3x3)");
            System.out.println("2. Solve Linear System (4x4)");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> solveLinearSystem3x3();
                case 2 -> solveLinearSystem4x4();
                case 3 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void solveLinearSystem3x3() {
        System.out.println("=== SOLVE 3x3 LINEAR SYSTEM ===");
        Matrix3f A = readMatrix3f("Enter coefficient matrix A");
        Vector3f b = readVector3f("Enter right-hand side vector b");

        try {
            Vector3f x = controller.solveLinearSystem(A, b);
            System.out.println("Solution x = " + x);

            // Проверка
            Vector3f Ax = controller.multiplyMatrixVector(A, x);
            System.out.println("Verification A*x = " + Ax);
            System.out.println("Solution is correct: " + Ax.equals(b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void solveLinearSystem4x4() {
        System.out.println("=== SOLVE 4x4 LINEAR SYSTEM ===");
        Matrix4f A = readMatrix4f("Enter coefficient matrix A");
        Vector4f b = readVector4f("Enter right-hand side vector b");

        try {
            Vector4f x = controller.solveLinearSystem(A, b);
            System.out.println("Solution x = " + x);

            // Проверка
            Vector4f Ax = controller.multiplyMatrixVector(A, x);
            System.out.println("Verification A*x = " + Ax);
            System.out.println("Solution is correct: " + Ax.equals(b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void runTests() {
        System.out.println("\n=== RUNNING ALL TESTS ===");
        controller.runTests();
    }

    // Вспомогательные методы для чтения ввода
    private Vector2f readVector2f(String prompt) {
        System.out.println(prompt + ":");
        System.out.print("Enter x: ");
        float x = readFloat();
        System.out.print("Enter y: ");
        float y = readFloat();
        return new Vector2f(x, y);
    }

    private Vector3f readVector3f(String prompt) {
        System.out.println(prompt + ":");
        System.out.print("Enter x: ");
        float x = readFloat();
        System.out.print("Enter y: ");
        float y = readFloat();
        System.out.print("Enter z: ");
        float z = readFloat();
        return new Vector3f(x, y, z);
    }

    private Vector4f readVector4f(String prompt) {
        System.out.println(prompt + ":");
        System.out.print("Enter x: ");
        float x = readFloat();
        System.out.print("Enter y: ");
        float y = readFloat();
        System.out.print("Enter z: ");
        float z = readFloat();
        System.out.print("Enter w: ");
        float w = readFloat();
        return new Vector4f(x, y, z, w);
    }

    private Matrix3f readMatrix3f(String prompt) {
        System.out.println(prompt + ":");
        float[][] data = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Enter element [%d][%d]: ", i, j);
                data[i][j] = readFloat();
            }
        }
        return new Matrix3f(data);
    }

    private Matrix4f readMatrix4f(String prompt) {
        System.out.println(prompt + ":");
        float[][] data = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("Enter element [%d][%d]: ", i, j);
                data[i][j] = readFloat();
            }
        }
        return new Matrix4f(data);
    }

    private void demonstrateErrorHandling() {

        System.out.println("\n=== ERROR HANDLING DEMONSTRATION ===");

        // 1. Деление на ноль
        System.out.println("\n1. Testing division by zero:");
        try {
            Vector2f v = new Vector2f(1, 1);
            System.out.println("Dividing vector " + v + " by zero...");
            controller.divideVector(v, 0);
        } catch (ArithmeticException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }

        // 2. Нормализация нулевого вектора
        System.out.println("\n2. Testing normalization of zero vector:");
        try {
            Vector3f zero = new Vector3f(0, 0, 0);
            System.out.println("Normalizing zero vector " + zero + "...");
            controller.normalizeVector(zero);
        } catch (ArithmeticException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }

        // 3. Инверсия вырожденной матрицы
        System.out.println("\n3. Testing inversion of singular matrix:");
        try {
            Matrix3f singular = new Matrix3f(new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            });
            System.out.println("Inverting singular matrix:");
            System.out.println(singular);
            controller.inverseMatrix(singular);
        } catch (ArithmeticException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }

        // 4. Решение несовместной системы
        System.out.println("\n4. Testing solving inconsistent system:");
        try {
            Matrix3f inconsistent = new Matrix3f(new float[][]{
                    {1, 1, 1},
                    {1, 1, 1},
                    {1, 1, 1}
            });
            Vector3f b = new Vector3f(1, 2, 3);
            System.out.println("Solving system with matrix:");
            System.out.println(inconsistent);
            System.out.println("and vector: " + b);
            controller.solveLinearSystem(inconsistent, b);
        } catch (ArithmeticException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }

        // 5. Конвертация Vector4f с w=0
        System.out.println("\n5. Testing Vector4f to Vector3f conversion with w=0:");
        try {
            Vector4f v4 = new Vector4f(1, 2, 3, 0);
            System.out.println("Converting vector " + v4 + " to Vector3f...");
            controller.vector4fTo3f(v4);
        } catch (ArithmeticException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }

        System.out.println("\n=== ALL ERROR HANDLING TESTS COMPLETED ===");
        System.out.println("All exceptions were properly caught and handled! ✓");
    }

    private int readInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // очистить некорректный ввод
            }
        }
    }

    private float readFloat() {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // очистить некорректный ввод
            }
        }
    }
}