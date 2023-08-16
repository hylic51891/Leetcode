package _833_m;

import java.util.Arrays;

/**
 * ClassName: findReplaceString
 * Package: _833_m
 *  https://leetcode.cn/problems/find-and-replace-in-string/description/
 *  字符串中的查找与替换
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/15 16:14
 * @Version 1.0
 */
public class findReplaceString {
    /**
     * 我的思路，用一个数组记录对应的替换下标和数组下标
     * 1ms 95% O(n+m) 最坏情况，所有数组都需要替换
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] replace = new int[s.length()];
        Arrays.fill(replace,-1);
        for (int i = 0; i < indices.length; i++) {
            if( s.startsWith(sources[i],indices[i]) ){
                replace[indices[i]] = i;
            }
        }
        StringBuilder ret = new StringBuilder();
        int start = 0;
        for (int j = 0; j < s.length(); j++) {
            if(replace[j] != -1){
                if(start < j) ret.append(s, start, j);
                ret.append(targets[replace[j]]);
                start = j+sources[replace[j]].length();
            }
        }
        if(start<s.length())  ret.append(s, start, s.length());
        return ret.toString();
    }
}
