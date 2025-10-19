package math.view;

import math.controller.MathController;
import java.util.Scanner;

public class MathInteractiveView {
    private final MathController controller;
    private final Scanner scanner;
    private final VectorConsoleView vectorView;
    private final MatrixConsoleView matrixView;
    private final LinearAlgebraConsoleView linearAlgebraView;
    private final ErrorHandlingView errorHandlingView;

    public MathInteractiveView(MathController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        this.vectorView = new VectorConsoleView(controller, scanner);
        this.matrixView = new MatrixConsoleView(controller, scanner);
        this.linearAlgebraView = new LinearAlgebraConsoleView(controller, scanner);
        this.errorHandlingView = new ErrorHandlingView(controller);
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
            System.out.println("4. Error Handling Demonstration");
            System.out.println("5. Run All Tests");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> vectorView.showVectorMenu();
                case 2 -> matrixView.showMatrixMenu();
                case 3 -> linearAlgebraView.showLinearAlgebraMenu();
                case 4 -> errorHandlingView.demonstrateErrorHandling();
                case 5 -> runTests();
                case 6 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void runTests() {
        System.out.println("\n=== RUNNING ALL TESTS ===");
        controller.runTests();
    }
}