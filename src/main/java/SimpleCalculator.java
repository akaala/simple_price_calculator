import java.util.ArrayList;
import java.util.List;

/**
 * User: Jacob Ke
 * Update: 2016-6-9 22:32
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        double total = 100;

        List<Double> prices = new ArrayList<>();
        prices.add(1D);
        prices.add(2D);
        prices.add(3D);
        prices.add(4D);


        for (Double price1 : prices) {
            for (Double price2 : prices) {
                calculateTwo(price1, price2, total);
            }
        }

        for (Double price1 : prices) {
            for (Double price2 : prices) {
                for (Double price3 : prices) {
                    calculateThree(price1, price2, price3, total);
                }
            }
        }
        for (Double price1 : prices) {
            for (Double price2 : prices) {
                for (Double price3 : prices) {
                    for (Double price4 : prices) {
                        calculateFour(price1, price2, price3, price4, total);
                    }
                }
            }
        }
    }

    private static void calculateTwo(double price1, double price2, double total) {
        int c1 = 1, c2 = 1;
        for (; c1 <= total / price1; c1++) {
            for (; c2 <= total / price2; c2++) {
                if (price1 * c1 + price2 * c2 == total) {
                    System.out.printf("%d * %f + %d * %f = %f \n",
                            c1, price1, c2, price2, total);
                }
            }
        }
    }

    private static void calculateThree(double price1, double price2, double price3,
                                       double total) {
        int c1 = 1, c2 = 1, c3 = 1;
        for (; c1 <= total / price1; c1++) {
            for (; c2 <= total / price2; c2++) {
                for (; c3 <= total / price3; c3++) {
                    if (price1 * c1 + price2 * c2 + price3 * c3 == total) {
                        System.out.printf("%d * %f + %d * %f + %d * %f = %f\n",
                                c1, price1, c2, price2, c3, price3, total);
                    }
                }
            }
        }
    }

    private static void calculateFour(double price1, double price2, double price3, double price4,
                                      double total) {
        int c1 = 1, c2 = 1, c3 = 1, c4 = 1;
        for (; c1 <= total / price1; c1++) {
            for (; c2 <= total / price2; c2++) {
                for (; c3 <= total / price3; c3++) {
                    for (; c4 <= total / price4; c4++) {
                        if (price1 * c1 + price2 * c2 + price3 * c3 + price4 * c4 == total) {
                            System.out.printf("%d * %f + %d * %f + %d * %f + %d * %f = %f\n",
                                    c1, price1, c2, price2, c3, price3, c4, price4, total);
                        }
                    }
                }
            }
        }
    }
}
