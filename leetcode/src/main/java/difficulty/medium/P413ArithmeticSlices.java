package difficulty.medium;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/27 08:14
 */
public class P413ArithmeticSlices {
    public static void main(String[] args) {

    }

    private static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int cur = 0;
        int count = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                cur++;
                count += cur;
            } else {
                cur = 0;
            }
        }

        return count;
    }
}
