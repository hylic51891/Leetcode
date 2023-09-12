package _9_backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: partitionPalindrome
 * Package: _9_backtrack
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/4 16:50
 * @Version 1.0
 */
public class partitionPalindrome {
    // list数组，当前i对应一个list，
    String str;
    int len;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        str = s;
        len = s.length();
        res = new ArrayList<>();
        backtrack(new LinkedList<String>(),0);
        return res;
    }

    public void backtrack(LinkedList<String> list, int index){
        if(index==len){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index;i<len;i++){
            if(isPalindrome(index,i)){
                list.add(str.substring(index,i+1));
                backtrack(list,i+1);
                list.removeLast();
            }
        }
    }

    public boolean isPalindrome(int start ,int end){
        while(start < end){
            if(str.charAt(start++)!=str.charAt(end--)) return false;
        }
        return true;
    }
}

// DP预处理回文串
class partitionPalindrome2 {
    // list数组，当前i对应一个list，
    String str;
    int len;
    List<List<String>> res;
    boolean[][] isP;
    public List<List<String>> partition(String s) {
        str = s;
        len = s.length();
        res = new ArrayList<>();
        isP = new boolean[len][len];
        for(int i = 0;i<len;i++){
            isP[i][i] = true;
        }
        for(int i = 1;i<len;i++){   // 长度
            for(int j = 0;j<len-i;j++){
                if(s.charAt(j) == s.charAt(j+i) && (i==1||isP[j+1][j+i-1]) ) isP[j][j+i] = true;
            }
        }
        backtrack(new LinkedList<String>(),0);
        return res;
    }

    public void backtrack(LinkedList<String> list, int index){
        if(index==len){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index;i<len;i++){
            if(isP[index][i]){
                list.add(str.substring(index,i+1));
                backtrack(list,i+1);
                list.removeLast();
            }
        }
    }
}