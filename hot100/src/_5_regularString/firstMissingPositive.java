package _5_regularString;

/**
 * ClassName: firstMissingPositive
 * Package: _5_regularString
 * Description:
 *  41. 缺失的第一个正数
 *  https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 * @Author hylic
 * @Create 2023/8/24 23:40 done 00:07
 * @Version 1.0
 */
public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1]!= nums[i] ) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
