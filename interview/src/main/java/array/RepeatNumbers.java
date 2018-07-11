package array;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/11 19:57
 */
public class RepeatNumbers {
    // 返回数组中任意一个重复的数字
    // 数组中的值在 0 ~ 数组长度-1 之间
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 0, 2, 5, 3};
//        System.out.println("重复数字：" + getRepeatNum(nums));

        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println("不改变数组找到的重复数字：" + getRepeatNumWhithoutModifyArray(nums));
    }

    public static int getRepeatNum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;// 假设数组中不包含 -1
        }

        for (int num : nums) {
            if (num < 0 || num > nums.length - 1) {
                return -1;
            }
        }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }

            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }

        return -1;// 无重复数字
    }

    /**
     * 数组长度为 n+1, 其中的数在 1~n 之间，返回任意一个重复出现的数字，不改变原数组
     * @param nums
     * @return 重复数字
     */
    public static int getRepeatNumWhithoutModifyArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = countNums(nums, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int countNums(int[] nums, int start, int end) {
        if (nums == null) {
            return 0;
        }

        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end) {
                count++;
            }
        }

        return count;
    }
}
