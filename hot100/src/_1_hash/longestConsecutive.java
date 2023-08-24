package _1_hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: longestConsecutive
 * Package: _1_hash
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/22 16:49
 * @Version 1.0
 */
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int curLen = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]+1) curLen++;
            else if(nums[i] == nums[i-1]) continue;
            else{
                max = (max>curLen)?max:curLen;
                curLen = 1;
            }
        }
        return max;
    }
    // 最巧妙的hashmap
    public int longestConsecutive2(int[] nums) {
        // key表示num，value表示num所在连续区间的长度
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // 当map中不包含num，也就是num第一次出现
            if (!map.containsKey(num)) {
                // left为num-1所在连续区间的长度，更进一步理解为：左连续区间的长度
                int left = map.getOrDefault(num - 1, 0);
                // right为num+1所在连续区间的长度，更进一步理解为：右连续区间的长度
                int right = map.getOrDefault(num + 1, 0);
                // 当前连续区间的总长度
                int curLen = left + right + 1;
                ans = Math.max(ans, curLen);
                // 将num加入map中，表示已经遍历过该值。其对应的value可以为任意值。
                map.put(num, -1);
                // 更新当前连续区间左边界和右边界对应的区间长度
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return ans;
    }
}
