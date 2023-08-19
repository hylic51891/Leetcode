package _1016;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Package: _1016
 * Description:
 *  1016. 子串能表示从 1 到 N 数字的二进制串
 *  给定一个二进制字符串s和一个正整数n，如果对于[1, n]范围内的每个整数，其二进制表示都是s 的 子字符串 ，就返回 true，否则返回 false。
 *
 * 子字符串是字符串中连续的字符序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @Author hylic
 * @Create 2023/5/11 22:23
 * @Version 1.0
 */
class Solution {
    public static boolean queryString(String s, int n) {
        int start,end;
        int validStart = 0;
        int targetLen = s.length();
        for(int k = 0;k<targetLen;k++){
            if (s.charAt(k) != '0'){
                validStart = k;
                break;
            }
        }

        int len;
        boolean findFlag = false;
        String binaryNum;
        for(int i=1; i<=n ; i++){
            findFlag = false;
            binaryNum = Integer.toBinaryString(i);
            len = binaryNum.length();
            for(int j=validStart; j<= targetLen-len; j++){
                String subString = s.substring(j,j+len);
                if(subString.equals(binaryNum)){
                    findFlag = true;
                    break;
                }
            }
            if (findFlag == false){
                break;
            }
        }
        return findFlag;
    }

    public static boolean queryString2(String s, int n) {
        for(int i=1; i<=n ; i++){
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;

    }
    // 100% 50.45%
    public static boolean queryString3(String s, int n) {
        int validStart = 0;
        int targetLen = s.length();
        for(int i = 0;i<targetLen;i++){
            if (s.charAt(i) != '0'){
                validStart = i;
                break;
            }
        }
        int k = Integer.toBinaryString(n).length() - 1;
        if(s.length()-validStart < k){
            return false;
        }
        if (n == 1) {
            if (s.contains("1")) {
                return true;
            } else {
                return false;
            }
        }
        for(int i = (int)Math.pow(2,k-1);i < n;i++){
            if (!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }

    //执行用时：
    //5 ms
    //, 在所有 Java 提交中击败了
    //24.32%
    //的用户
    //内存消耗：
    //42.2 MB
    //, 在所有 Java 提交中击败了
    //6.31%
    //的用户
    public static boolean queryString4(String s, int n) {
        Set<String> subStrings = new HashSet<>();
        String BinaryN = Integer.toBinaryString(n);
        int len = BinaryN.length();
        int StringLen = s.length();
        String sub = "0";
        for(int j = 0;j<=StringLen-len;j++){
            sub = s.substring(j,j+len);
            if(sub.compareTo(BinaryN)<=0 && sub.startsWith("1") && !subStrings.contains(sub)){
                subStrings.add(sub);
            }
        }

        for(int i = len-1;i>0;i--){
            for(int j = 0;j<=StringLen-i;j++){
                sub = s.substring(j,j+i);
                if(sub.startsWith("1") && !subStrings.contains(sub)){
                    subStrings.add(sub);
                }
            }
        }
        if (subStrings.size() == n){
            return true;
        }
        else{
            return false;
        }
    }

//    public boolean queryString5(String S, int n) {
//        var seen = new HashSet<Integer>();
//        var s = S.toCharArray();
//        for (int i = 0, m = s.length; i < m; ++i) {
//            int x = s[i] - '0';
//            if (x == 0) continue; // 二进制数从 1 开始
//            for (int j = i + 1; x <= n; j++) {
//                seen.add(x);
//                if (j == m) break;
//                x = (x << 1) | (s[j] - '0'); // 子串 [i,j] 的二进制数
//            }
//        }
//        return seen.size() == n;
//    }

    public static void main(String[] args) {
        System.out.println(queryString4("0110",3));

    }
}
