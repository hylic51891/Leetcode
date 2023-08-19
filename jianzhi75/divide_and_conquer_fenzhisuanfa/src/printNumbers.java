/**
 * ClassName: printNumbers
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/18 21:41
 * @Version 1.0
 */
public class printNumbers {
    public int[] printNumbers(int n) {
        if(n==1) return new int[]{1,2,3,4,5,6,7,8,9};
        int[] last = printNumbers(n-1);
        int len = (last.length +1)*10-1;
        int[] ret = new int[len];
        System.arraycopy(last,0,ret,0,last.length);
        for (int i = last.length; i < ret.length; i++) {
            ret[i] = i+1;
        }

        return ret;
    }



}
/**
 * 大数递归写法
 */

class printBigNumbers {
    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int)Math.pow(10, n) - 1];
        for(int digit = 1; digit < n + 1; digit++){
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first;
                dfs(1, num, digit);
            }
        }
        return res;
    }

    /**
     1. index 已有位数
     2. num 字符串表示的数字
     3. digit 数字总共位数
     */
    private void dfs(int index, char[] num, int digit){
        /**
         终止条件 index==digit 已经填完 加入res
         递归任务 0到9填入本位，传递到下一轮
         */
        if(index==digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }

        for(char c = '0'; c <= '9'; c++){
            num[index] = c;
            dfs(index+1, num, digit);
        }
    }



}