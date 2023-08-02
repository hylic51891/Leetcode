package _动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: _560_m
 * Package: _动态规划
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/2 11:07
 * @Version 1.0
 */
public class _560_m {
    public static void main(String[] args) {
        System.out.println(new _560_m().subarraySum(new int[]{1,2,3},3));
        System.out.println(new _560_m().subarraySum(new int[]{1,1,1},2));
        System.out.println(new _560_m().subarraySum(new int[]{-1,-1,1},0));
        System.out.println(new _560_m().subarraySum(new int[]{-1,-1,1},1));

    }
    public int subarraySum(int[] nums, int k) {
        // 动态数组+hashset
        /**
         1. 动态数组维持前缀和
         2. hashMap存储动态数组，如果重复则value+1。看map中是否有前缀和-目标值的key，累加到count
         */
        Map map = new HashMap<Integer,Integer>();
        int count = 0;
        int pre = 0;
        for(int i= 0;i<nums.length;i++){
            pre = pre + nums[i];
            if(map.containsKey(pre-k)){
                count += (int)map.get(pre-k);
            }
            if(map.containsKey(pre)){
                map.put(pre,(int)map.get(pre)+1);
            }
            else{
                map.put(pre,1);
            }
        }
        // 最后检查是否有累加刚好为K的值
        if(map.containsKey(k)){
            count += (int)map.get(k);
        }
        return count;
    }
}
