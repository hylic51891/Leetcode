import java.util.HashMap;

/**
 * ClassName: firstUniqChar
 * Package: String
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 14:21
 * @Version 1.0
 */
public class firstUniqChar {
    /**执行用时：
     5 ms
     , 在所有 Java 提交中击败了
     84.22%
     的用户
     内存消耗：
     43.1 MB
     , 在所有 Java 提交中击败了
     31.64%
     的用户
     *
     */
    public int firstUniqChar(String s) {
        /**
         1. 用hashmap或数组存放出现次数
         2. 遍历一遍，看哪个只出现过1次
         */
        int[] alphabet = new int[26];
        for(int i = 0;i<s.length();i++){
            alphabet[s.charAt(i)-'a'] +=1;
        }
        for(int i = 0;i<s.length();i++){
            if(alphabet[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }

    /**
     * 执行用时：
     * 27 ms
     * , 在所有 Java 提交中击败了
     * 27.30%
     * 的用户
     * 内存消耗：
     * 43.2 MB
     * , 在所有 Java 提交中击败了
     * 16.39%
     * 的用户
     */
    public int firstUniqChar2(String s) {
        /**
         1. 用hashmap或数组存放出现次数
         2. 遍历一遍，看哪个只出现过1次
         */
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    /**
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 84.22%
     * 的用户
     * 内存消耗：
     * 43 MB
     * , 在所有 Java 提交中击败了
     * 41.50%
     * 的用户
     */
    public int firstUniqChar3(String s) {
        /**
         1. 用hashmap或数组存放出现次数
         2. 遍历一遍，看哪个只出现过1次
         */
        int[] alphabet = new int[26];
        int min = s.length();
        for(int i = 0;i<s.length();i++){
            alphabet[s.charAt(i)-'a'] +=1;
        }
        int single;
        for(int i = 0;i<26;i++){
            if(alphabet[i] == 1) {
                single = s.indexOf((char)(i+'a'));
                min = (min > single)?(single):(min);
            }
        }
        if(min == s.length()) return -1;
        return min;
    }
    public int firstUniqChar4(String s) {
        for(int i = 0;i<s.length();i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) return i;
        }
        return -1;
    }
}
