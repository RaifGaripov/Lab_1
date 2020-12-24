package com.company;
public class Main {

    public static void main(String[] args) {
        int[][] arrayFirstMultiply =
                {{1,3,5},
                        {15,41,18},
                        {22,9,23},
                        {54,24,22}};

        int[][] arraySecondMultiply =
                {{4,1,3,55},
                        {78,44,71,10},
                        {13,22,47,3}};

        int[][] arraySubtractFirst = {
                {1, 1, 2},
                {5, 1, 1},
                {3, 2, 2}};

        int[][] arraySubtractSecond = {
                {2, 2, 1},
                {1, 1, 5},
                {1, 1, 1}};

        Matrix testFirst = new Matrix(arrayFirstMultiply);
        Matrix testSecond = new Matrix(arraySecondMultiply);
        Matrix subtractFirst = new Matrix(arraySubtractFirst);
        Matrix subtractSecond = new Matrix(arraySubtractSecond);

        System.out.println("Матрица:\n" + testFirst);
        //index with 0
        System.out.println("Элемент (2,2):\n" + testFirst.getElement(1, 1));
        System.out.println("Размерность:\n" + testFirst.getLength() + "x" + testFirst.getHeight());
        System.out.println("Сумма:\n" + Matrix.add(subtractFirst, subtractSecond));
        System.out.println("Разность:\n" + Matrix.subtract(subtractFirst, subtractSecond));

        System.out.println("Умножение:\n" + Matrix.multiply(testFirst, testSecond));
        System.out.println("Умножение матрицы на 5:\n" + subtractFirst.scalarMultiplication(subtractFirst, 5));
        System.out.println("Определитель матрицы:\n" + subtractFirst.matrixDeterminant(subtractFirst));
        System.out.println("Сравнение матриц:\n" + subtractFirst.equals(subtractSecond));
    }
}
