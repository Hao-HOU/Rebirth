package difficulty.easy;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/30 22:16
 */
public class P027RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        System.out.println(removeElement(nums, 3));
    }

    private static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int newLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != newLen) {
                    nums[newLen++] = nums[i];
                    nums[i] = val;
                } else {
                    newLen++;
                }
            }
        }

        return newLen;
    }
}
