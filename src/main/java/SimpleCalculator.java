import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Jacob Ke
 * Update: 2016-6-9 22:32
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        double total = 2280.74;

        List<Double> prices = Lists.newArrayList(
                81.07,42.8,61.29,63.39,92.76,33.93,65.86, 46.85, 61.16, 68.51,47.74,55.81,52.98,70.42,37.35);

        simpleCalculate(total, prices);
    }

    public static void simpleCalculate(double total, List<Double> prices) {
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
