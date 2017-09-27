package Module3.ObjectsClasses.Lesson5;

import java.util.function.DoubleUnaryOperator;

class Integrate {
    static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-6;
        double res = 0;
        for (int i = 0; a + i*step < b ; i++) {
            res += f.applyAsDouble(a + i*step)*step;
        }
        return res;
    }
}
