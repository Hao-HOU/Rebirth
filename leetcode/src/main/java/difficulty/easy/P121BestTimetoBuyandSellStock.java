package difficulty.easy;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/24 18:30
 */
public class P121BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            profit = Math.max(profit, prices[i] - min);
//            if (prices[i] < min) {
//                min = prices[i];
//            }
//        }

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }

        return profit;
    }
}
