package _2_twoPtr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: threeSum
 * Package: _2_twoPtr
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/24 0:18
 * @Version 1.0
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            if(nums[i]>0){
                return ret;
            }
            if(i>0 && nums[i]==nums[i-1]) continue;

            int left = i+1;
            int right = n-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    ret.add(cur);
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }
                else{
                    left++;
                }
            }

        }
        return ret;
    }

}
