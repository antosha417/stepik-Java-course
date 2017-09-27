package Module3.ObjectsClasses.Lesson4;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object object) {
        return this == object ||
                object instanceof ComplexNumber &&
                        (Math.abs(re - ((ComplexNumber) object).re) < Math.ulp(re)) &&
                        (Math.abs(im - ((ComplexNumber) object).im) < Math.ulp(im));
    }

    @Override
    public int hashCode() {
        return (int) (re + im);
    }
}