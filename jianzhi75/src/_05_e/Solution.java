package _05_e;

/**
 * ClassName: Solution
 * Package: _05_e
 * Description:
 *
 * @Author hylic
 * @Create 2023/6/30 20:58
 * @Version 1.0
 */
class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder output = new StringBuilder();
        for(char c: chars){
            if (c == ' '){
                output.append("%20");
            }
            else{
                output.append(c);
            }
        }
        return output.toString();
    }

    public String replaceSpace2(String s) {
        return s.replace(" ","%20");
    }

}
