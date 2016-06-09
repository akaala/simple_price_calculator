import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

/**
 * User: Jacob Ke
 * Update: 2016-6-9 23:17
 */
public class BetterCalculator {

    public static void main(String[] args) {
        String totalString = readInput("本程序可用于计算'不定方程的非负整数解问题'。\n首先，输入总价：");
        String pricesString = readInput("输入单价（用','分割）：");

        List<Double> prices = Lists.newArrayList();

        double total = Double.parseDouble(totalString);
        try {
            for (String s : Splitter.on(",").trimResults().splitToList(pricesString)) {
                prices.add(Double.parseDouble(s));
            }
        } catch (NumberFormatException e) {
            System.out.println("输入不是数字。退出！");
            System.exit(3);
        }

        System.out.println("总价为：" + total);
        System.out.println("各物品单价为：" + prices);
        System.out.println("计算开始……");

        List<List<Integer>> results = morePrice(prices, total);
        System.out.println("计算结束，可能的组合为：");

        for (List<Integer> result : results) {
            assert (result.size() == prices.size());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(prices.get(i)).append(" * ").append(result.get(i)).append(" + ");
            }
            sb.deleteCharAt(sb.length() - 1);sb.deleteCharAt(sb.length() - 1);
            sb.append(" = ").append(total);
            System.out.println(sb);
        }

        System.out.println("程序结束。");
        readInput("按任意键结束.\nCopyright By: Jacob Ke. Date: 2016-6-10");
    }

    public static List<List<Integer>> morePrice(List<Double> prices, double total) {
        List<List<Integer>> result = Lists.newArrayList();
        assert prices.size() >= 2;

        if (prices.size() == 2) {
            result = towPrice(prices.get(0), prices.get(1), total);
        } else {
            for (Double price : prices) {
                for (int count = 1; count <= total / price; count++) {
                    List<Double> newPrices = Lists.newArrayList(prices);

                    int removedIndex = newPrices.indexOf(price);
                    newPrices.remove(removedIndex);

                    double nextTotal = total - count * price;
                    List<List<Integer>> counters = morePrice(newPrices, nextTotal);

                    if (counters != null && counters.size() != 0) {
                        for (List<Integer> counter : counters) {
                            List<Integer> oneResult = Lists.newArrayList();
                            oneResult.addAll(counter);
                            oneResult.add(removedIndex, count);
                            result.add(oneResult);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> towPrice(double price1, double price2, double total) {
        List<List<Integer>> result = Lists.newArrayList();
        for (int c1 = 0; c1 <= total / price1; c1++) {
            for (int c2 = 0; c2 <= total / price2; c2++) {
                if (price1 * c1 + price2 * c2 == total) {
                    result.add(Lists.newArrayList(c1, c2));
                }
            }
        }
        return result;
    }

    private static String readInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
