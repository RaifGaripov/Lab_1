package com.company;

public class Matrix {

    //objects of class
    private final int length, height;
    private final int[][] matrix;

    //constructor
    public Matrix(int Length, int Height) {
        this.length = Length;
        this.height = Height;
        this.matrix = new int[this.length][this.height];
    }

    public Matrix(int[][] Matrix) {
        this.length = Matrix.length;
        this.height = Matrix[0].length;
        this.matrix = Matrix;
    }

    //methods of class

    public int getElement(int Length, int Height) {
        try {
            return this.matrix[Length][Height];
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public void setElement(int Length, int Height, int value) {
        try {
            this.matrix[Length][Height] = value;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getSize() {
        try {
            return String.valueOf(this.length + "x" + this.height);
        } catch (Exception e) {
            System.out.println(e);
            return String.valueOf(-1);
        }
    }

    public int getLength() {
        try {
            return this.length;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public int getHeight() {
        try {
            return this.height;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public static Matrix add(Matrix first, Matrix second) throws IllegalArgumentException {
        if (first.length != second.length ||
                first.height != second.height) {
            throw new IllegalArgumentException();
        } else {
            Matrix tmpMatrix = new Matrix(first.getLength(), second.getHeight());
            for (int i = 0; i < tmpMatrix.height; i++) {
                for (int j = 0; j < tmpMatrix.length; j++) {
                    tmpMatrix.setElement(i, j, first.getElement(i, j) + second.getElement(i, j));
                }
            }
            return tmpMatrix;
        }
    }

    public static Matrix subtract(Matrix first, Matrix second) throws IllegalArgumentException {
        if (first.length != second.length ||
                first.height != second.height)
            throw new IllegalArgumentException();
        else {
            Matrix tmpMatrix = new Matrix(first.length, second.height);
            for (int i = 0; i < tmpMatrix.height; i++) {
                for (int j = 0; j < tmpMatrix.length; j++) {
                    tmpMatrix.setElement(i, j, first.getElement(i, j) - second.getElement(i, j));
                }
            }
            return tmpMatrix;
        }
    }

    public static Matrix multiply(Matrix first, Matrix second) throws IllegalArgumentException {
        if (first.height != second.length)
            throw new IllegalArgumentException();
        else {
            int n = first.length;
            int m = second.height;
            int o = second.length;
            int[][] tmpArr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < o; k++) {
                        tmpArr[i][j] += first.getElement(i, k) * second.getElement(k, j);
                    }
                }
            }
            Matrix tmpMatrix = new Matrix(tmpArr);
            return tmpMatrix;
        }
    }

    public Matrix scalarMultiplication(Matrix matrix, int scalar) {
        try {
            Matrix tmpMatrix = new Matrix(matrix.length, matrix.height);
            for (int i = 0; i < tmpMatrix.height; i++) {
                for (int j = 0; j < tmpMatrix.length; j++) {
                    tmpMatrix.setElement(i, j, tmpMatrix.getElement(i, j) * scalar);
                }
            }
            return tmpMatrix;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public double matrixDeterminant(Matrix matrix) {
        try {
            double result = 0;

            if (matrix.length == 1) {
                result = matrix.getElement(0, 0);
                return (result);
            }

            if (matrix.length == 2) {
                result = (matrix.getElement(0, 0) * matrix.getElement(1, 1)
                        - (matrix.getElement(0, 1) * matrix.getElement(1, 0)));
                return (result);
            }

            for (int i = 0; i < matrix.getHeight(); i++) {
                Matrix temp = new Matrix(matrix.length - 1, matrix.height - 1);

                for (int j = 1; j < matrix.length; j++) {
                    for (int k = 0; k < matrix.height; k++) {
                        if (k < i) {
                            temp.setElement(j - 1, k, matrix.getElement(j, k));
                        } else if (k > i) {
                            temp.setElement(j - 1, k - 1, matrix.getElement(j, k));
                        }
                    }
                }

                result += matrix.getElement(0, i) * Math.pow(-1, i) * matrixDeterminant(temp);
            }
            return (result);
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }


        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Matrix second = (Matrix) obj;
        try {

            if ((length != second.length) || (height != second.height)) {
                return false;
            }

            boolean comparison = true;

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (getElement(i, j) != second.getElement(i, j)) comparison = false;
                }
            }
            return comparison;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }


    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                str += (getElement(i, j) + "\t");
            }
            str = str + System.lineSeparator();
        }
        return str;
    }
}