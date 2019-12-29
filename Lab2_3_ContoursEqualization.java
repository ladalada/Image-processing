package Lab1_Lab2;

import java.util.Scanner;

public class Lab2_3_ContoursEqualization {

    protected static int enterDimensionForEqualization() {

        System.out.println("Enter dimension for equalization: ");
        Scanner in = new Scanner(System.in);

        int dimEq = in.nextInt();

        return dimEq;

    }

    protected static double[] ContoursEqualization(int dim, int dimForEqualization, double[] oldVector) {

        int dimEq = dimForEqualization;
        double[] newVector = new double[dimEq];

        if (dim > dimEq) {

            for (int i = 0; i < dim; i++) {

                newVector[i * dimEq / dim] += oldVector[i];

            }

        }
        else if (dim < dimEq) {

            double sum = 0;

            for (int i = 0; i < dimEq - 1; i++) {

                double index = 1.0 * i * dim / dimEq;
                int j = (int)index;
                double k = index - j;
                newVector[i] = oldVector[j] * (1 - k) + oldVector[j + 1] * k;
                sum += newVector[i];

            }
            newVector[dimEq - 1] -= sum;

        }
        else {

            newVector = oldVector;

        }

        return newVector;

    }

    protected static void printContoursEqualization(int dim, int dimForEqualization, double[] a, double[] b) {

        int dimEq = dimForEqualization;

        if (dim != 0 && dimEq != 0) {

            ForLabs.printComplexVector("The vector contour after equalization is ",
                    ContoursEqualization(dim, dimEq, a), ContoursEqualization(dim, dimEq, b), dimEq);

        }
        else {

            System.out.println("Error! Dimension cannot be zero!");

        }

    }

    public static void main(String[] args) {

        int dim = ForLabs.enterDimension();

        double[] a = ForLabs.enterVector(dim, "real", "first");
        double[] b = ForLabs.enterVector(dim, "imaginary", "first");
        ForLabs.loopCheck(a, b);

        ForLabs.printVector("first", a, b, dim);

        int dimEq = enterDimensionForEqualization();

        printContoursEqualization(dim, dimEq, a, b);

    }

}
