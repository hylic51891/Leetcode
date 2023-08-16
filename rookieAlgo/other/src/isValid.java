import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: isValid
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 21:26
 * @Version 1.0
 */
public class isValid {
    public static void main(String[] args) {
        isValid("()");
    }

    /**
     * 执行用时：
     * 1 ms
     * 97.69%
     */


    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty())return false;
                else{
                    if(c == ')' && stack.pop() != '(') return false;
                    else if(c == '}' && stack.pop() != '{') return false;
                    else if(c == ']' && stack.pop() != '[') return false;
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c:chars) {
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty())return false;
                else{
                    if(c == ')' && stack.pop() != '(') return false;
                    else if(c == '}' && stack.pop() != '{') return false;
                    else if(c == ']' && stack.pop() != '[') return false;
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
