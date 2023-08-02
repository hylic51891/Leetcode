package rookieAlgo;

import java.util.*;

/**
 * ClassName: twoSum
 * Package: rookieAlgo
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/7/31 23:24
 * @Version 1.0
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[]{0,0};
        for(int i = 0;i< nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
