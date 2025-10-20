package math;

import math.controller.MathController;
import math.view.MathInteractiveView;

public class MathLibraryApp {

    public static void main(String[] args) {
        MathController controller = new MathController();
        MathInteractiveView view = new MathInteractiveView(controller);
        view.start();
    }
}
