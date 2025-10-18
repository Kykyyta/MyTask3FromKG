package math.view;

import math.model.Vector2f;
import math.model.Vector3f;
import math.model.Vector4f;
import math.model.Matrix3f;
import math.model.Matrix4f;

public interface MathView {

    void showMessage(String message);
    void showVector2f(String name, Vector2f vector);
    void showVector3f(String name, Vector3f vector);
    void showVector4f(String name, Vector4f vector);
    void showMatrix3f(String name, Matrix3f matrix);
    void showMatrix4f(String name, Matrix4f matrix);
    void showError(String errorMessage);
    void showSectionHeader(String sectionName);

}
