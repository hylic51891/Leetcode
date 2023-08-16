import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * ClassName: shuffle
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/8 16:39
 * @Version 1.0
 */
public class shuffle {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle1();
        System.out.println();
    }
}
class Solution {
    int[] nums;
    int[] shuffle;
    public Solution(int[] nums) {
        this.nums = nums;
        shuffle = new int[nums.length];
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle1() {
        int length = nums.length;
        int[] res = new int[length];
        HashSet<Integer> used = new HashSet<>();
        int rand;
        int index = 0;
        while(index < length){
            rand = (int)(length * Math.random());
            if(!used.contains(rand)){
                res[index] = nums[rand];
                used.add(rand);
                index++;
            }
        }
        return res;
    }

    public int[] shuffle2() {
        int[] shuffled = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
        }
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(list.size());
            shuffled[i] = list.remove(j);
        }
        System.arraycopy(shuffled, 0, shuffle, 0, nums.length);
        return shuffle;
    }
}

/** 洗牌算法
 *
 */
class Solution2 {
    int[] nums;
    int[] original;
    Random random;
    public Solution2(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
        random = new Random();

    }

    public int[] reset() {
        return original;
    }

    /**
     * 递减，交换数组中的对应位置，这样子0位已乱序，可以不用遍历到
     * @return
     */
    public int[] shuffle() {
        for (int i = nums.length-1; i > 0; --i) {
            int j = i - random.nextInt(i+1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}