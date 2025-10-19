package math.tests;

import math.model.*;

public class MathTests {

    private int passedTests = 0;
    private int failedTests = 0;

    public void runAllTests() {

        System.out.println("=== COMPREHENSIVE MATH LIBRARY TESTS ===\n");

        testVector2f();
        testVector3f();
        testVector4f();
        testMatrix3f();
        testMatrix4f();
        testErrorHandling();
        testEdgeCases();

        printSummary(); // итог
    }

    private void testVector2f() {

        System.out.println("=== VECTOR2F TESTS ===");

        test("Vector2f constructor", () -> {

            Vector2f v = new Vector2f(1.5f, 2.5f);

            assertFloatEquals(1.5f, v.getX(), 0.0001f);
            assertFloatEquals(2.5f, v.getY(), 0.0001f);

        });

        test("Vector2f addition", () -> {
            Vector2f v1 = new Vector2f(1, 2);
            Vector2f v2 = new Vector2f(3, 4);

            Vector2f result = v1.add(v2);

            assertVectorEquals(new Vector2f(4, 6), result);
        });

        test("Vector2f subtraction", () -> {
            Vector2f v1 = new Vector2f(1, 2);
            Vector2f v2 = new Vector2f(3, 4);

            Vector2f result = v1.subtract(v2);

            assertVectorEquals(new Vector2f(-2, -2), result);
        });

        test("Vector2f scalar multiplication", () -> {
            Vector2f v = new Vector2f(2, 3);

            Vector2f result = v.multiply(2);

            assertVectorEquals(new Vector2f(4, 6), result);
        });

        test("Vector2f scalar division", () -> {
            Vector2f v = new Vector2f(2, 3);

            Vector2f result = v.divide(2);

            assertVectorEquals(new Vector2f(1, 1.5f), result);
        });

        test("Vector2f length", () -> {
            Vector2f v = new Vector2f(3, 4);
            assertFloatEquals(5, v.length(), 0.0001f);
        });

        test("Vector2f normalization", () -> {
            Vector2f v = new Vector2f(3, 4);
            Vector2f normalized = v.normalize();
            assertFloatEquals(1, normalized.length(), 0.0001f);
        });

        test("Vector2f dot product", () -> {
            Vector2f v1 = new Vector2f(1, 2);
            Vector2f v2 = new Vector2f(3, 4);
            assertFloatEquals(11, v1.dot(v2), 0.0001f);
        });

        test("Vector2f distance", () -> {
            Vector2f v1 = new Vector2f(0, 0);
            Vector2f v2 = new Vector2f(3, 4);
            assertFloatEquals(5, v1.distance(v2), 0.0001f);
        });
    }

    private void testVector3f() {

        System.out.println("\n=== VECTOR3F TESTS ===");

        test("Vector3f constructor", () -> {
            Vector3f v = new Vector3f(1.5f, 2.5f, 3.5f);
            assertFloatEquals(1.5f, v.getX(), 0.0001f);
            assertFloatEquals(2.5f, v.getY(), 0.0001f);
            assertFloatEquals(3.5f, v.getZ(), 0.0001f);
        });

        test("Vector3f addition", () -> {
            Vector3f v1 = new Vector3f(1, 2, 3);
            Vector3f v2 = new Vector3f(4, 5, 6);
            Vector3f result = v1.add(v2);
            assertVectorEquals(new Vector3f(5, 7, 9), result);
        });

        test("Vector3f cross product", () -> {
            Vector3f v1 = new Vector3f(1, 0, 0);
            Vector3f v2 = new Vector3f(0, 1, 0);
            Vector3f result = v1.cross(v2);
            assertVectorEquals(new Vector3f(0, 0, 1), result);
        });

        test("Vector3f dot product", () -> {
            Vector3f v1 = new Vector3f(1, 2, 3);
            Vector3f v2 = new Vector3f(4, 5, 6);
            assertFloatEquals(32, v1.dot(v2), 0.0001f);
        });

        test("Vector3f length", () -> {
            Vector3f v = new Vector3f(1, 2, 2);
            assertFloatEquals(3, v.length(), 0.0001f);
        });

        test("Vector3f normalization", () -> {
            Vector3f v = new Vector3f(1, 2, 2);
            Vector3f normalized = v.normalize();
            assertFloatEquals(1, normalized.length(), 0.0001f);
        });

        test("Vector3f distance", () -> {
            Vector3f v1 = new Vector3f(0, 0, 0);
            Vector3f v2 = new Vector3f(1, 2, 2);
            assertFloatEquals(3, v1.distance(v2), 0.0001f);
        });
    }

