package array;

import java.util.HashSet;

/**
 * ClassName: array.moveZeros
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 19:47
 * @Version 1.0
 */
public class moveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int num:
                nums) {
            System.out.print(num);
            System.out.print(",");
        }
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 32.20%
     * 的用户
     * 内存消耗：
     * 44 MB
     * , 在所有 Java 提交中击败了
     * 46.29%
     * 的用户
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        /** 我的思路：
         * 1. 双指针：一个指向最前面的0，一个指向这个0后面的第一个数，然后swap
         *      * 结束条件，数的指针超出数组范围
         */
        int length = nums.length;
        if(length == 0 || length == 1) return;
        int zeroIndex = 0;
        int digitIndex = 0;
        while(zeroIndex < length && digitIndex < length){
            if(nums[zeroIndex]!=0){
                zeroIndex++;
            }
            else if (nums[digitIndex]==0) {
                digitIndex++;
            }
            else if(zeroIndex > digitIndex){
                digitIndex = zeroIndex + 1;
            }
            else {
                // 双指针：一个指向最前面的0，一个指向这个0后面的第一个数
                nums[zeroIndex++] = nums[digitIndex];
                nums[digitIndex++] = 0;
            }

        }
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 44 MB
     * , 在所有 Java 提交中击败了
     * 51.37%
     * 的用户
     * @param nums
     */
    public static void moveZeroes2(int[] nums){
        int length = nums.length;
        if(length == 0 || length == 1) return;
        int zeroCount = 0;
        for(int j=0;j<length;j++){
            if(nums[j]==0) zeroCount++;
            else if(zeroCount!=0){
                nums[j-zeroCount] = nums[j];
                nums[j] = 0;
            }
        }
    }
    /**
     * 把非0的往前挪，挪完之后，后面的就都是0了，然后在用0覆盖后面的。
     */
    public static void moveZeroes3(int[] nums){

        if (nums == null || nums.length == 0)
            return;
        int index = 0;
        //一次遍历，把非零的都往前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        //后面的都是0,
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
