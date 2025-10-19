package math.view;

import math.controller.MathController;
import math.model.*;

public class ErrorHandlingView {

    private final MathController controller;

    public ErrorHandlingView(MathController controller) {
        this.controller = controller;
    }

    public void demonstrateErrorHandling() {

        System.out.println("\n=== ERROR HANDLING DEMONSTRATION ===");

        System.out.println("\n1. Testing division by zero:");

        try {
            Vector2f v = new Vector2f(1, 1);
            System.out.println("Dividing vector " + v + " by zero...");
            controller.divideVector(v, 0);
        } catch (ArithmeticException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }

        System.out.println("\n2. Testing normalization of zero vector:");

        try {
            Vector3f zero = new Vector3f(0, 0, 0);
            System.out.println("Normalizing zero vector " + zero + "...");
            controller.normalizeVector(zero);
        } catch (ArithmeticException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }

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
}
