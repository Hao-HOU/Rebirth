package difficulty.medium;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/26 12:23
 */
public class P064MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumInplace(grid));
    }

    // 先来一个额外创建对应大小数组的
    private static int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[][] sum = new int[grid.length][grid[0].length];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                sum[i][j] = grid[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }

        return sum[sum.length-1][sum[0].length-1];
    }

    // 直接在当前数组上
    private static int minPathSumInplace(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i-1];
        }

        for (int j = 1; j < grid.length; j++) {
            grid[j][0] += grid[j-1][0];
        }

        int temp = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                temp = grid[i][j];
                grid[i][j] = temp + Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }
}
