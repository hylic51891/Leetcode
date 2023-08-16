package String;

/**
 * ClassName: reverse
 * Package: String
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 14:20
 * @Version 1.0
 */
public class reverse {
    public void reverseString(char[] s) {
        // 1.双指针
        int i = 0;
        int j = s.length-1;
        char temp;
        while(i<j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
