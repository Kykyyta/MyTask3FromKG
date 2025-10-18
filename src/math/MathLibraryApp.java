package math;

import math.controller.MathController;
import math.view.MathInteractiveView;

public class MathLibraryApp {
    public static void main(String[] args) {
        MathController controller = new MathController();

        if (args.length > 0 && "test".equals(args[0])) {
            // Режим тестирования
            controller.runTests();
        } else {
            // Интерактивный режим
            MathInteractiveView view = new MathInteractiveView(controller);
            view.start();
        }
    }
}
