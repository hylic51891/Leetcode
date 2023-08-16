/**
 * ClassName: strStr
 * Package: String
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 14:58
 * @Version 1.0
 */
public class strStr {
    public static void main(String[] args) {
        String father = "sadbutsad";
        String sub = "sad";
        System.out.println(strStr3(father,sub));
    }
    /** 1. indexOf
     *  2. 自己写的挨个匹配
     *
     */
    public int strStr(String haystack, String needle) {
        // 1. indexOf
        // return haystack.indexOf(needle);

        // 2. 自己写的挨个匹配
        char[] stack = haystack.toCharArray();
        char[] sub = needle.toCharArray();
        boolean find;
        for (int i = 0; i < stack.length - sub.length +1 ; i++) {
            find = true;
            for (int j = 0; j < sub.length; j++) {
                int k = i;
                if(stack[k+j] != sub[j]){
                    find = false;
                    break;
                }
            }
            if(find) return i;
        }
        return -1;
    }

    /**
     * KMP算法尝试
     *
     */
    public static int strStr2(String haystack, String needle) {
        char[] father = haystack.toCharArray();
        char[] sub = needle.toCharArray();
        int i;
        int j;
        int[] next = new int[sub.length+1];
        next[0] = -1;
        /**
         * next数组：当前位置开始匹配，视为后缀，从匹配串的开头开始匹配，视为前缀。
         * 能够重叠的最大值就是当前位置的next数组的值。
         */
        i = 0;
        j = -1;
        while(i < sub.length){
            if(j== -1){
                j++;
                i++;
            }
            // 如果匹配，则继续下一个
            else if(sub[i] == sub[j]){
                i++;
                j++;
                next[i] = j;
            }
            else{   // 不匹配，则匹配起始点跳转到next[j]
                j = next[j];
            }
        }
        i = 0;
        j = 0;
        while(i < father.length && j < sub.length){
            // 通过next数组指向第一个
            // 1. 最开始的情况
            // 2. next数组中第一个元素匹配就失败，则匹配串指向index=0,父串指向下一个字符
            if(j== -1){
                j++;
                i++;
            }
            // 如果匹配，则继续下一个
            else if(father[i] == sub[j]){
                i++;
                j++;
            }
            else{   // 不匹配，则匹配起始点跳转到next[j]
                j = next[j];
            }
        }
        // 匹配成功，则通过j跳出while
        if(j == sub.length){
            return i-j; // 都指向最后一个字符
        }
        return -1;
    }

    public static int strStr3(String haystack, String needle){
        int i;
        int j;
        char[] father = haystack.toCharArray();
        char[] sub = needle.toCharArray();
        int[] next = new int[sub.length+1];
        // next数组赋值，i位置赋值 跳转到 前缀和后缀最长的长度之后的位置，所以先j++
        i = 0;
        j = -1;
        next[0] = -1;
        while(i< sub.length){
            if(j == -1 || sub[i] == sub[j]){
                j++;
                i++;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        // 匹配
        i = 0;
        j = 0;
        while(i<father.length && j < sub.length){
            if(j == -1 || father[i] == sub[j]){
                j++;
                i++;
            }
            else{
                j = next[j];
            }
        }
        if(j == sub.length){
            return i-j;
        }
        return -1;
    }
}
