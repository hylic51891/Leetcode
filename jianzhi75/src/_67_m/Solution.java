package _67_m;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Package: _67_m
 * Description:
 *      把字符串转换成整数
 *      1.逻辑直接if
 *      2.有限状态自由机
 * @Author hylic
 * @Create 2023/6/30 22:31
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strToInt2(" -42"));
    }

    /** 自己做的
     *
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.2 MB
     * , 在所有 Java 提交中击败了
     * 85.56%
     * 的用户
     * @param str
     * @return
     */
    public int strToInt(String str) {
        int start = 0;
        while(start < str.length() && str.charAt(start)==' '){
            start++;
        }
        // 全都是空格 或者 为空
        if (start == str.length()){
            return 0;
        }

        boolean negetive = false;
        int num  = 0;
        if(str.charAt(start) == '+' || str.charAt(start) == '-' || (str.charAt(start) >= '0' && str.charAt(start) <= '9')){
            if (str.charAt(start) == '-'){
                negetive = true;
            }
            else if ( str.charAt(start) == '+'){
                negetive = false;
            }
            else{
                num = num*10 + str.charAt(start)-'0';
            }
        }
        else {
            return 0;
        }

        for (int i = start+1; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){

                if(negetive){
                    if (-num < (Integer.MIN_VALUE+(str.charAt(i)-'0'))/10.0){
                        return Integer.MIN_VALUE;
                    }
                    num = num*10 + str.charAt(i)-'0';
                }
                else{
                    if (num > (Integer.MAX_VALUE-(str.charAt(i)-'0'))/10.0){
                        return Integer.MAX_VALUE;
                    }
                    num = num*10 + str.charAt(i)-'0';
                }

            }
            else
                break;
        }

        if( negetive){
            return -num;
        }
        else{
            return num;
        }

    }

    /** 有限状态自动机实现
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 20.86%
     * 的用户
     * 内存消耗：
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 41.64%
     * 的用户
     * @param str
     * @return
     */
    public int strToInt2(String str) {
        Automation automation = new Automation();
        int start = 0;
        while(start < str.length() && str.charAt(start)==' '){
            start++;
        }
        // 全都是空格 或者 为空
        if (start == str.length()){
            return 0;
        }
        for (int i = start; i < str.length(); i++) {
            automation.updateState(str.charAt(i));
            if(automation.ans == Integer.MAX_VALUE || -automation.ans == Integer.MIN_VALUE){
                return (int)(automation.sign*automation.ans);
            }
            else if(automation.isEnd()){
                return (int) (automation.sign*automation.ans);
            }
        }
        return (int) (automation.sign*automation.ans);
    }
}

class Automation{
    /**         空格      符号      数字      其他
     *  start   start    sign    number     end
     *  sign    end     end     number      end
     *  number  end     end     number      end
     *  end     end     end         end     end
     */
    public int sign = 1;
    public long ans = 0;
    private states state = states.START;
    private Map<states,states[]> table = new HashMap<states,states[]>() {
        {
            put(states.START, new states[]{states.START,states.SIGN,states.NUMBER,states.END});
            put(states.SIGN, new states[]{states.END,states.END,states.NUMBER,states.END});
            put(states.NUMBER, new states[]{states.END,states.END,states.NUMBER,states.END});
            put(states.END, new states[]{states.END,states.END,states.END,states.END});

        }};

    public states getState() {
        return state;
    }

    public boolean isEnd() {
        return state==states.END;
    }
    public void updateState(char c){
         state = table.get(state)[get_col(c)];
         if(state.equals(states.NUMBER)){
             ans = 10 * ans + c - '0';
             ans = (sign==1)?Math.min(ans,Integer.MAX_VALUE):(-Math.max(-ans,-(long)Integer.MIN_VALUE));
         }
         else if (state.equals(states.SIGN)) {
             sign = ( c=='+')? 1:-1;
         }
    }

    public int get_col(char c){
        if(c == ' '){
            return 0;
        }
        else if(c == '+' || c == '-'){
            return 1;
        }
        else if(c >= '0' && c <= '9'){
            return 2;
        }
        else{
            return 3;
        }
    }
    enum states{
        START,
        SIGN,
        NUMBER,
        END
    }
}