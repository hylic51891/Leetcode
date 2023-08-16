/**
 * ClassName: myAtoi
 * Package: String
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 14:35
 * @Version 1.0
 */
public class myAtoi_m {
    public static void main(String[] args) {
        String s = "      -765474 ";
        System.out.println(myAtoi(s));
    }
    /** 1.有限状态向量机？好像不需要
     *  2. 按照流程走
     *执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.2 MB
     * , 在所有 Java 提交中击败了
     * 93.12%
     * 的用户
     */
    public static int myAtoi(String s) {
        char[] trim = s.trim().toCharArray();
        boolean positive;
        int length = trim.length;
        if(length ==0) return 0;
        int index = 0;
        if(trim[0] == '-'){
            positive = false;
            index = 1;
        }
        else if(trim[0] == '+'){
            positive = true;
            index = 1;
        }
        else{
            positive = true;
        }
        long num = 0;
        while(index<length){
            if(trim[index] >= '0' && trim[index] <= '9'){
                num = num*10 + trim[index]-'0';
                if(positive && num > Integer.MAX_VALUE){
                    return  Integer.MAX_VALUE;
                }
                if(!positive && -num < Integer.MIN_VALUE){
                    return  Integer.MIN_VALUE;
                }
                index++;
            }
            else{
                break;
            }
        }
        return (int)num*((positive)?(1):(-1));
    }

    public static int myAtoi2(String s) {
        char[] trim = s.trim().toCharArray();
        boolean positive;
        int length = trim.length;
        if(length ==0) return 0;
        int index = 0;
        if(trim[0] == '-'){
            positive = false;
            index = 1;
        }
        else if(trim[0] == '+'){
            positive = true;
            index = 1;
        }
        else{
            positive = true;
        }
        int num = 0;
        while(index<length){
            if(trim[index] >= '0' && trim[index] <= '9'){
                if(positive && num > (Integer.MAX_VALUE - (trim[index]-'0'))/10){
                    return  Integer.MAX_VALUE;
                }
                if(!positive && -num < (Integer.MIN_VALUE + (trim[index]-'0'))/10){
                    return  Integer.MIN_VALUE;
                }
                num = num*10 + trim[index]-'0';
                index++;
            }
            else{
                break;
            }
        }
        return num*((positive)?(1):(-1));
    }
}
