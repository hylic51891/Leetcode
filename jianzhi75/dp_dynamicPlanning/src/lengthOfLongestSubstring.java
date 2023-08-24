import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * ClassName: lengthOfLongestSubstring
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/19 18:29
 * @Version 1.0
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        /**
         子问题：子串中的最长子串
         */
        int max = 0;
        Deque<Character> dp = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(dp.contains(cur)){
                while(dp.poll()!=cur);
            }
            dp.addLast(cur);
            if(max < dp.size()) max = dp.size();
        }
        return max;
    }

}
