package math.view;

import math.controller.MathController;
import math.model.*;
import java.util.Scanner;

public class BaseConsoleView {

    protected final MathController controller;
    protected final Scanner scanner;

    public BaseConsoleView(MathController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    protected void showMessage(String message) {
        System.out.println(message);
    }

    protected void showError(String errorMessage) {

        String cleanMessage = errorMessage.replaceFirst("^(?i)error:\\s*", ""); // чтобы не было дублирований на всякий
        System.err.println("Error: " + cleanMessage);

    }

    protected void showError(Exception e) {
        showError(e.getMessage());
    }

    protected void showSectionHeader(String sectionName) {
        System.out.println("\n=== " + sectionName + " ===");
    }

    protected Vector2f readVector2f(String prompt) {

        showMessage(prompt + ":");
        showMessage("Enter x: ");
        float x = readFloat();
        showMessage("Enter y: ");
        float y = readFloat();

        return new Vector2f(x, y);

    }

    protected Vector3f readVector3f(String prompt) {

        showMessage(prompt + ":");
        showMessage("Enter x: ");
        float x = readFloat();
        showMessage("Enter y: ");
        float y = readFloat();
        showMessage("Enter z: ");
        float z = readFloat();

        return new Vector3f(x, y, z);

    }

    protected Vector4f readVector4f(String prompt) {

        showMessage(prompt + ":");
        showMessage("Enter x: ");
        float x = readFloat();
        showMessage("Enter y: ");
        float y = readFloat();
        showMessage("Enter z: ");
        float z = readFloat();
        showMessage("Enter w: ");
        float w = readFloat();

        return new Vector4f(x, y, z, w);

    }

    protected Matrix3f readMatrix3f(String prompt) {

        showMessage(prompt + ":");
        float[][] data = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                showMessage(String.format("Enter element [%d][%d]: ", i, j));
                data[i][j] = readFloat();
            }
        }
        return new Matrix3f(data);
    }

    protected Matrix4f readMatrix4f(String prompt) {

        showMessage(prompt + ":");
        float[][] data = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                showMessage(String.format("Enter element [%d][%d]: ", i, j));
                data[i][j] = readFloat();
            }
        }
        return new Matrix4f(data);

    }

    protected int readInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                showError("Invalid input. Please enter an integer");
                scanner.next();
            }
        }
    }

    protected float readFloat() {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (Exception e) {
                showError("Invalid input. Please enter a number");
                scanner.next();
            }
        }
    }
}