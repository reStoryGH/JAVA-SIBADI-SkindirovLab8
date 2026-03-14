package academy.java.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class NumberOperations {

    // Запрещаем создание объектов класса
    private NumberOperations() {}

    /* 1 */
    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return null;
    }

    /* 2 */
    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps) {
                return i;
            }
        }
        return null;
    }

    /* 3 */
    public static Double calculateDensity(double weight, double volume, double min, double max) {
        double density = weight / volume;
        if (density >= min && density <= max) {
            return density;
        }
        return null;
    }

    /* 4 */
    public static Integer find(BigInteger[] array, BigInteger value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return null;
    }

    /* 5 */
    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        if (volume.compareTo(BigDecimal.ZERO) == 0) {
            return null;
        }
        BigDecimal density = weight.divide(volume, 1, RoundingMode.HALF_UP);
        if (density.compareTo(min) >= 0 && density.compareTo(max) <= 0) {
            return density;
        }
        return null;
    }

}