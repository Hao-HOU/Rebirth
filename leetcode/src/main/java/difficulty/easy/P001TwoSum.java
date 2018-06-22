package difficulty.easy;

import java.util.HashMap;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/21 08:41
 */
public class P001TwoSum {
    public static void main(String[] args) {

    }

    // 最简单直接的办法，虽然提交通过了，但是数组大了耗时很大
//    private static int[] twoSum(int[] nums, int target) {
//        if (nums == null || nums.length <= 0) {
//            return null;
//        }
//        int[] result = new int[2];
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//
//        return result;
//    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (diff.get(nums[i]) != null) {
                ans[0] = diff.get(nums[i]);
                ans[1] = i;
                return ans;
            }
            diff.put(target - nums[i], i);
        }

        return ans;
    }
}
