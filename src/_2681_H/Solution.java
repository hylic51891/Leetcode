package _2681_H;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Solution
 * Package: _2681_H
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/2 0:16
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(sumOfPower(new int[]{1705,7581,5816,8226,3173,2381,9562,5447,8770,2247,2106,6925,4347,4651,3785,7013,4826,1260,9151,5321,6521,2984,2553,6035,4095,9021,8296,7682,4071,2830,4182,1994,9222,5343,6826,330,8214,5657,425,7030,9074,4016,1393,4598,9563,2811,9156,9399,140,5627,6590,9980,6620,2461,6213,3966,301,6254,8024,3508,2979,1707,4293,3789,7349,728,5802,4223,2195,9914,2294,2551,8221,3807,3860,4967,2506,3086,7531,6922,8546,5636,6249}));
        System.out.println(sumOfPower(new int[]{1919,5771,7490,9601,4565,4903,5916,5022,701,651,7153,2845,82,8371,6563,4269,4611,8402,3873,2137,9654,5438,7557,9741,4502,4227,3807,3638,5399,5863,8076,1079,1455,3431,4466,4023,7900,168,6522,2883,7545,2117,4201,5805,7011,8747,9592,616,8938,8080,9576,8010,4030,7969,9109,4440,3836,7411,6265,7505,3161,862,781,3798,4888,7316,1718,6894,2018,524,1149,8260,2242,6429,7221,2881,3829,8594,6049,1915,9983,3735,8808,1152,6818,3272,9035,8419,4333,2146,4237,9715,9129,399,6944,3779,3346,8857}));
    }
    // 超出时间限制
    public static int sumOfPower(int[] nums) {
        /*
        1.排序，设最大数量为n
        2.最小值为j位置的时候，第i个数为最大的次数是1+C(1)(i-j-1)+...+C(i-j-1)(i-j-1)=2^(i-j-1)
        4.最大指针，最小指针

        */
        final int MOD = (int)1e9 + 7;
        Arrays.sort(nums);
        int sum = 0;
        long time = 1;
        int t = 0;
        int r = 0;
        long max = 0;
        long add = 0;
        // 1,1,1
        for(int i=0;i<nums.length;i++){
            sum = (int)((sum + ((long)nums[i]% MOD*nums[i]% MOD*nums[i]% MOD)%MOD) % MOD);
            if(sum < 0){
                sum += MOD;
            }
            for(int j = i+1;j<nums.length;j++){
                time = 1;
                t = (int)((j-i-1)/30.0);
                r = (int)((j-i-1)%30);
                if(t!=0){
                    for(int k=0;k<t;k++){
                        time = (time * (long)Math.pow(2,30)% MOD) % MOD ;
                    }
                }
                time = (time * (long)Math.pow(2,r)% MOD) % MOD;
                max = (long)nums[j]*nums[j]% MOD;
                add = (long)max*nums[i]% MOD;
                sum = (int)((sum + add*time% MOD)% MOD);
                if(sum < 0){
                    sum += MOD;
                }
            }
        }
        return sum;
    }
    // 我的解释+最后答案
    public static int sumOfPower2(int[] nums) {
        /*
        1.排序，设最大数量为n
        2.最小值为j位置的时候，第i个数为最大的次数是1+C(1)(i-j-1)+...+C(i-j-1)(i-j-1)=2^(i-j-1)，但是计算最小值之和需要遍历之前的所有，算法时间复杂度为O(N^2)

        1.也就是说最大值为位置i的时候，最小值之和可以分为（i-1的最小值之和+位置i为最小值）
        2.最小值之和=前一个最小值之和+当前位置的值
        3.第一个元素的最小值之和是第一个元素的值+0
        4.用动态规划来维护最小值之和，同时用前缀和来简化操作

        */
        final int MOD = (int)1e9 + 7;
        int sum = 0;
        int dp = 0, presum = 0;

        Arrays.sort(nums);
        // 1,1,1
        for(int i=0;i<nums.length;i++){
            dp = (nums[i]+presum) % MOD;
            presum = (dp+presum) % MOD;
            sum = (int)(sum + (long)nums[i]*nums[i]%MOD*dp %MOD) %MOD;
            if(sum<0){
                sum += MOD;
            }
        }
        return sum;
    }

}
