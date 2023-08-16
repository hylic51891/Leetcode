/**
 * ClassName: longestCommonPrefix
 * Package: String
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 21:11
 * @Version 1.0
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String strs[] = new String[]{"CIR","CAR"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 98.58%
     * 的用户
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1 ) return strs[0];
        int len = strs[0].length();
        for(String s:strs){
            len = (len > s.length())?(s.length()):(len);
        }
        char c;
        int num = 0;
        boolean flag;
        for(int i= 0; i< len;i++){
            flag = true;
            c = strs[0].charAt(i);
            for(int j = 1;j< strs.length;j++){
                if(strs[j].charAt(i) != c){
                    flag = false;
                    break;
                }
            }
            if(flag) num++;
            else break;
        }
        if(num==0){
            return "";
        }
        else{
            return strs[0].substring(0,num);
        }
    }
}
