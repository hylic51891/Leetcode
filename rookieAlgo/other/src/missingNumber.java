/**
 * ClassName: missingNumber
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 21:46
 * @Version 1.0
 */
public class missingNumber {
    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%

     O(n) 常数空间
     */

    public int missingNumber(int[] nums) {
        int accum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            accum += nums[i];
        }
        return n*(n+1)/2 - accum;
    }

    /** 位运算，先全部异或，然后逐个异或，最后结果就是少的那个
    作者：力扣官方题解
    链接：https://leetcode.cn/problems/missing-number/solutions/1085105/diu-shi-de-shu-zi-by-leetcode-solution-naow/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int missingNumber2(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }


}
