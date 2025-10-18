package math.controller;

import math.model.*;
import math.view.MathView;

public class MathController {

    private final MathView view; // зависимость через инт

    public MathController(MathView view) {
        this.view = view;
    }

    public void demonstrateVectorOperations() {

        view.showSectionHeader("VECTOR OPERATIONS DEMONSTRATION");

        Vector2f v2a = new Vector2f(1, 2);
        Vector2f v2b = new Vector2f(3, 4);
        demonstrateVector2fOperations(v2a, v2b);

        Vector3f v3a = new Vector3f(1, 0, 0);
        Vector3f v3b = new Vector3f(0, 1, 0);
        demonstrateVector3fOperations(v3a, v3b);

        Vector4f v4a = new Vector4f(1, 2, 3, 1);
        Vector4f v4b = new Vector4f(4, 5, 6, 1);
        demonstrateVector4fOperations(v4a, v4b);
    }

    private void demonstrateVector2fOperations(Vector2f v1, Vector2f v2) {

        view.showMessage("\n--- Vector2f Operations ---");

        view.showVector2f("v1", v1);
        view.showVector2f("v2", v2);

        view.showVector2f("v1 + v2", v1.add(v2));
        view.showVector2f("v1 - v2", v1.subtract(v2));
        view.showVector2f("v1 * 2", v1.multiply(2));
        view.showVector2f("v1 / 2", v1.divide(2));

        view.showMessage("v1 · v2 = " + v1.dot(v2));
        view.showMessage("||v1|| = " + v1.length());
        view.showVector2f("normalized(v1)", v1.normalize());
        view.showMessage("distance(v1, v2) = " + v1.distance(v2));
    }

    private void demonstrateVector3fOperations(Vector3f v1, Vector3f v2) {

        view.showMessage("\n--- Vector3f Operations ---");

        view.showVector3f("v1", v1);
        view.showVector3f("v2", v2);

        view.showVector3f("v1 + v2", v1.add(v2));
        view.showVector3f("v1 - v2", v1.subtract(v2));
        view.showVector3f("v1 * 2", v1.multiply(2));
        view.showVector3f("v1 / 2", v1.divide(2));

        view.showMessage("v1 · v2 = " + v1.dot(v2));
        view.showVector3f("v1 × v2", v1.cross(v2));
        view.showMessage("||v1|| = " + v1.length());
        view.showVector3f("normalized(v1)", v1.normalize());
        view.showMessage("distance(v1, v2) = " + v1.distance(v2));
    }

    private void demonstrateVector4fOperations(Vector4f v1, Vector4f v2) {

        view.showMessage("\n--- Vector4f Operations ---");

        view.showVector4f("v1", v1);
        view.showVector4f("v2", v2);

        view.showVector4f("v1 + v2", v1.add(v2));
        view.showVector4f("v1 - v2", v1.subtract(v2));
        view.showVector4f("v1 * 2", v1.multiply(2));
        view.showVector4f("v1 / 2", v1.divide(2));

        view.showMessage("v1 · v2 = " + v1.dot(v2));
        view.showMessage("||v1|| = " + v1.length());
        view.showVector4f("normalized(v1)", v1.normalize());

        Vector3f v3 = new Vector3f(7, 8, 9);
        Vector4f v4from3 = new Vector4f(v3);
        Vector3f v3back = v4from3.toVector3f();
        view.showVector3f("Original Vector3f", v3);
        view.showVector4f("Converted to Vector4f", v4from3);
        view.showVector3f("Converted back to Vector3f", v3back);
    }

