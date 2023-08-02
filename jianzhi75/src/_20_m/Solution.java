package _20_m;

/**
 * ClassName: Solution
 * Package: _20_m
 * Description:
 *      表示数值的字符串
 *      https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 *  结题方法：
 *      1、逻辑枚举
 *      2、有限状态自动机
 * @Author hylic
 * @Create 2023/6/30 21:20
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isNumber("1 "));
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.3 MB
     * , 在所有 Java 提交中击败了
     * 95.86%
     * 的用户
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        boolean hasSignFlag = false;
        boolean hasDotFlag = false;
        boolean hasEFlag = false;
        boolean hasNumFlag = false;
        int start;
        for (start = 0; start < s.length(); start++) {
            if(s.charAt(start) != ' ') break;
        }

        int i;
        for (i = start; i < s.length(); i = i+1) {
            if(s.charAt(i) == ' ') {
                break;
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                hasNumFlag = true;
            }
            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E' ){
                if(hasEFlag || !hasNumFlag){
                    return false;
                }
                hasEFlag = true;
                hasSignFlag = false;
                hasDotFlag = false;
                hasNumFlag = false;
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-' ){
                if(hasNumFlag || hasDotFlag || hasSignFlag){
                    return false;
                }
                hasSignFlag = true;
            }
            else if (s.charAt(i) == '.'){
                if(hasEFlag || hasDotFlag){
                    return false;
                }
                hasDotFlag = true;
            }
            else{
                return false;
            }
        }

        if (!hasNumFlag){
            return false;
        }


        // 中途有空格
        if (i != s.length()){
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(j) != ' ') return false;
            }
            return true;
        }
        else{
            return true;
        }
    }

}
