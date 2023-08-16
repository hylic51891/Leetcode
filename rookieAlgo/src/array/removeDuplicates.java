package array;

/**
 * ClassName: array.removeDuplicates
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 20:39
 * @Version 1.0
 */
public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums= new int[]{1,1,1,1,1,3,3,4,5,6,6,7,8,9};
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                if(nums[i]!=nums[i-1]){
                    nums[count++] = nums[i];
                }
            }
        }
        return count;
    }
}
