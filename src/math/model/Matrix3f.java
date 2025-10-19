package math.model;

import math.model.base.AbstractMatrix;

public class Matrix3f extends AbstractMatrix<Matrix3f, Vector3f> {

    public Matrix3f(float[][] data) {
        super(data, 3);
    }

    @Override
    protected Matrix3f createNew(float[][] data) {

        return new Matrix3f(data);

    }

    public static Matrix3f identity() { // единичная
        return new Matrix3f(new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });
    }

    public static Matrix3f zero() { // нулевая матрица
        return new Matrix3f(new float[3][3]);
    }

    @Override
    public Vector3f multiply(Vector3f vector) { // матрица * вектор столбец

        float x = data[0][0] * vector.getX() + data[0][1] * vector.getY() + data[0][2] * vector.getZ();
        float y = data[1][0] * vector.getX() + data[1][1] * vector.getY() + data[1][2] * vector.getZ();
        float z = data[2][0] * vector.getX() + data[2][1] * vector.getY() + data[2][2] * vector.getZ();

        return new Vector3f(x, y, z);

    }

    @Override
    public float determinant() { // определитель

        float a = data[0][0], b = data[0][1], c = data[0][2];
        float d = data[1][0], e = data[1][1], f = data[1][2];
        float g = data[2][0], h = data[2][1], i = data[2][2];

        return a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);

    }

    @Override
    public Matrix3f inverse() { // обратная

        float det = determinant();

        if (Math.abs(det) < 1e-12f) { // чек вырожденность
            throw new ArithmeticException("To find the inverse matrix, it must be non-singular");
        }

        float a = data[0][0], b = data[0][1], c = data[0][2];
        float d = data[1][0], e = data[1][1], f = data[1][2];
        float g = data[2][0], h = data[2][1], i = data[2][2];

        float invDet = 1.0f / det;

        float[][] result = {
                {(e * i - f * h) * invDet, (c * h - b * i) * invDet, (b * f - c * e) * invDet}, // 1 строка
                {(f * g - d * i) * invDet, (a * i - c * g) * invDet, (c * d - a * f) * invDet}, // 2
                {(d * h - e * g) * invDet, (b * g - a * h) * invDet, (a * e - b * d) * invDet} // 3
        };

        return new Matrix3f(result);
    }

    @Override
    public Vector3f solveLinearSystem(Vector3f b) {

        return solveGauss(b);

    }

    public Vector3f solveGauss(Vector3f b) { // ГАУСС

        float[][] augmented = new float[3][4]; // расширенная матрица

        for (int i = 0; i < 3; i++) { // заполнение матрица расширенной
            System.arraycopy(data[i], 0, augmented[i], 0, 3);
            switch(i) {
                case 0: augmented[i][3] = b.getX(); break;
                case 1: augmented[i][3] = b.getY(); break;
                case 2: augmented[i][3] = b.getZ(); break;
            }

        }

        for (int i = 0; i < 3; i++) { // приведение к верхней треугольной форме

            int maxRow = i; // с текущей строки старт

            for (int k = i + 1; k < 3; k++) {
                if (Math.abs(augmented[k][i]) > Math.abs(augmented[maxRow][i])) {
                    maxRow = k; // строка с большим элементом
                }
            }

            // перестановка строк
            float[] temp = augmented[i]; // сохраняем
            augmented[i] = augmented[maxRow]; // заменяем
            augmented[maxRow] = temp; // восстанавливаем

            if (Math.abs(augmented[i][i]) < 1e-12f) { // чек вырожденность
                throw new ArithmeticException("Matrix is singular, cannot solve system");
            }


            // обнуление элементов ниже главной диагонали
            for (int k = i + 1; k < 3; k++) {
                float factor = augmented[k][i] / augmented[i][i];
                for (int j = i; j < 4; j++) {
                    augmented[k][j] -= factor * augmented[i][j];
                }
            }
        }

        float[] solution = new float[3];


        // снизу - вверх
        for (int i = 2; i >= 0; i--) {

            solution[i] = augmented[i][3];

            // вычитание известные переменные
            for (int j = i + 1; j < 3; j++) {
                solution[i] -= augmented[i][j] * solution[j];
            }
            solution[i] /= augmented[i][i];
        }

        return new Vector3f(solution[0], solution[1], solution[2]);
    }

    public float get(int row, int col) { // для доступа к эл матрицы

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return data[row][col];

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("[");
            for (int j = 0; j < 3; j++) {
                sb.append(String.format("%.4f", data[i][j]));
                if (j < 2) sb.append(", ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}