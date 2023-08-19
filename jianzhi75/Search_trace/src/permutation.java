import java.util.ArrayList;
import java.util.HashSet;

/**
 * ClassName: permutation
 * Package: PACKAGE_NAME
 *https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/?envType=study-plan-v2&envId=coding-interviews
 *  剑指 Offer 38. 字符串的排列
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/17 1:54
 * @Version 1.0
 */


/** 我的思路，一个字符一个字符的加
 *  每次用hashset存储结果，保证不重复
 *  33ms 24%
 */
public class permutation {
    public static void main(String[] args) {
        new permutation().permutation("1234");
    }
    public String[] permutation(String s) {
        int n = s.length();
        char c = s.charAt(n-1);
        String[] list = addChar(new String[]{""+c},s,n-2);
        return list;
    }

    /**
     *  给定一个字符串，给定一个加入的char,返回加入之后的所有可能的字符串
     */
    public String[] addChar(String[] list,String s,int index) {
        if(index == -1) return list;
        char c = s.charAt(index);
        int n = list[0].length();
        HashSet<String> curSet = new HashSet<>();
        for (int i = list.length-1; i >= 0; i--) {
            String curString = list[i];
            curSet.add(curString+c);
            curSet.add(c+curString);
            for (int j = 1; j < n; j++) {
                curSet.add(curString.substring(0,j)+c+curString.substring(j));
            }
//            list.addLast(curString+c);
//            list.addLast(c+curString);
//            for (int j = 1; j < n; j++) {
//                list.addLast(curString.substring(0,j)+c+curString.substring(j));
//            }
        }
//        String[] ret = new ArrayList<>(curSet).toArray(new String[0]);
        return addChar(new ArrayList<>(curSet).toArray(new String[0]),s,index-1);
    }

}