    private void testVector4f() {

        System.out.println("\n=== VECTOR4F TESTS ===");

        test("Vector4f constructor", () -> {
            Vector4f v = new Vector4f(1.5f, 2.5f, 3.5f, 1.0f);
            assertFloatEquals(1.5f, v.getX(), 0.0001f);
            assertFloatEquals(2.5f, v.getY(), 0.0001f);
            assertFloatEquals(3.5f, v.getZ(), 0.0001f);
            assertFloatEquals(1.0f, v.getW(), 0.0001f);
        });

        test("Vector4f from Vector3f", () -> {
            Vector3f v3 = new Vector3f(1, 2, 3);
            Vector4f v4 = new Vector4f(v3);
            assertVectorEquals(new Vector4f(1, 2, 3, 1), v4);
        });

        test("Vector4f to Vector3f", () -> {
            Vector4f v4 = new Vector4f(2, 4, 6, 2);
            Vector3f v3 = v4.toVector3f();
            assertVectorEquals(new Vector3f(1, 2, 3), v3);
        });

        test("Vector4f dot product", () -> {
            Vector4f v1 = new Vector4f(1, 2, 3, 4);
            Vector4f v2 = new Vector4f(5, 6, 7, 8);
            assertFloatEquals(70, v1.dot(v2), 0.0001f);
        });

        test("Vector4f length", () -> {
            Vector4f v = new Vector4f(1, 2, 2, 4);
            assertFloatEquals(5, v.length(), 0.0001f);
        });

        test("Vector4f normalization", () -> {
            Vector4f v = new Vector4f(1, 2, 2, 4);
            Vector4f normalized = v.normalize();
            assertFloatEquals(1, normalized.length(), 0.0001f);
        });

        test("Vector4f distance", () -> {
            Vector4f v1 = new Vector4f(1, 1, 1, 1);
            Vector4f v2 = new Vector4f(2, 2, 2, 2);
            assertFloatEquals(2, v1.distance(v2), 0.0001f);

            Vector4f v3 = new Vector4f(0, 0, 0, 0);
            Vector4f v4 = new Vector4f(1, 0, 0, 0);
            assertFloatEquals(1, v3.distance(v4), 0.0001f);

            Vector4f v5 = new Vector4f(1, 2, 3, 4);
            Vector4f v6 = new Vector4f(5, 6, 7, 8);
            assertFloatEquals(8, v5.distance(v6), 0.0001f);
        });
    }

