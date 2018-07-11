package array;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/11 20:37
 */
public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(search(nums, 7));
    }

    public static boolean search(int[][] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return false;
        }

        boolean found = false;
        int rows = nums.length;
        int columns = nums[0].length;

        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {
            if (nums[row][column] == target) {
                found = true;
                break;
            } else if (nums[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }

        return found;
    }
}
