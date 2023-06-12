package _392;

/**
 * ClassName: Solution
 * Package: _392
 * Description:
 *
 * @Author hylic
 * @Create 2023/6/12 21:17
 * @Version 1.0
 */
class Solution {
    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.6 MB
     * , 在所有 Java 提交中击败了
     * 51.55%
     * 的用户
     * 通过测试用例：
     * 18 / 18
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        char subString[] = s.toCharArray();
        char target[] = t.toCharArray();
        boolean flag = false;
        for(int i = 0; i < s.length();i++){
            flag = false;
            for(int j = index; j < t.length();  j++){
                if(subString[i] == target[j]){
                    flag = true;
                    index = j+1;
                    break;
                }
            }
            if (!flag){
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 88.80%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 67.55%
     * 的用户
     * 通过测试用例：
     * 18 / 18
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;

        while(j != t.length() && i!= s.length()){
            if(s.charAt(i)==t.charAt(j))
                i++;
            j++;
        }

        return i == s.length();
    }
}
