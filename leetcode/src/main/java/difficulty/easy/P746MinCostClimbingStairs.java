package difficulty.easy;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/26 11:07
 */
public class P746MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 25, 20};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairsPro(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int a = cost[0];
        int b = cost[1];
        int res = 0;
        for (int i = 2; i < cost.length - 1; i++) {
            res = cost[i] + Math.min(a, b);
            a = b;
            b = res;
        }

        return Math.min(b, a + cost[cost.length - 1]);
    }

    private static int minCostClimbingStairsPro(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int a = 0;
        int b = 0;
        int res = 0;
        for (int i : cost) {
            b = a;
            a = i + res;
            res = Math.min(a, b);
        }

        return res;
    }
}
