package _58_e;

/**
 * ClassName: Solution
 * Package: _58_e
 * Description:
 *
 * @Author hylic
 * @Create 2023/6/30 21:07
 * @Version 1.0
 */
class Solution {
    /**
     *  执行用时 0ms
     *  内存 40.06%
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder s1,s2;
        s1 = new StringBuilder(s);
        s2 = new StringBuilder(s1.substring(n+1));
        return s2.append(s1.substring(0,n+1)).toString();
    }

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 39.82%
     * 的用户
     * 内存消耗：
     * 42.2 MB
     * , 在所有 Java 提交中击败了
     * 34.72%
     * 的用户
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder s1 = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            s1.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            s1.append(chars[i]);
        }
        return s1.toString();
    }
}
