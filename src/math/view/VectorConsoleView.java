package math.view;

import math.controller.MathController;
import math.model.*;
import java.util.Scanner;

public class VectorConsoleView extends BaseConsoleView {

    public VectorConsoleView(MathController controller, Scanner scanner) {
        super(controller, scanner);
    }

    public void showVectorMenu() {
        while (true) {
            showSectionHeader("VECTOR OPERATIONS");
            showMessage("1. 2D Vector Operations");
            showMessage("2. 3D Vector Operations");
            showMessage("3. 4D Vector Operations");
            showMessage("4. Back to Main Menu");
            showMessage("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> showVector2dMenu();
                case 2 -> showVector3dMenu();
                case 3 -> showVector4dMenu();
                case 4 -> { return; }
                default -> showError("Invalid option!");
            }
        }
    }

    private void showVector2dMenu() {
        while (true) {
            showSectionHeader("2D VECTOR OPERATIONS");
            showMessage("1. Add Vectors");
            showMessage("2. Subtract Vectors");
            showMessage("3. Dot Product");
            showMessage("4. Multiply by Scalar");
            showMessage("5. Divide by Scalar");
            showMessage("6. Length");
            showMessage("7. Normalize");
            showMessage("8. Distance between vectors");
            showMessage("9. Back to Vector Menu");
            showMessage("Choose operation: ");

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
                default -> showError("Invalid option!");
            }
        }
    }

    private void performVector2dAddition() {
        showSectionHeader("VECTOR ADDITION");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        Vector2f result = controller.addVectors(v1, v2);
        showMessage("Result: " + v1 + " + " + v2 + " = " + result);
    }

    private void performVector2dSubtraction() {
        showSectionHeader("VECTOR SUBTRACTION");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        Vector2f result = controller.subtractVectors(v1, v2);
        showMessage("Result: " + v1 + " - " + v2 + " = " + result);
    }

    private void performVector2dDotProduct() {
        showSectionHeader("DOT PRODUCT");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        float result = controller.dotProduct(v1, v2);
        showMessage("Result: " + v1 + " · " + v2 + " = " + result);
    }

    private void performVector2dScalarMultiplication() {
        showSectionHeader("SCALAR MULTIPLICATION");
        Vector2f v = readVector2f("Enter vector");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        Vector2f result = controller.multiplyVector(v, scalar);
        showMessage("Result: " + v + " * " + scalar + " = " + result);
    }

    private void performVector2dScalarDivision() {
        showSectionHeader("SCALAR DIVISION");
        Vector2f v = readVector2f("Enter vector");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        try {
            Vector2f result = controller.divideVector(v, scalar);
            showMessage("Result: " + v + " / " + scalar + " = " + result);
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performVector2dLength() {
        showSectionHeader("VECTOR LENGTH");
        Vector2f v = readVector2f("Enter vector");

        float length = controller.vectorLength(v);
        showMessage("Length of " + v + " = " + length);
    }

    private void performVector2dNormalization() {
        showSectionHeader("VECTOR NORMALIZATION");
        Vector2f v = readVector2f("Enter vector");

        try {
            Vector2f normalized = controller.normalizeVector(v);
            showMessage("Normalized " + v + " = " + normalized);
            showMessage("Length of normalized vector: " + controller.vectorLength(normalized));
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performVector2dDistance() {
        showSectionHeader("DISTANCE BETWEEN VECTORS");
        Vector2f v1 = readVector2f("Enter first vector");
        Vector2f v2 = readVector2f("Enter second vector");

        float distance = controller.distance(v1, v2);
        showMessage("Distance between " + v1 + " and " + v2 + " = " + distance);
    }

    private void showVector3dMenu() {
        while (true) {
            showSectionHeader("3D VECTOR OPERATIONS");
            showMessage("1. Add Vectors");
            showMessage("2. Subtract Vectors");
            showMessage("3. Dot Product");
            showMessage("4. Cross Product");
            showMessage("5. Multiply by Scalar");
            showMessage("6. Divide by Scalar");
            showMessage("7. Length");
            showMessage("8. Normalize");
            showMessage("9. Distance between vectors");
            showMessage("10. Back to Vector Menu");
            showMessage("Choose operation: ");

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
                default -> showError("Invalid option!");
            }
        }
    }

    private void performVector3dAddition() {
        showSectionHeader("VECTOR ADDITION");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        Vector3f result = controller.addVectors(v1, v2);
        showMessage("Result: " + v1 + " + " + v2 + " = " + result);
    }

    private void performVector3dSubtraction() {
        showSectionHeader("VECTOR SUBTRACTION");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        Vector3f result = controller.subtractVectors(v1, v2);
        showMessage("Result: " + v1 + " - " + v2 + " = " + result);
    }

    private void performVector3dDotProduct() {
        showSectionHeader("DOT PRODUCT");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        float result = controller.dotProduct(v1, v2);
        showMessage("Result: " + v1 + " · " + v2 + " = " + result);
    }

    private void performVector3dCrossProduct() {
        showSectionHeader("CROSS PRODUCT");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        Vector3f result = controller.crossProduct(v1, v2);
        showMessage("Result: " + v1 + " × " + v2 + " = " + result);
    }

    private void performVector3dScalarMultiplication() {
        showSectionHeader("SCALAR MULTIPLICATION");
        Vector3f v = readVector3f("Enter vector");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        Vector3f result = controller.multiplyVector(v, scalar);
        showMessage("Result: " + v + " * " + scalar + " = " + result);
    }

    private void performVector3dScalarDivision() {
        showSectionHeader("SCALAR DIVISION");
        Vector3f v = readVector3f("Enter vector");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        try {
            Vector3f result = controller.divideVector(v, scalar);
            showMessage("Result: " + v + " / " + scalar + " = " + result);
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performVector3dLength() {
        showSectionHeader("VECTOR LENGTH");
        Vector3f v = readVector3f("Enter vector");

        float length = controller.vectorLength(v);
        showMessage("Length of " + v + " = " + length);
    }

    private void performVector3dNormalization() {
        showSectionHeader("VECTOR NORMALIZATION");
        Vector3f v = readVector3f("Enter vector");

        try {
            Vector3f normalized = controller.normalizeVector(v);
            showMessage("Normalized " + v + " = " + normalized);
            showMessage("Length of normalized vector: " + controller.vectorLength(normalized));
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performVector3dDistance() {
        showSectionHeader("DISTANCE BETWEEN VECTORS");
        Vector3f v1 = readVector3f("Enter first vector");
        Vector3f v2 = readVector3f("Enter second vector");

        float distance = controller.distance(v1, v2);
        showMessage("Distance between " + v1 + " and " + v2 + " = " + distance);
    }

    private void showVector4dMenu() {
        while (true) {
            showSectionHeader("4D VECTOR OPERATIONS");
            showMessage("1. Add Vectors");
            showMessage("2. Subtract Vectors");
            showMessage("3. Dot Product");
            showMessage("4. Multiply by Scalar");
            showMessage("5. Divide by Scalar");
            showMessage("6. Length");
            showMessage("7. Normalize");
            showMessage("8. Convert to/from 3D");
            showMessage("9. Back to Vector Menu");
            showMessage("Choose operation: ");

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
                default -> showError("Invalid option!");
            }
        }
    }

    private void performVector4dAddition() {
        showSectionHeader("VECTOR ADDITION");
        Vector4f v1 = readVector4f("Enter first vector");
        Vector4f v2 = readVector4f("Enter second vector");

        Vector4f result = controller.addVectors(v1, v2);
        showMessage("Result: " + v1 + " + " + v2 + " = " + result);
    }

    private void performVector4dSubtraction() {
        showSectionHeader("VECTOR SUBTRACTION");
        Vector4f v1 = readVector4f("Enter first vector");
        Vector4f v2 = readVector4f("Enter second vector");

        Vector4f result = controller.subtractVectors(v1, v2);
        showMessage("Result: " + v1 + " - " + v2 + " = " + result);
    }

    private void performVector4dDotProduct() {
        showSectionHeader("DOT PRODUCT");
        Vector4f v1 = readVector4f("Enter first vector");
        Vector4f v2 = readVector4f("Enter second vector");

        float result = controller.dotProduct(v1, v2);
        showMessage("Result: " + v1 + " · " + v2 + " = " + result);
    }

    private void performVector4dScalarMultiplication() {
        showSectionHeader("SCALAR MULTIPLICATION");
        Vector4f v = readVector4f("Enter vector");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        Vector4f result = controller.multiplyVector(v, scalar);
        showMessage("Result: " + v + " * " + scalar + " = " + result);
    }

    private void performVector4dScalarDivision() {
        showSectionHeader("SCALAR DIVISION");
        Vector4f v = readVector4f("Enter vector");
        showMessage("Enter scalar: ");
        float scalar = readFloat();

        try {
            Vector4f result = controller.divideVector(v, scalar);
            showMessage("Result: " + v + " / " + scalar + " = " + result);
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performVector4dLength() {
        showSectionHeader("VECTOR LENGTH");
        Vector4f v = readVector4f("Enter vector");

        float length = controller.vectorLength(v);
        showMessage("Length of " + v + " = " + length);
    }

    private void performVector4dNormalization() {
        showSectionHeader("VECTOR NORMALIZATION");
        Vector4f v = readVector4f("Enter vector");

        try {
            Vector4f normalized = controller.normalizeVector(v);
            showMessage("Normalized " + v + " = " + normalized);
            showMessage("Length of normalized vector: " + controller.vectorLength(normalized));
        } catch (ArithmeticException e) {
            showError("Error: " + e.getMessage());
        }
    }

    private void performVectorConversion() {
        showSectionHeader("VECTOR CONVERSION");
        showMessage("1. 3D to 4D");
        showMessage("2. 4D to 3D");
        showMessage("Choose conversion: ");

        int choice = readInt();

        if (choice == 1) {
            Vector3f v3 = readVector3f("Enter 3D vector");
            Vector4f v4 = controller.vector3fTo4f(v3);
            showMessage("Converted to 4D: " + v4);
        } else if (choice == 2) {
            Vector4f v4 = readVector4f("Enter 4D vector");
            try {
                Vector3f v3 = controller.vector4fTo3f(v4);
                showMessage("Converted to 3D: " + v3);
            } catch (ArithmeticException e) {
                showError("Error: " + e.getMessage());
            }
        } else {
            showError("Invalid choice!");
        }
    }
}
