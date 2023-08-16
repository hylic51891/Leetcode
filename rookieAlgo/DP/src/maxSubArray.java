/**
 * ClassName: maxSubArray
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/7 23:41
 * @Version 1.0
 */
public class maxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,-1}));
        System.out.println(maxSubArray(new int[]{-1,-2}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    /** 我自己写的动态规划（然而并不是动态规划）用前缀和，然后对这个数组找最大和最小值
     *  2ms 44%
     *  53.5mb 64%
     */
    public static int maxSubArray(int[] nums) {
        /**
         * 连续子数组求最大的和，用前缀和数组，然后对这个数组找最大和最小值
         */
        int length = nums.length;
        if(length == 1) return nums[0];
        int[] prefix = new int[length+1];
        prefix[0] = 0;
        int maxNum = Integer.MIN_VALUE;
        int index = 0;
        int min = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            prefix[i+1] = prefix[i]+nums[i];
            if(nums[i]>maxNum) maxNum = nums[i];
            if (prefix[i] < min) {
                min = prefix[i];
                index = i;
            }
            if (index != i && maxValue < prefix[i] - min) maxValue = prefix[i] - min;
//            else if(maxValue < prefix[i]-min) maxValue = prefix[i]-min;
        }
        if (prefix[length] < min) {
            min = prefix[length];
            index = length;
        }
        if (index != length && maxValue < prefix[length] - min) maxValue = prefix[length] - min;
//        int index = 0;
//        int min = Integer.MAX_VALUE;
//        int maxValue = Integer.MIN_VALUE;
//        for (int i = 0; i < length+1; i++) {
//            if (prefix[i] < min) {
//                min = prefix[i];
//                index = i;
//            }
//            if (index != i && maxValue < prefix[i] - min) maxValue = prefix[i] - min;
//        }
        if(maxValue == Integer.MIN_VALUE){  //一直往下
            return maxNum;
        }
        return maxValue;
    }

    /** 题解中的动态规划    O(N)
     * 无后效性：已经求解的子问题不受后续结果的影响
     *  1. 定义子问题：以nums[i]结尾的子串的最大和是多少？
     *  2. 任意i的状态：用dp[i]来表示最大和，必定包含nums[i]
     *      1. nums[i]为正，则dp[i] = dp[i-1] + nums[i]
     *      2. nums[i]为负，dp[i] = max(dp[i-1] + nums[i],nums[i]) 看那个大
     *      则可以总结为dp[i] = max(dp[i-1] + nums[i],nums[i])
     *  3. 初始状态：dp[0]表示以nums[0]结尾子串的最大和
     *  3. 题目求解的是dp数组中最大的结果
     */
    /**
     * 1ms 100%
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = (dp[i-1] + nums[i] > nums[i])?(dp[i-1] + nums[i]):(nums[i]);
            if(max < dp[i]) max = dp[i];
        }
        return max;
    }

    /**
     * 2的优化版，滚动数组替代dp数组 O(N)
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums){
        int lastMax;
        lastMax = nums[0];
        int max = lastMax;
        for (int i = 1; i < nums.length; i++) {
            lastMax = (lastMax + nums[i] > nums[i])?(lastMax + nums[i]):(nums[i]);
            if(max < lastMax) max =lastMax;
        }
        return max;
    }

    /**
     * 分治法：3种情况，子串在左半边，子串在右半边，子串包括中点 O(NlogN)
     * 17ms 5%
     */
    public static int maxSubArray4(int[] nums) {
        return maxSubArrayHelper(nums,0,nums.length-1);
    }
    public static int maxSubArrayHelper(int[] nums,int left,int right) {
        if(left==right){
            return nums[left];
        }

        int mid = left+(right-left)/2;
        int leftMax = maxSubArrayHelper(nums,left,mid);
        int rightMax = maxSubArrayHelper(nums,mid+1,right);

        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }


        return Math.max(leftSum + rightSum, Math.max(leftMax, rightMax));
    }
}
