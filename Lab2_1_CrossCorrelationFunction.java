package Lab1_Lab2;

import java.util.Arrays;

public class Lab2_1_CrossCorrelationFunction {

    protected static double[] CorrelCalculation(int dimCorrelation,
                                                double[] a, double[] b, double[] c, double[] d,
                                                ForLabs.ComplexPart part) {

        int dim = a.length;
        double[] CrossCorrelation = new double [dimCorrelation];

        for (int i = 0; i < dimCorrelation; i++) {

            double[] cMoved = ForLabs.moveRight(c, i);
            double[] dMoved = ForLabs.moveRight(d, i);

            switch (part) {

                case REAL:
                    CrossCorrelation[i] = ForLabs.realScalarProduct(dim, a, b, cMoved, dMoved);
                    break;

                case IMAGINARY:
                    CrossCorrelation[i] = ForLabs.imaginaryScalarProduct(dim, a, b, cMoved, dMoved);
                    break;

            }

        }

        return CrossCorrelation;

    }

    public static void main(String[] args) {

        int dim = ForLabs.enterDimension();

        double[] a = ForLabs.enterVector(dim, "real", "first");
        double[] b = ForLabs.enterVector(dim, "imaginary", "first");
        ForLabs.loopCheck(a, b);

        double[] c = ForLabs.enterVector(dim, "real", "second");
        double[] d = ForLabs.enterVector(dim, "imaginary", "second");
        ForLabs.loopCheck(c, d);

        ForLabs.printVector("first", a, b, dim);
        ForLabs.printVector("second", c, d, dim);

        int dimCorrel = dim;

        double[] realCrossCorrelation = CorrelCalculation(dimCorrel, a, b, c, d, ForLabs.ComplexPart.REAL);
        double[] imagCrossCorrelation = CorrelCalculation(dimCorrel, a, b, c, d, ForLabs.ComplexPart.IMAGINARY);

        ForLabs.printComplexVector("Cross-correlation function of vector contours is ",
                realCrossCorrelation, imagCrossCorrelation, dimCorrel);

        double modulesProduct = ForLabs.complexVectorModule(a, b) * ForLabs.complexVectorModule(c, d);

        double[] possibleMaxCorrelModule = new double[dimCorrel];
        double[] possibleMaxRealCorrel = new double[dimCorrel];
        double[] possibleMaxImagCorrel = new double[dimCorrel];

        double maxCorrelModule = -2;
        double maxRealCorrel = -2;
        double maxImagCorrel = -2;

        for (int i = 0; i < dimCorrel; i++) {

          if (modulesProduct != 0) {

              possibleMaxRealCorrel[i] = realCrossCorrelation[i] * (1.0 / modulesProduct);
              possibleMaxImagCorrel[i] = imagCrossCorrelation[i] * (1.0 / modulesProduct);
              possibleMaxCorrelModule[i] =
                      ForLabs.complexVectorModule(possibleMaxRealCorrel[i], possibleMaxImagCorrel[i]);

          }

          if (possibleMaxCorrelModule[i] > maxCorrelModule) {

              maxCorrelModule = possibleMaxCorrelModule[i];
              maxRealCorrel = possibleMaxRealCorrel[i];
              maxImagCorrel = possibleMaxImagCorrel[i];

          }

        }

        ForLabs.printComplexVector("Max cross-correlation function is ", maxRealCorrel, maxImagCorrel);
        System.out.println("The similarity measure of the contours is " + maxCorrelModule);
        System.out.println("The angle of rotation of the contours is "
                + Math.toDegrees(Math.acos(maxRealCorrel / ForLabs.complexVectorModule(maxRealCorrel, maxImagCorrel)))
                + " degrees");

        System.out.println("\n\n Check: ");
        System.out.println("\n possibleMaxCorrelModule: \n" + Arrays.toString(possibleMaxCorrelModule));
        System.out.println("\n possibleMaxRealCorrel \n" + Arrays.toString(possibleMaxRealCorrel));
        System.out.println("\n possibleMaxImagCorrel \n" + Arrays.toString(possibleMaxImagCorrel));

    }

}
