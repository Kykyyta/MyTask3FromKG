package math.view;

import math.controller.MathController;
import math.model.*;
import java.util.Scanner;

public class LinearAlgebraConsoleView extends BaseConsoleView {

    public LinearAlgebraConsoleView(MathController controller, Scanner scanner) {
        super(controller, scanner);
    }

    public void showLinearAlgebraMenu() {
        while (true) {
            showSectionHeader("LINEAR ALGEBRA");
            showMessage("1. Solve Linear System (3x3)");
            showMessage("2. Solve Linear System (4x4)");
            showMessage("3. Back to Main Menu");
            showMessage("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> solveLinearSystem3x3();
                case 2 -> solveLinearSystem4x4();
                case 3 -> { return; }
                default -> showError("Invalid option!");
            }
        }
    }

    private void solveLinearSystem3x3() {
        showSectionHeader("SOLVE 3x3 LINEAR SYSTEM");
        Matrix3f A = readMatrix3f("Enter coefficient matrix A");
        Vector3f b = readVector3f("Enter right-hand side vector b");

        try {
            Vector3f x = controller.solveLinearSystem(A, b);
            showMessage("Solution x = " + x);

            // Verification
            Vector3f Ax = controller.multiplyMatrixVector(A, x);
            showMessage("Verification A*x = " + Ax);
            showMessage("Solution is correct: " + Ax.equals(b));
        } catch (ArithmeticException e) {
            showError(e);
        }
    }

    private void solveLinearSystem4x4() {
        showSectionHeader("SOLVE 4x4 LINEAR SYSTEM");
        Matrix4f A = readMatrix4f("Enter coefficient matrix A");
        Vector4f b = readVector4f("Enter right-hand side vector b");

        try {
            Vector4f x = controller.solveLinearSystem(A, b);
            showMessage("Solution x = " + x);

            // Verification
            Vector4f Ax = controller.multiplyMatrixVector(A, x);
            showMessage("Verification A*x = " + Ax);
            showMessage("Solution is correct: " + Ax.equals(b));
        } catch (ArithmeticException e) {
            showError(e);
        }
    }
}