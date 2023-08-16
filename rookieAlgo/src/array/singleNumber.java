package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ClassName: singleNumver
 * Package: rookieAlgo
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/7/31 23:56
 * @Version 1.0
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num:nums){
            if(set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }

        return (int)set.toArray()[0];
    }
    public int singleNumber2(int[] nums) {
        int res= 0;
        for (int num:
             nums) {
            res = res ^ num;
        }
        return res;
    }
}
