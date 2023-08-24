import java.util.HashMap;

/**
 * ClassName: singleNumber
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/20 19:38
 * @Version 1.0
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        int num = 0;
        HashMap<Integer,Integer> map = new  HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])!=3) num = num ^ nums[i];
        }
        return num;
    }
}