    private void testMatrix3f() {

        System.out.println("\n=== MATRIX3F TESTS ===");

        test("Matrix3f identity", () -> {
            Matrix3f identity = Matrix3f.identity();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    float expected = (i == j) ? 1.0f : 0.0f;
                    assertFloatEquals(expected, identity.get(i, j), 0.0001f);
                }
            }
        });

        test("Matrix3f zero", () -> {
            Matrix3f zero = Matrix3f.zero();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    assertFloatEquals(0.0f, zero.get(i, j), 0.0001f);
                }
            }
        });

        test("Matrix3f determinant", () -> {
            Matrix3f matrix = new Matrix3f(new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            });
            assertFloatEquals(0, matrix.determinant(), 0.0001f);
        });

        test("Matrix3f inverse", () -> {
            Matrix3f matrix = new Matrix3f(new float[][]{
                    {4, 7, 2},
                    {3, 5, 1},
                    {2, 3, 4}
            });
            Matrix3f inverse = matrix.inverse();
            Matrix3f product = matrix.multiply(inverse);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    float expected = (i == j) ? 1.0f : 0.0f;
                    assertFloatEquals(expected, product.get(i, j), 0.001f);
                }
            }
        });

        test("Matrix3f vector multiplication", () -> {
            Matrix3f matrix = new Matrix3f(new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            });
            Vector3f vector = new Vector3f(1, 2, 3);
            Vector3f result = matrix.multiply(vector);
            assertVectorEquals(new Vector3f(14, 32, 50), result);
        });

        test("Matrix3f system solving", () -> {
            Matrix3f A = new Matrix3f(new float[][]{
                    {2, 1, -1},
                    {-3, -1, 2},
                    {-2, 1, 2}
            });
            Vector3f b = new Vector3f(8, -11, -3);
            Vector3f x = A.solveLinearSystem(b);
            assertVectorEquals(new Vector3f(2, 3, -1), x);
        });

        test("Matrix3f transpose", () -> {
            Matrix3f matrix = new Matrix3f(new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            });
            Matrix3f transposed = matrix.transpose();
            Matrix3f expected = new Matrix3f(new float[][]{
                    {1, 4, 7},
                    {2, 5, 8},
                    {3, 6, 9}
            });
            assertMatrixEquals(expected, transposed);
        });
    }

    private void testMatrix4f() {

        System.out.println("\n=== MATRIX4F TESTS ===");

        test("Matrix4f identity", () -> {
            Matrix4f identity = Matrix4f.identity();
            assertFloatEquals(1.0f, identity.determinant(), 0.0001f);
        });

        test("Matrix4f zero", () -> {
            Matrix4f zero = Matrix4f.zero();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    assertFloatEquals(0.0f, zero.get(i, j), 0.0001f);
                }
            }
        });

        test("Matrix4f determinant", () -> {
            Matrix4f matrix = new Matrix4f(new float[][]{
                    {1, 0, 0, 0},
                    {0, 2, 0, 0},
                    {0, 0, 3, 0},
                    {0, 0, 0, 4}
            });
            assertFloatEquals(24, matrix.determinant(), 0.0001f);
        });

        test("Matrix4f vector multiplication", () -> {
            Matrix4f matrix = new Matrix4f(new float[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            });
            Vector4f vector = new Vector4f(1, 2, 3, 4);
            Vector4f result = matrix.multiply(vector);
            assertVectorEquals(new Vector4f(30, 70, 110, 150), result);
        });

        test("Matrix4f system solving", () -> {
            Matrix4f A = new Matrix4f(new float[][]{
                    {2, 1, 1, 1},
                    {1, 3, 1, 1},
                    {1, 1, 4, 1},
                    {1, 1, 1, 5}
            });
            Vector4f b = new Vector4f(5, 6, 7, 8);
            Vector4f x = A.solveLinearSystem(b);

            Vector4f Ax = A.multiply(x);
            assertVectorEquals(b, Ax);
        });

        test("Matrix4f transpose", () -> {
            Matrix4f matrix = new Matrix4f(new float[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            });
            Matrix4f transposed = matrix.transpose();
            Matrix4f expected = new Matrix4f(new float[][]{
                    {1, 5, 9, 13},
                    {2, 6, 10, 14},
                    {3, 7, 11, 15},
                    {4, 8, 12, 16}
            });
            assertMatrixEquals(expected, transposed);
        });
    }

    private void testErrorHandling() { // ОБРАБОТКА ОШИБОК - ВАЖНА

        System.out.println("\n=== ERROR HANDLING TESTS ===");

        test("Division by zero throws exception", () -> {
            Vector2f v = new Vector2f(1, 1);
            try {
                v.divide(0);
                throw new AssertionError("Expected ArithmeticException");
            } catch (ArithmeticException e) {
                // Expected
            }
        });

        test("Normalize zero vector throws exception", () -> {
            Vector3f zero = new Vector3f(0, 0, 0);
            try {
                zero.normalize();
                throw new AssertionError("Expected ArithmeticException");
            } catch (ArithmeticException e) {
                // Expected
            }
        });

        test("Invert singular matrix throws exception", () -> {
            Matrix3f singular = new Matrix3f(new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            });
            try {
                singular.inverse();
                throw new AssertionError("Expected ArithmeticException");
            } catch (ArithmeticException e) {
                // Expected
            }
        });

        test("Vector4f to Vector3f with w=0 throws exception", () -> {
            Vector4f v = new Vector4f(1, 2, 3, 0);
            try {
                v.toVector3f();
                throw new AssertionError("Expected ArithmeticException");
            } catch (ArithmeticException e) {
                // Expected
            }
        });
    }

    private void testEdgeCases() { // обработка граничных случаев

        System.out.println("\n=== EDGE CASE TESTS ===");

        // с очень маленькими знач
        test("Vector2f with very small values", () -> {
            Vector2f v = new Vector2f(1e-10f, 1e-10f);
            Vector2f normalized = v.normalize();
            assertFloatEquals(1.0f, normalized.length(), 1e-6f);
        });

        // с очень большими
        test("Vector3f with large values", () -> {
            Vector3f v = new Vector3f(1e6f, 2e6f, 3e6f);
            Vector3f result = v.multiply(1e-6f);
            assertVectorEquals(new Vector3f(1, 2, 3), result);
        });

        // на ед матрицу умножение
        test("Matrix operations with identity", () -> {
            Matrix3f identity = Matrix3f.identity();
            Matrix3f matrix = new Matrix3f(new float[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            });

            Matrix3f result = matrix.multiply(identity);
            assertMatrixEquals(matrix, result);
        });

        // с нулевым вектором
        test("Vector operations with zero vector", () -> {
            Vector3f zero = new Vector3f(0, 0, 0);
            Vector3f v = new Vector3f(1, 2, 3);

            Vector3f result = zero.add(v);
            assertVectorEquals(v, result);
        });
    }

    private void test(String testName, Runnable test) {
        try {
            test.run();
            passedTests++;
            System.out.println("✓ " + testName);
        } catch (AssertionError e) {
            failedTests++;
            System.out.println("✗ " + testName + " - " + e.getMessage());
        } catch (Exception e) {
            failedTests++;
            System.out.println("✗ " + testName + " - Unexpected exception: " + e.getMessage());
        }
    }

    private void assertFloatEquals(float expected, float actual, float tolerance) { // проверка равенства чисел с допустимой погрешностью

        if (Math.abs(expected - actual) > tolerance) {

            throw new AssertionError("Expected " + expected + " but got " + actual);

        }
    }

    private void assertVectorEquals(Vector2f expected, Vector2f actual) {

        if (!expected.equals(actual)) {

            throw new AssertionError("Expected " + expected + " but got " + actual);

        }

    }

    private void assertVectorEquals(Vector3f expected, Vector3f actual) {

        if (!expected.equals(actual)) {

            throw new AssertionError("Expected " + expected + " but got " + actual);

        }

    }

    private void assertVectorEquals(Vector4f expected, Vector4f actual) {

        if (!expected.equals(actual)) {

            throw new AssertionError("Expected " + expected + " but got " + actual);

        }

    }

    private void assertMatrixEquals(Matrix3f expected, Matrix3f actual) {

        if (!expected.equals(actual)) {

            throw new AssertionError("Expected:\n" + expected + "\nBut got:\n" + actual);

        }
    }

    private void assertMatrixEquals(Matrix4f expected, Matrix4f actual) {

        if (!expected.equals(actual)) {

            throw new AssertionError("Expected:\n" + expected + "\nBut got:\n" + actual);

        }

    }

    private void printSummary() {

        System.out.println("\n=== TEST SUMMARY ===");

        System.out.println("Passed: " + passedTests);
        System.out.println("Failed: " + failedTests);
        System.out.println("Total: " + (passedTests + failedTests));

        if (failedTests == 0) {
            System.out.println("\n ALL TESTS PASSED!");
        } else {
            System.out.println("\n SOME TESTS FAILED!");
        }

    }
}