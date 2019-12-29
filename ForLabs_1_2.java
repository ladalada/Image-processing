package Lab1_Lab2;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class ForLabs {

    protected static int enterDimension() {

        System.out.println("Enter dimension: ");
        Scanner in = new Scanner(System.in);

        int dim = in.nextInt();

        return dim;

    }

    protected static double[] enterVector(int dim, String partName, String vectorNumber) {

        System.out.println("Enter the " + partName + " part of the " + vectorNumber + " vector contour: ");
        Scanner in = new Scanner(System.in);

        double[] vector = new double[dim];

        for (int i = 0; i < dim; i++) {

            vector[i] = in.nextDouble();

        }

        return vector;

    }

    protected static void printVector(String vectorNumber, double[] real, double[] imaginary, int dim) {

        System.out.println("The " + vectorNumber + " vector contour is ");

        for (int i = 0; i < dim; i++) {

            System.out.print(real[i] + " + i * " + imaginary[i]);
            System.out.println();

        }

        System.out.println();

    }

    protected static void printComplexVector(String str, double real, double imaginary) {

        System.out.println(str + real + " + i * " + imaginary);
        System.out.println();

    }

    protected static void printComplexVector(String str, double[] real, double[] imaginary, int dim) {

        System.out.println(str);

        for (int i = 0; i < dim; i++) {

            System.out.print(real[i] + " + i * " + imaginary[i]);
            System.out.println();

        }

        System.out.println();

    }

    protected static double sumVectorPart(double[] vector){

        int dim = vector.length;
        double sum = 0;

        for (int i = 0; i < dim; i++) {

            sum += vector[i];

        }

        return sum;

    }

    protected static void loopCheck(double[] vectorReal, double[] vectorImaginary) {

        if (sumVectorPart(vectorReal) != 0 || sumVectorPart(vectorImaginary) != 0) {

            System.out.println("The vector contour is not closed.");

        }
        else {

            System.out.println("The vector contour is closed.");

        }

        System.out.println();

    }

    protected static double realScalarProduct(int dim, double[] a, double[] b, double[] c, double[] d) {

        double real = 0;

        for(int i = 0; i < dim; i++) {

            real += a[i] * c[i] + b[i] * d[i];

        }

        return real;

    }

    protected static double imaginaryScalarProduct(int dim, double[] a, double[] b, double[] c, double[] d) {

        double imaginary = 0;

        for(int i = 0; i < dim; i++) {

            imaginary += b[i] * c[i] - a[i] * d[i];

        }

        return imaginary;

    }

    protected static void calculationError() {

        System.out.println("Different dimensions of vector contours. ");
        System.out.println("The calculation of the scalar product of vector contours is impossible.");

    }

    protected static double[] moveLeft(double[] vector, int positions) {

        int dim = vector.length;
        double[] vectorMoved = Arrays.copyOf(vector, dim);

        for (int i = 0; i < positions; i++) {

            double temporary = vectorMoved[0];

            for (int j = 0; j < dim - 1; j++) {

                vectorMoved[j] = vectorMoved[j + 1];

            }

            vectorMoved[dim - 1] = temporary;

        }

        return vectorMoved;

    }

    protected static double[] moveRight(double[] vector, int positions) {

        int dim = vector.length;
        double[] vectorMoved = Arrays.copyOf(vector, dim);

        for (int i = 0; i < positions; i++) {

            double temporary = vectorMoved[dim - 1];

            for (int j = dim - 1; j > 0; j--) {

                vectorMoved[j] = vectorMoved[j - 1];

            }

            vectorMoved[0] = temporary;

        }

        return vectorMoved;

    }

    protected static double complexVectorModule(double real, double imaginary) {

        double norm = 0;
        norm += real*real + imaginary*imaginary;

        return sqrt(norm);

    }

    protected static double complexVectorModule(double[] real, double[] imaginary) {

        int dim = real.length;
        double norm = 0;

        for (int i = 0; i < dim; i++) {

            norm += real[i]*real[i] + imaginary[i]*imaginary[i];

        }

        return sqrt(norm);

    }

    protected enum ComplexPart {

        REAL,
        IMAGINARY

    }

    public static void main(String[] args) {

        System.out.println("These are just methods for labs.");

    }

}
