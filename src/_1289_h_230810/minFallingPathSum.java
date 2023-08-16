package _1289_h_230810;

/**
 * ClassName: minFallingPathSum
 * Package: _1289_h_230810
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 15:00
 * @Version 1.0
 */

/**
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 */

/** 我的思路：动态规划
 * 从下往上动态规划，滚动数组，每个位置记录到达这个位置的最小和
 *  错误！不是相邻元素必须下边只差1
 */

/** 我的思路2：
 *  每一行记录最小值以及次最小值下标，每次必然可以选取其中一个加入
 *  动态规划:不行，有后效性，前面的选择会影响后面的选择,局部最优解不是全局最优解
 */

/** 我的思路3：
 *  从上往下动态规划，滚动数组，每个位置记录到达这个位置的非零偏移最小和
 *  子问题：到达当前[i][j]位置的最小和
 *  状态转移：上一层除[i-1][j]位置的最小和 + [i][j]位置元素
 *  初始状态：为当前元素
 */
public class minFallingPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {-73,61,43,-48,-36},
                {3,30,27,57,10},
                {96,-76,84,59,-15},
                {5,-49,76,31,-7},
                {97,91,61,-46,67}
        };
        int[][] grid2 = new int[][]{
                {2,2,1,2,2},
                {2,2,1,2,2},
                {2,2,1,2,2},
                {2,2,1,2,2},
                {2,2,1,2,2},
        };
        int[][] grid3 = new int[][]{
                {-37,51,-36,34,-22},
                {82,4,30,14,38},
                {-68,-52,-92,65,-85},
                {-49,-3,-77,8,-19},
                {-60,-71,-21,-62,-73},
        };
        System.out.println(minFallingPathSum4(grid3));
        System.out.println(minFallingPathSum3(grid3));
        System.out.println(minFallingPathSum4(grid));
        System.out.println(minFallingPathSum3(grid));
    }
    /** 我的思路2：
     *  每一行记录最小值以及次最小值下标，每次必然可以选取其中一个加入,动态规划
     *  思路是错的，假设
     *  a1,a2，i1为最小和，次最小和，最小和位置
     *  b1,b2,j1,j2为当前最小值，次最小值，和位置
     *  如果a1和b1可以确定最小和，a1和b2冲突，那么不能保证b2+a2是次最小和，可能是a1加上当前行的其他数
     */
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if(n==1) return grid[0][0];

        int min;
        int submin;
        int minIndex = -1;
        int subminIndex = -1;
        int[][] dp = new int[2][2];
        dp[0][0] = 0;   // 上一行的最小数字和
        dp[0][1] = -1;  // 上一行的最小数字和的列索引
        dp[1][0] = 0;   // 上一行的次最小数字和
        dp[1][1] = -1;

        int[] mins;
        for (int i = 0; i < n ; i++) {
            min = Integer.MAX_VALUE;
            submin = Integer.MAX_VALUE;
            minIndex = -1;
            subminIndex = -1;
            for (int j = 0; j < n; j++) {
                if(grid[i][j] < submin){
                    submin = grid[i][j];
                    subminIndex = j;
                    if(submin < min){
                        submin = min;
                        subminIndex = minIndex;
                        min = grid[i][j];
                        minIndex = j;
                    }
                }
            }
            if(dp[0][1] != minIndex){
                dp[0][0] += min;
                dp[0][1] = minIndex;
                dp[1][0] += submin;
                dp[1][1] = subminIndex;
            }
            else{
                dp[1][0] += min;
                dp[1][1] = minIndex;
                dp[0][0] += submin;
                dp[0][1] = subminIndex;
            }

        }

        return dp[0][0] < dp[1][0] ? dp[0][0]:dp[1][0];
    }

    /** 我的思路3：
     *  从上往下动态规划，滚动数组，每个位置记录到达这个位置的非零偏移最小和
     *  子问题：到达当前[i][j]位置的最小和
     *  状态转移：上一层除[i-1][j]位置的最小和 + [i][j]位置元素
     *  初始状态：为当前元素
     */
    public static int minFallingPathSum2(int[][] grid){
        int n = grid.length;
        if(n==1) return grid[0][0];
        int[] cur = grid[0].clone();
        int[] mins;
        for (int i = 1; i < n ; i++) {
            mins = rowMin(cur);
            for (int j = 0; j < n; j++) {
                if(j != mins[1]) cur[j] = mins[0]+grid[i][j];
                else cur[j] = mins[2]+grid[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(cur[i] < result) result = cur[i];
        }
        return result;
    }

    public static int[] rowMin(int[] row){
        int n = row.length;
        int min = Integer.MAX_VALUE;
        int submin = Integer.MAX_VALUE;
        int minIndex = -1;
        int subminIndex = -1;
        for (int j = 0; j < n; j++) {
            if(row[j] < submin){
                submin = row[j];
                subminIndex = j;
                if(submin < min){
                    subminIndex = minIndex;
                    submin = min;
                    min = row[j];
                    minIndex = j;
                }
            }
        }
        return new int[]{min,minIndex,submin,subminIndex};
    }



    /** 动态规划
     *  较为简单的逻辑：比较每个位置+上一个极小/次极小是不是当前行的最小值来记录
     *  1ms 100%
     *  47mb 80%
     */


    // 题解
    public static int minFallingPathSum3(int[][] grid) {
        int n = grid.length;
        int first_min_sum = 0;
        int second_min_sum = 0;
        int first_min_index = -1;

        for (int i = 0; i < n; i++) {
            int cur_first_min_sum = Integer.MAX_VALUE;
            int cur_second_min_sum = Integer.MAX_VALUE;
            int cur_first_min_index = -1;

            for (int j = 0; j < n; j++) {
                int cur_sum = (j != first_min_index ? first_min_sum : second_min_sum) + grid[i][j];
                if (cur_sum < cur_first_min_sum) {
                    cur_second_min_sum = cur_first_min_sum;
                    cur_first_min_sum = cur_sum;
                    cur_first_min_index = j;
                } else if (cur_sum < cur_second_min_sum) {
                    cur_second_min_sum = cur_sum;
                }
            }
            first_min_sum = cur_first_min_sum;
            second_min_sum = cur_second_min_sum;
            first_min_index = cur_first_min_index;
        }
        return first_min_sum;
    }
    // 自己写
    public static int minFallingPathSum4(int[][] grid) {
        int n = grid.length;
        int first_min_sum = 0;
        int second_min_sum = 0;
        int first_min_index = -1;

        int cur_first_min_sum;
        int cur_second_min_sum;
        int cur_first_min_index;
        int curSum;
        for (int i = 0; i < n; i++) {
            cur_first_min_sum = Integer.MAX_VALUE;
            cur_second_min_sum = Integer.MAX_VALUE;
            cur_first_min_index = -1;
            for (int j = 0; j < n; j++) {
                curSum = grid[i][j] + ((j != first_min_index)?first_min_sum:second_min_sum);
                if(cur_first_min_sum > curSum){
                    cur_second_min_sum = cur_first_min_sum;
                    cur_first_min_sum = curSum;
                    cur_first_min_index = j;
                }
                else if(cur_second_min_sum > curSum){
                    cur_second_min_sum = curSum;
                }
            }
            first_min_sum = cur_first_min_sum;
            second_min_sum = cur_second_min_sum;
            first_min_index = cur_first_min_index;
        }
        return first_min_sum;
    }


}
