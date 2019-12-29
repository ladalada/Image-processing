package Lab1_Lab2;

public class Lab1_ContoursScalarProduct {

    protected static void scalarProduct(double[] a, double[] b, double[] c, double[] d) {

        int dim = a.length;

        if(b.length == dim && c.length == dim && d.length == dim) {

            double real = ForLabs.realScalarProduct(dim, a, b, c, d);
            double imaginary = ForLabs.imaginaryScalarProduct(dim, a, b, c, d);

            System.out.println("The scalar product of vector contours is ");
            System.out.println(real + " + i * " + imaginary);

        }
        else {

            ForLabs.calculationError();

        }

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

        scalarProduct(a, b, c, d);

    }

}

