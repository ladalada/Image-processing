//Скалярное произведение контуров

import java.util.Scanner;

public class Lab1_ContoursScalarProduct {

    private static double[] enterVector(int dimension, String partName, String vectorNumber) {
        System.out.println("Enter the " + partName + " part of the " + vectorNumber + " vector contour: ");
        Scanner in = new Scanner(System.in);
        double[] vector = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            vector[i] = in.nextDouble();
        }
        return vector;
    }

    private static void printVector(String vectorNumber, double[] real, double[] imaginary, int dimension) {
        System.out.println("The " + vectorNumber + " vector contour is ");
        for (int i = 0; i < dimension; i++) {
            System.out.print(real[i] + " + i * " + imaginary[i]);
            System.out.println();
        }
    }

    private static void scalarProductCalculation (int dimension, double[] a, double[] b, double[] c, double[] d) {
        double real = 0;
        double imaginary = 0;

        for(int i = 0; i < dimension; i++) {
            real += a[i] * c[i] + b[i] * d[i];
            imaginary += b[i] * c[i] - a[i] * d[i];
        }

        System.out.println("The scalar product of vector contours is");
        System.out.println(real + " + i * " + imaginary);
    }

    private static void calculationError() {
        System.out.println("Different dimensions of vector contours. ");
        System.out.println("The calculation of the scalar product of vector contours is impossible.");
    }

    public static void main(String[] args) {

        System.out.println("Enter dimension: ");
        Scanner in = new Scanner(System.in);
        int dim = in.nextInt();

        double[] a, b, c, d;
        a = enterVector(dim, "real", "first");
        b = enterVector(dim, "imaginary", "first");
        c = enterVector(dim, "real", "second");
        d = enterVector(dim, "imaginary", "second");

        printVector("first", a, b, dim);
        printVector("second", c, d, dim);

        if(a.length == dim && b.length == dim && c.length == dim && d.length == dim) {
            scalarProductCalculation(dim, a, b, c, d);
        }
        else {
            calculationError();
        }

    }

}
