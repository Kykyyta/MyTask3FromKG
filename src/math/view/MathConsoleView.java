package math.view;

import math.model.Vector2f;
import math.model.Vector3f;
import math.model.Vector4f;
import math.model.Matrix3f;
import math.model.Matrix4f;

public class MathConsoleView implements MathView {

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showVector2f(String name, Vector2f vector) {
        System.out.println(name + " = " + vector);
    }

    @Override
    public void showVector3f(String name, Vector3f vector) {
        System.out.println(name + " = " + vector);
    }

    @Override
    public void showVector4f(String name, Vector4f vector) {
        System.out.println(name + " = " + vector);
    }

    @Override
    public void showMatrix3f(String name, Matrix3f matrix) {
        System.out.println(name + ":");
        System.out.print(matrix);
    }

    @Override
    public void showMatrix4f(String name, Matrix4f matrix) {
        System.out.println(name + ":");
        System.out.print(matrix);
    }

    @Override
    public void showError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage);
    }

    @Override
    public void showSectionHeader(String sectionName) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(sectionName);
        System.out.println("=".repeat(60));
    }
}