/**
 * ClassName: isPalindrome
 * Package: String
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 20:10
 * @Version 1.0
 */
public class isPalindrome {
    public static boolean charIsValid(char c){
        if((c >= '0' && c<= '9') || (c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z')) return true;
        return false;
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 95.63%
     * 的用户
     * 内存消耗：
     * 42.3 MB
     * , 在所有 Java 提交中击败了
     * 41.18%
     * 的用户
     */
    /**
     * 思路：变小写去除其他干扰之后，双指针
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int count = 0;
        char[] origin = s.toLowerCase().toCharArray();
        char[] valid = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(charIsValid(origin[i])) valid[count++] = origin[i];
        }
        if(count <= 1) return true;

        int i = 0;
        int j = count-1;
        while(i<j){
            if(valid[i++] != valid[j--]) return false;
        }
        return true;
    }


    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 95.63%
     * 的用户
     * 内存消耗：
     * 40.6 MB
     * , 在所有 Java 提交中击败了
     * 99.15%
     * 的用户
     */
    public boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;
        if(j < 1) return true;
        while(i<j){
            while(i<j && !charIsValid(s.charAt(i))){
                i++;
            }
            while(i<j && !charIsValid(s.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i++))
                    != Character.toLowerCase(s.charAt(j--)))
                return false;

        }
        return true;
    }
}
