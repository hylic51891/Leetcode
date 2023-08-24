package _2_twoPtr;

/**
 * ClassName: moveZeroes
 * Package: _2_twoPtr
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/23 23:55
 * @Version 1.0
 */
public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
    }
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast]!=0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
