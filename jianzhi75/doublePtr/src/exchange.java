/**
 * ClassName: exchange
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 15:36
 * @Version 1.0
 */
public class exchange {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int even = 0;
        int odd = n-1;
        int temp;
        while(even < odd){
            if(nums[even]%2 != 0){
                even++;
            }
            if(nums[odd]%2 != 1){
                odd--;
            }
            else{
                temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even++;
                odd--;
            }
        }
        return nums;
    }
    // TO
    public int[] exchange2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }
}
