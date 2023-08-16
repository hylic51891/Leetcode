/**
 * ClassName: countAndSay
 * Package: String
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 20:48
 * @Version 1.0
 */
public class countAndSay {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(countAndSay2(i));
        }
    }

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 66.55%
     * 的用户
     * 内存消耗：
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 35.02%
     * 的用户
     */
    public static String countAndSay(int n) {
        if(n == 0 || n == 1 ) return "1";
        char[] last = countAndSay(n - 1).toCharArray();
        StringBuilder s = new StringBuilder();
        int count = 1;
        char num = last[0];
        int i = 1;
        while( i < last.length){
            if(last[i] == num) count++;
            else{
                s.append(Integer.toString(count)).append(num);
                count = 1;
                num = last[i];
            }
            i++;
        }
        s.append(Integer.toString(count)).append(num);
        return s.toString();
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 75.20%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 27.27%
     * 的用户
     */
    public static String countAndSay2(int n) {
        if(n == 0 || n == 1 ) return "1";
        char[] last = countAndSay(n - 1).toCharArray();
        StringBuilder s = new StringBuilder();
        int first = 0;
        char num = last[0];
        int i = 1;
        while( i < last.length){
            if(last[i] != num) {
                s.append(Integer.toString(i-first)).append(num);
                num = last[i];
                first = i;
            }
            i++;
        }
        s.append(Integer.toString(i-first)).append(num);
        return s.toString();
    }
}
