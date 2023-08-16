/**
 * ClassName: hammingWeight
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 19:43
 * @Version 1.0
 */
public class hammingWeight {
    // you need to treat n as an unsigned value

    /**
     * 1ms 9%
     * 38.2mb 92%
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        String bits = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < bits.length(); i++) {
            if(bits.charAt(i) == '1') count++;
        }
        return count;
    }

    /**
     * 题解1 每一位进行与运算
        0ms 100%    O(K=32)
     */
    public int hammingWeight2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if((n & (1<<i))!=0) ret++;
        }
        return ret;
    }
    /**
     * 题解2 用n & n-1的逻辑
     0ms 100%  O(logN)
     */
    public int hammingWeight3(int n) {
        int ret = 0;
        while(n!=0){
            n = n & n-1;    // 和自身-1进行与运算，即把最低位的1变为0
            ret++;
        }
        return ret;
    }
}

// related question 477_m
class totalHammingDistance{
    public static void main(String[] args) {
        int[] nums = new int[]{4,14,2};
        System.out.println(totalHammingDistance(nums));
    }

    /**
     * 我的思路
     * 17ms 43%
     */
    public static int totalHammingDistance(int[] nums) {
        int length = nums.length;
        int countOne;
        int sum = 0;
        for(int i = 0;i< 32;i++){
            countOne = 0;
            for(int j=0;j<length;j++){
                if((nums[j] & (1 << i)) != 0) countOne++;
            }
            sum += countOne*(length-countOne);
        }
        return sum;
    }

    /**
     * 换种写法
     3ms 100%
     */
    public static int totalHammingDistance2(int[] nums) {
        int countOne;
        int sum = 0;
        for(int i = 0;i< 30;i++){
            countOne = 0;
            for(int j=0;j<nums.length;j++){
                countOne += (nums[j]>>i) & 1;
            }
            sum += countOne*(nums.length-countOne);
        }
        return sum;
    }
}
