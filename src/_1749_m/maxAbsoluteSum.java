package _1749_m;

/**
 * ClassName: maxAbsoluteSum
 * Package: _1749_m
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/8 15:52
 * @Version 1.0
 */
public class maxAbsoluteSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9};
        System.out.println(maxAbsoluteSum(nums));
    }

    /**
     动态规划：
     1.子问题：以nums[i]为结尾的子数组的和的最大值
     2.分析：dp[i]需要维护两个状态，最小值，最大值
     3.传递过程：
     如果nums[i]为正
     dp[i][0] = (0 或者 dp[i-1][0]+nums[i])的最小值
     dp[i][1] = dp[i-1][1]+nums[i]
     如果nums[i]为负
     dp[i][0] = (0 或者 dp[i-1][0]+nums[i])的最小值
     dp[i][1] = dp[i-1][1]+nums[i] >0 ? dp[i-1][1]+nums[i]:0;
     4.初始状态：
     dp[1][0] = (0 或 nums[0]）最小值
     dp[1][1] = (0 或 nums[0]）最大值
     */
    /**
     * 4ms 75.51%
     * 52.28 43.88%s
     */
    public static int maxAbsoluteSum(int[] nums) {
        int absMax = 0;
        int max= 0,min = 0;

//        if(nums.length == 1) return Math.abs(nums[0]);
//        if(nums[0] > 0){
//            max = nums[0];
//            min = 0;
//            absMax = nums[0];
//        }
//        else{
//            max = 0;
//            min = nums[0];
//            absMax = -nums[0];
//        }

        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                max = max + nums[i];
                min = (min + nums[i] < 0)?(min + nums[i]):0;
                absMax = (max > absMax)?max:absMax;
            }
            else{
                max = (max + nums[i] > 0)?(max + nums[i]):0;
                min = min + nums[i];
                absMax = (-min > absMax)?-min:absMax;
            }
        }
        return absMax;
    }

    /**
     * 前缀和：
     * 由于子数组和等于两个前缀和的差，那么取前缀和中的最大值与最小值，它俩的差就是答案
     * 如果最大值在最小值右边，那么算的是最大子数组和
     * 如果最大值在最小值左边，那么算的是最小子数组和的绝对值（相反数）
     *
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/solutions/2377930/liang-chong-fang-fa-dong-tai-gui-hua-qia-dczr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    /**
     * 1ms 100%
     * 52.1mb 54%
     */
    public static int maxAbsoluteSum2(int[] nums) {
        int s = 0,max = 0,min= 0;
        for (int i = 0; i < nums.length; i++) {
            s+=nums[i];
            if(s > max) max = s;
            else if(s < min) min = s;
        }
        return max-min;
    }
}
