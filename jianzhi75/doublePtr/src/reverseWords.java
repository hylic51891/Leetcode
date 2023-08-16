import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: reverseWords
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 15:52
 * @Version 1.0
 */
public class reverseWords {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    /**
     * 2ms 75%
     */
    public static String reverseWords(String s) {
        String trim = s.trim();
        int start = trim.length() - 1;
        int end = trim.length() - 1;
        StringBuilder ret = new StringBuilder();
        while (start >= 0) {
            while (trim.charAt(start) == ' ') {
                start--;
            }
            end = start - 1;

            while (end >= 0 && trim.charAt(end) != ' ') {
                end--;
            }
            ret.append(" ").append(trim.substring(end + 1, start + 1));
            start = end - 1;
        }
        return ret.toString().trim();
    }

    /**
     * 6ms 23%
     */
    public static String reverseWords2(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
