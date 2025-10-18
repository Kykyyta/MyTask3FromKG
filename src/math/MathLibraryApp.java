package math;

import math.controller.MathController;
import math.tests.MathTests;
import math.view.MathConsoleView;

public class MathLibraryApp {

    public static void main(String[] args) {

        if (args.length > 0 && "test".equals(args[0])) {
            runTests();
        } else {
            runDemo();
        }
    }

    private static void runTests() {
        MathTests testRunner = new MathTests();
        testRunner.runAllTests();
    }

    private static void runDemo() {

        MathConsoleView view = new MathConsoleView();
        MathController controller = new MathController(view);

        controller.demonstrateVectorOperations();
        controller.demonstrateMatrixOperations();
        controller.demonstrateLinearAlgebraOperations();
        controller.demonstrateErrorHandling();

    }
}
