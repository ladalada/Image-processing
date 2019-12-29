package Lab1_Lab2;

public class Lab2_2_AutoCorrelationFunction {

    protected static double FirstWalshWavelet(double[] partOfAutoCorrelation) {

        double sum = 0;
        int len = partOfAutoCorrelation.length;

        for (int i = 0; i < len; i++) {

            sum += partOfAutoCorrelation[i];

        }

        return sum;

    }

    protected static double SecondWalshWavelet(double[] partOfAutoCorrelation) {

        double sum = 0;
        int len = partOfAutoCorrelation.length;

        for (int i = 0; i < len / 2; i++) {

            sum += partOfAutoCorrelation[i];

        }

        for (int i = len / 2; i < len; i++) {

            sum -= partOfAutoCorrelation[i];

        }

        return sum;

    }

    protected static double ThirdWalshWavelet(double[] partOfAutoCorrelation) {

        double sum = 0;
        int len = partOfAutoCorrelation.length;

        for (int i = 0; i < len / 4; i++) {

            sum += partOfAutoCorrelation[i];

        }

        for (int i = len / 4; i < 3 * len / 4; i++) {

            sum -= partOfAutoCorrelation[i];

        }


        for (int i = 3 * len / 4; i < len; i++) {

            sum += partOfAutoCorrelation[i];

        }

        return sum;

    }

    protected static void printWalshWavelets(double[] realAutoCorrelation, double[] imaginaryAutoCorrelation) {

        ForLabs.printComplexVector("The first Walsh wavelet is ",
                FirstWalshWavelet(realAutoCorrelation),
                FirstWalshWavelet(imaginaryAutoCorrelation));

        ForLabs.printComplexVector("The second Walsh wavelet is ",
                SecondWalshWavelet(realAutoCorrelation),
                SecondWalshWavelet(imaginaryAutoCorrelation));

        ForLabs.printComplexVector("The third Walsh wavelet is ",
                    ThirdWalshWavelet(realAutoCorrelation),
                    ThirdWalshWavelet(imaginaryAutoCorrelation));

    }

    public static void main(String[] args) {

        int dim = ForLabs.enterDimension();

        double[] a = ForLabs.enterVector(dim, "real", "first");
        double[] b = ForLabs.enterVector(dim, "imaginary", "first");
        ForLabs.loopCheck(a, b);

        ForLabs.printVector("first", a, b, dim);

        int dimCorrelation = dim;

        double[] realAutoCorrelation =
                Lab2_1_CrossCorrelationFunction.CorrelCalculation(dimCorrelation, a, b, a, b, ForLabs.ComplexPart.REAL);
        double[] imaginaryAutoCorrelation =
                Lab2_1_CrossCorrelationFunction.CorrelCalculation(dimCorrelation, a, b, a, b, ForLabs.ComplexPart.IMAGINARY);

        ForLabs.printComplexVector("Autocorrelation function of the vector contour is ",
                realAutoCorrelation, imaginaryAutoCorrelation, dimCorrelation);

        printWalshWavelets(realAutoCorrelation, imaginaryAutoCorrelation);

    }

}
