package _3_sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: findAnagrams
 * Package: _3_sliding_window
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/24 12:12
 * @Version 1.0
 */
public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int winLen = p.length();
        int kind = 0;
        int curKind = 0;
        int[] cnt = new int[26];
        for(int i = 0;i<winLen;i++) cnt[p.charAt(i)-'a']++;
        for(int i = 0;i<26;i++) if(cnt[i]!=0) kind++;
        List<Integer> ret = new ArrayList<>();
        int right = 0;
        int left = 0;
        while(right<s.length()){
            // 1. 右指针右移,cnt--
            if(--cnt[s.charAt(right++)-'a']==0) curKind++;
            // 2. window长度大于winLen，左指针右移
            if(right-left>winLen && ++cnt[s.charAt(left++)-'a']==1) curKind--;
            // 3. 满足条件，加入结果
            if(right-left==winLen && curKind==kind) ret.add(left);
        }
        return ret;
    }
}
