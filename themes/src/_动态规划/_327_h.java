package _动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName: _327_h
 * Package: _动态规划
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/2 14:26
 * @Version 1.0
 */
public class _327_h {
    // 超出时间限制
    // 自己的思路
    public int countRangeSum(int[] nums, int lower, int upper) {
        Map<Long,Integer> map = new HashMap<Long,Integer>();
        long pre = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            pre = nums[i] + pre;
            for(long j = lower;j<=upper;j++){
                if(map.containsKey(pre-j)){
                    count += map.get(pre-j);
                }
            }
            map.put(pre, map.getOrDefault(pre,0)+1);
        }

        for(long j = lower;j<=upper;j++){
            if(map.containsKey(j)){
                count += map.get(j);
            }
        }
        return count;
    }

    /*
    思路：
    1. 用hashmap维护前缀和出现的值，再对每个前缀和遍历lower-upper，计算prenum -> 超时
    2. 看题解之后：用前缀和+归并排序
        a. 获得前缀和数组
        b. 给定一个无序数组，满足条件的前缀和=
            1.两个前缀和都在左半边的情况
            2.两个前缀和都在右半边的情况
            3.两个前缀和一左一右
        c. 两个半边分别排序之后不影响第三种情况的数量
    */
    public int countRangeSum2(int[] nums, int lower, int upper) {

        long[] prenum = new long[nums.length+1];
        prenum[0] = 0;
        for(int i=0;i<nums.length;i++){
            prenum[i+1] = prenum[i] + (long)nums[i];
        }
        return countRangeSumRecursive(prenum,0,prenum.length-1,lower,upper);
    }
    public int countRangeSumRecursive(long[] prenum, int left, int right, int lower, int upper){
        if(left==right) return 0;
        int mid = (left + right )/2;
        int countl = countRangeSumRecursive(prenum,left,mid,lower,upper);
        int countr = countRangeSumRecursive(prenum,mid+1,right,lower,upper);
        int res = 0;
        // 计算一左一右的情况，已排序
        int index = left;
        int l = mid+1;
        int r = mid+1;
        while(index<=mid){
            while(l <= right && prenum[l] - prenum[index]< lower){
                l++;
            }
            while(r <= right && prenum[r] - prenum[index] <= upper){
                r++;
            }
            res += r-l;
            index++;
        }

        // 随后合并两个排序数组
        long[] sorted = new long[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = (long) prenum[p2++];
            } else if (p2 > right) {
                sorted[p++] = (long) prenum[p1++];
            } else {
                if (prenum[p1] < prenum[p2]) {
                    sorted[p++] = (long) prenum[p1++];
                } else {
                    sorted[p++] = (long) prenum[p2++];
                }
            }
        }
        for (int j = 0; j < sorted.length; j++) {
            prenum[left + j] = sorted[j];
        }

        return res+countl+countr;
    }

}
