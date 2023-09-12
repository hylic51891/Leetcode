package _228_e_20230826;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: summaryRanges
 * Package: _228_e_20230826
 * 228. 汇总区间
 * https://leetcode.cn/problems/summary-ranges/
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/26 16:34
 * @Version 1.0
 */
public class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int len = nums.length;
        int left = 0;
        int right = 0;
        while(right < len){
            left = right;
            right++;
            while(right < len && nums[right]==nums[right-1]+1) right++;
            StringBuilder temp = new StringBuilder();
            temp.append(nums[left]);
            if(left != right - 1){
                temp.append("->").append(nums[right - 1]);

            }
            res.add(temp.toString());
        }

        return res;
    }
    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        int len = nums.length;
        // 特殊情况
        if(len == 0) return res;
        else if(len == 1){
            res.add(Integer.toString(nums[0]));
            return res;
        }

        int left = 0;
        int right = 1;
        int curNum = nums[0];
        while(right < nums.length){

            if(nums[right] != nums[right-1]+1){
                StringBuilder temp = new StringBuilder();
                temp.append(nums[left]);
                if(left != right - 1){
                    temp.append("->").append(nums[right - 1]);

                }
                res.add(temp.toString());
                left = right;
            }
            right++;

        }
        StringBuilder temp = new StringBuilder();
        temp.append(nums[left]);
        if(left != right - 1){
            temp.append("->").append(nums[right - 1]);

        }
        res.add(temp.toString());

        return res;
    }
}
