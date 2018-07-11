package difficulty.easy;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/24 17:53
 */
public class P198HouseRobber {
    public static void main(String[] args) {

    }

    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[1], nums[0] + nums[2]);
        }

        int rob = 0;
        int pre2 = Math.max(nums[0], nums[1]);
        int pre1 = Math.max(nums[1], nums[0] + nums[2]);
        for (int i = 3; i < nums.length; i++) {
            rob = Math.max(nums[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = rob;
        }

        return rob;
    }

    // 可以进一步优化
    private static int robPro(int[] nums) {
        int a = 0;
        int b = 0;
        int temp = 0;
        for (int i : nums) {
            temp = b;
            b = Math.max(a + i, b);
            a = temp;
        }
        return b;
    }
}
