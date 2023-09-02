package _4_subString;

/**
 * ClassName: minWindow
 * Package: _4_subString
 * Description:
 *  76. 最小覆盖子串
 *  https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author hylic
 * @Create 2023/8/24 22:05
 * @Version 1.0
 */
public class minWindow {
    public String minWindow(String s, String t) {
        if(s.length()< t.length()) return "";
        int[] cnt = new int[52];
        int kind = 0;
        for(int i = 0;i<t.length();i++){
            if(t.charAt(i)>= 'a'){
                if(++cnt[t.charAt(i)-'a'] == 1) kind++;
            }
            else{
                if(++cnt[t.charAt(i)-'A'+26] == 1) kind++;
            }

        }
        int left = 0;
        int right = 0;
        int curkind = 0;
        int retIndex = -1;
        int len = Integer.MAX_VALUE;
        while(right < s.length()){
            if(s.charAt(right)>= 'a'){
                if(--cnt[s.charAt(right)-'a'] == 0) curkind++;
            }
            else{
                if(--cnt[s.charAt(right)-'A'+26] == 0) curkind++;
            }

            while(left<= right && curkind==kind){
                if(len > right-left+1){
                    retIndex = left;
                    len = right-left+1;
                }

                if(s.charAt(left)>= 'a'){
                    if(++cnt[s.charAt(left)-'a'] == 1) curkind--;
                }
                else{
                    if(++cnt[s.charAt(left)-'A'+26] == 1) curkind--;
                }
                left++;
            }
            right++;
        }
        if(retIndex== -1) return "";
        return s.substring(retIndex,retIndex+len);
    }
}
