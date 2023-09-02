package _3_sliding_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: lengthOfLongestSubstring
 * Package: _3_sliding_window
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/24 10:56
 * @Version 1.0
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();

        char[] chars = s.toCharArray();
//        int i = 0;
        int j = 1;
        Deque<Character> queue = new LinkedList<>();
        queue.add(chars[0]);
        int res = 1;
        while(j<chars.length){
            if(queue.contains(chars[j])){
                while(queue.getFirst()!=chars[j]);
            }
            queue.addLast(chars[j]);
            res = (res>queue.size())?res:queue.size();
        }
        return res;
    }
}
