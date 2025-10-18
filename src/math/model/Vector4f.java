package math.model;

import math.model.base.AbstractVector;

public class Vector4f extends AbstractVector<Vector4f> {

    public Vector4f(float x, float y, float z, float w) {
        super(new float[]{x, y, z, w});
    }

    public Vector4f(Vector3f vec3) { // w - переданный компонент
        this(vec3.getX(), vec3.getY(), vec3.getZ(), 1.0f);
    }

    @Override
    protected Vector4f createNew(float[] components) {
        return new Vector4f(components[0], components[1], components[2], components[3]);
    }

    public float getX() { return components[0]; }
    public float getY() { return components[1]; }
    public float getZ() { return components[2]; }
    public float getW() { return components[3]; }

    public Vector3f toVector3f() { // преобразование 4 в 3

        if (Math.abs(getW()) < 1e-12f) {
            throw new ArithmeticException("Cannot project vector with w=0");
        }
        return new Vector3f(getX() / getW(), getY() / getW(), getZ() / getW());

    }

    @Override
    public String toString() {
        return String.format("(%.4f, %.4f, %.4f, %.4f)", getX(), getY(), getZ(), getW());
    }
}