package _9_backtrack;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: solveNQueens
 * Package: _9_backtrack
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/4 19:13
 * @Version 1.0
 */
public class solveNQueens {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> ans = new LinkedList<>();
    boolean[][] queens;
    int len;
    char[] singleRow;
    public List<List<String>> solveNQueens(int n) {
        queens = new boolean[n][n];
        len = n;
        singleRow = new char[n];
        Arrays.fill(singleRow,'.');
        backtrack(0);
        return res;
    }
    public void backtrack(int k){
        if(k==len){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<len;i++){
            if(isValid(k,i)){
                queens[k][i] = true;
                singleRow[i] = 'Q';
                ans.add(String.valueOf(singleRow));
                singleRow[i] = '.';
                backtrack(k+1);
                ans.removeLast();
                queens[k][i] = false;
            }
        }

    }
    public boolean isValid(int row,int column){
        // 比较这一列是否有queen
        for(int i = 0;i<row;i++){
            if(queens[i][column]) return false;
        }
        // 比较斜方向是否有queen
        for(int j = 0;j < len;j++){
            int diff = j-column;
            diff = diff>0?diff:-diff;
            if(row-diff>=0 && queens[row-diff][j]) return false;
        }
        return true;
    }
}