    public void demonstrateMatrixOperations() {

        view.showSectionHeader("MATRIX OPERATIONS DEMONSTRATION");

        Matrix3f m3a = new Matrix3f(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3f m3b = Matrix3f.identity();
        demonstrateMatrix3fOperations(m3a, m3b);

        Matrix4f m4a = new Matrix4f(new float[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4f m4b = Matrix4f.identity();
        demonstrateMatrix4fOperations(m4a, m4b);
    }

    private void demonstrateMatrix3fOperations(Matrix3f m1, Matrix3f m2) {

        view.showMessage("\n--- Matrix3f Operations ---");

        view.showMatrix3f("m1", m1);
        view.showMatrix3f("m2", m2);

        view.showMatrix3f("m1 + m2", m1.add(m2));
        view.showMatrix3f("m1 - m2", m1.subtract(m2));
        view.showMatrix3f("m1 * 2", m1.multiply(2));
        view.showMatrix3f("m1 * m2", m1.multiply(m2));
        view.showMatrix3f("transpose(m1)", m1.transpose());

        view.showMessage("det(m1) = " + m1.determinant());

        try {
            view.showMatrix3f("inverse(m2)", m2.inverse());
        } catch (ArithmeticException e) {
            view.showError("Cannot invert matrix: " + e.getMessage());
        }
    }

    private void demonstrateMatrix4fOperations(Matrix4f m1, Matrix4f m2) {

        view.showMessage("\n--- Matrix4f Operations ---");
        view.showMatrix4f("m1", m1);
        view.showMatrix4f("m2", m2);
        view.showMatrix4f("m1 + m2", m1.add(m2));
        view.showMatrix4f("m1 - m2", m1.subtract(m2));
        view.showMatrix4f("m1 * 2", m1.multiply(2));
        view.showMatrix4f("m1 * m2", m1.multiply(m2));
        view.showMatrix4f("transpose(m1)", m1.transpose());

        view.showMessage("det(m1) = " + m1.determinant());

        try {
            view.showMatrix4f("inverse(m2)", m2.inverse());
        } catch (ArithmeticException e) {
            view.showError("Cannot invert matrix: " + e.getMessage());
        }
    }

    public void demonstrateLinearAlgebraOperations() {

        view.showSectionHeader("LINEAR ALGEBRA OPERATIONS DEMONSTRATION");

        demonstrateLinearSystemSolving(); // системка
        demonstrateMatrixVectorMultiplication(); // матрица на вектор
    }

    private void demonstrateLinearSystemSolving() {

        view.showMessage("\n--- Linear System Solving ---");

        Matrix3f A3 = new Matrix3f(new float[][]{
                {2, 1, -1},
                {-3, -1, 2},
                {-2, 1, 2}
        });

        Vector3f b3 = new Vector3f(8, -11, -3);

        view.showMatrix3f("Coefficient matrix A", A3);
        view.showVector3f("Right-hand side b", b3);

        try {
            Vector3f x3 = A3.solveLinearSystem(b3);
            view.showVector3f("Solution x", x3);

            Vector3f Ax = A3.multiply(x3);
            view.showVector3f("Verification: A*x", Ax);
            view.showMessage("Solution is correct: " + Ax.equals(b3));
        } catch (ArithmeticException e) {
            view.showError("Cannot solve system: " + e.getMessage());
        }

        Matrix4f A4 = new Matrix4f(new float[][]{
                {2, 1, 1, 1},
                {1, 3, 1, 1},
                {1, 1, 4, 1},
                {1, 1, 1, 5}
        });

        Vector4f b4 = new Vector4f(5, 6, 7, 8);

        view.showMatrix4f("Coefficient matrix A", A4);
        view.showVector4f("Right-hand side b", b4);

        try {
            Vector4f x4 = A4.solveLinearSystem(b4);
            view.showVector4f("Solution x", x4);

            Vector4f Ax = A4.multiply(x4);
            view.showVector4f("Verification: A*x", Ax);
            view.showMessage("Solution is correct: " + Ax.equals(b4));
        } catch (ArithmeticException e) {
            view.showError("Cannot solve system: " + e.getMessage());
        }
    }

    private void demonstrateMatrixVectorMultiplication() {

        view.showMessage("\n--- Matrix-Vector Multiplication ---");

        Matrix3f M3 = new Matrix3f(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Vector3f v3 = new Vector3f(1, 2, 3);

        view.showMatrix3f("Matrix M", M3);
        view.showVector3f("Vector v", v3);
        view.showVector3f("M * v", M3.multiply(v3));

        Matrix4f M4 = new Matrix4f(new float[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        Vector4f v4 = new Vector4f(1, 2, 3, 4);

        view.showMatrix4f("Matrix M", M4);
        view.showVector4f("Vector v", v4);
        view.showVector4f("M * v", M4.multiply(v4));
    }

    public void demonstrateErrorHandling() {

        view.showSectionHeader("ERROR HANDLING DEMONSTRATION");

        try {
            Vector2f v = new Vector2f(1, 1);
            v.divide(0);
        } catch (ArithmeticException e) {
            view.showError("Division by zero: " + e.getMessage());
        }

        try {
            Vector3f zero = new Vector3f(0, 0, 0);
            zero.normalize();
        } catch (ArithmeticException e) {
            view.showError("Normalization of zero vector: " + e.getMessage());
        }

        try {
            Matrix3f singular = new Matrix3f(new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            });
            singular.inverse();
        } catch (ArithmeticException e) {
            view.showError("Inversion of singular matrix: " + e.getMessage());
        }

        try {
            Matrix3f inconsistent = new Matrix3f(new float[][]{
                    {1, 1, 1},
                    {1, 1, 1},
                    {1, 1, 1}
            });
            Vector3f b = new Vector3f(1, 2, 3);
            inconsistent.solveLinearSystem(b);
        } catch (ArithmeticException e) {
            view.showError("Solving inconsistent system: " + e.getMessage());
        }

        try {
            Vector4f v4 = new Vector4f(1, 2, 3, 0);
            v4.toVector3f();
        } catch (ArithmeticException e) {
            view.showError("Vector4f to Vector3f conversion with w=0: " + e.getMessage());
        }
    }
}
