import java.util.Arrays;

/**
 * ClassName: plusOne
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 19:32
 * @Version 1.0
 */
public class plusOne {
    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 86.72%
     * 的用户
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = length-1;
        for(int i = length-1;i>=0;i--){
            if(carry == i && digits[i]!=9){
                digits[i]+=1;
                break;
            }
            else{
                carry = i-1;
                digits[i]=0;
            }
        }
        if(carry == -1){
            int[] result = new int[length+1];
            result[0] = 1;
            System.arraycopy(digits,0,result,1,length);
            return result;
        }
        return digits;
    }
}
