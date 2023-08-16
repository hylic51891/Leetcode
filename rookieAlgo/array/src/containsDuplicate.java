import java.util.Arrays;
import java.util.HashSet;

/**
 * ClassName: array.containsDuplicate
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 20:32
 * @Version 1.0
 */
public class containsDuplicate {
    /** 我的思路：hashset存储，add失败即有重复，返回true
     *执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 71.70%
     * 的用户
     * 内存消耗：
     * 54.5 MB
     * , 在所有 Java 提交中击败了
     * 50.89%
     * 的用户
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet<Integer>();
        for(int i = 0;i< nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }

        }
        return false;
    }

    /**
     * 先排序，如果前后有相同，则返回true
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for(int i = 0;i< nums.length-1;i++){
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}
