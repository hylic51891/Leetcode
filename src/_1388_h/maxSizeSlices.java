package _1388_h;

import java.util.Arrays;

/**
 * ClassName: maxSizeSlices
 * Package: _1388_h
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/18 0:58
 * @Version 1.0
 */
public class maxSizeSlices {
    /** 任意在3n个数里面选n个互不相邻的数
     动态规划：
     01背包问题的变种？
     选择n个间隔，使得总共加起来为3n,间隔必须大于1
     递推过程：
     dp(i,k) i表示当前的下标位置(已有容量)，k表示已经选的次数
     dp(i,k) = max(
     max(dp(j,k+1) + slices[i]) j<=i-2 ,
     max(dp(j,k)) j<=i-1
     )
     由于一直是取最大，则可以直接简化为
     dp(i,k) = max( dp(i-2,k-1) + slices[i],dp(i-1,k) )
     返回递推到i==3n k==n的情况
     初始条件：
     dp(i,0) = 0
     dp(i,1) = slices[i]

     */
    public static void main(String[] args) {
        int[] slices = new int[]{1,2,3,4,5,6};
        int[] slices2 = new int[]{8,9,8,6,1,1};
//        new maxSizeSlices().maxSizeSlices(slices);
        new maxSizeSlices().maxSizeSlices(slices2);
    }
    public int maxSizeSlices(int[] slices) {
        int[] v1 = new int[slices.length - 1];
        int[] v2 = new int[slices.length - 1];
        System.arraycopy(slices, 1, v1, 0, slices.length - 1);
        System.arraycopy(slices, 0, v2, 0, slices.length - 1);
        int ans1 = calculate(v1);
        int ans2 = calculate(v2);
        return Math.max(ans1, ans2);
    }

    public int calculate(int[] slices) {
        int len = slices.length;
        int choose = (len+1)/3;
        int[][] dp = new int[choose+1][len];
        Arrays.fill(dp[0],0);
        dp[1][0] = slices[0];
        dp[1][1] = Math.max(slices[0], slices[1]);
        for (int i = 1; i <= choose; i++) {
            for (int j = 2; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-2] + slices[j]);
            }
        }
        return dp[choose][len-1];
    }
}
