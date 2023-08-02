package _2475_e;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Package: _2475_e
 * Description:
 *
 * @Author hylic
 * @Create 2023/6/13 17:27
 * @Version 1.0
 */
public class Solution {
    // 暴力求解
    public int unequalTriplets(int[] nums) {
        int count = 0;
        for(int i = 0;i< nums.length-2; i++){
            for(int j = i+1;j< nums.length-1; j++){
                if (nums[i] == nums[j]){
                    continue;
                }
                for(int k = j +1;k< nums.length; k++){
                    if (nums[i] != nums[k] && nums[j] != nums[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 进行排序：由于对于特定的不同数字的下标组合方式视为一种，可以进行排序之后再计算
     * 对于每种数字，可分为：比它小 n1个，一样大 n2个，比它大 n3个
     * 则对于把这个数字放在三个数字中间的情况有：n1*n2*n3
     */

    public int unequalTriplets2(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int count = 0;
        int length = nums.length;
        for(int i = 1; i < length;i++){
            // start记录上一个不同的下标
            // i记录当前不同的下标
            if(nums[i]!=nums[i-1]){
                count += (start)*(i -start)*(length -i);
                start = i;
            }
        }
        return count;
    }

    // 用hashmap存储，value存储数量，然后遍历value，从小到大。 n = value1+ value2+value3+ ...
    public int unequalTriplets3(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int ans = 0, a = 0;
        int n = nums.length;
        for (int b : cnt.values()) {
            int c = n - a - b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }
}
