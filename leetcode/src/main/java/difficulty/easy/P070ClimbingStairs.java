package difficulty.easy;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/26 10:35
 */
public class P070ClimbingStairs {
    public static void main(String[] args) {

    }

    private static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }
}
