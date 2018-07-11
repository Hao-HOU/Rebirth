package difficulty.easy;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/25 15:29
 */
public class P053MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Pro: " + maxSubArrayPro(nums));
        System.out.println("Iter: " + maxSubArrayIter(nums));
        System.out.println("Kadane: " + maxSubArrayKadane(nums));

    }

    // 可行，但会超时。另一个循环方式的写法见下面。
    private static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int ws = 1; ws <= nums.length; ws++) {
            for (int i = 0; i <= nums.length - ws; i++) {
                int sum = 0;
                for (int j = 0; j < ws; j++) {
                    sum += nums[j+i];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    private static int maxSubArrayIter(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            // increment
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//
//                maxSum = Math.max(sum, maxSum);
//            }

            // decrement
            for (int j = i; j >= 0; j--) {
                sum += nums[j];

                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    private static int maxSubArrayPro(int[] nums) {
        int[] sumIndex = new int[nums.length];
        sumIndex[0] = nums[0];
        int maxSum = sumIndex[0];
        for (int i = 1; i < nums.length; i++) {
            sumIndex[i] = nums[i] + (sumIndex[i-1] > 0 ? sumIndex[i-1] : 0);
            maxSum = Math.max(maxSum, sumIndex[i]);
        }

        return maxSum;
    }

    private static int maxSubArrayKadane(int[] nums) {
        int result = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(nums[i], nums[i] + maxSum);
            result = Math.max(result, maxSum);
        }

        return result;
    }
}
