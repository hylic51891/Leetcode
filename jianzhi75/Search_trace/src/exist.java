import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: exist
 * Package: PACKAGE_NAME
 *  https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/16 0:52
 * @Version 1.0
 */
public class exist {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        char[][] board2 = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new exist().exist2(board,"SEE"));
    }

    /**
     * 用hashMap记录每个字符对应的位置，然后按照s中的位置找下去
     * 没考虑word中有重复的字符
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        /**
         1. 找到起始点，可能是多个
         2. 遍历起始点，顺序查找word中的字符
         */
        int row = board.length;
        if(row==0) return false;
        int column = board[0].length;
        Map<Character,Integer> wordMap = new HashMap<>();
        Map<Integer,ArrayList<int[]>> numMap = new HashMap<>();

//        int[][] numBoard = new int[row][column];
        for (int i = 0; i < word.length(); i++) {
            wordMap.put(word.charAt(i),i);
            numMap.put(i,new ArrayList<>());
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int sequence = wordMap.getOrDefault(board[i][j],-1);
                if(sequence!=-1) numMap.get(sequence).add(new int[]{i,j});
            }
        }

        if(word.length()==1) return !numMap.get(0).isEmpty();

        ArrayList<int[]> starts = numMap.get(0);
        boolean exists = false;
        for (int i = 0; i < starts.size(); i++) {
            if(valid(numMap,starts.get(i),word.length())) exists = true;
        }
        return exists;
    }
    public boolean valid(Map<Integer,ArrayList<int[]>> numMap,int[] start,int length) {
        int[] curPos = start;
        for (int i = 1; i < length; i++) {
            boolean hasNext = false;
            for(int[] nextPos: numMap.get(i)){
                if(neighbor(curPos,nextPos)){
                    curPos = nextPos;
                    hasNext = true;
                    break;
                }
            }
            if(!hasNext) return false;
        }
        return true;
    }
    public boolean neighbor(int[] p1,int[] p2) {
        int row = p1[0]-p2[0];
        int column = p1[1]-p2[1];
        return ((row==-1|| row==1)&& column==0) || ((column==-1|| column==1)&& row==0);
    }

    /**
     * 用hashMap记录每个字符对应的位置，然后按照s中的位置找下去
     * 改进
     * 错误！没有考虑有两个以及以上分支在当前正确，但是后续错误
     */
    public boolean exist2(char[][] board, String word) {

        int row = board.length;
        if(row==0) return false;
        int column = board[0].length;
        Map<Character,ArrayList<int[]>> charMap = new HashMap<>();
        int len = word.length();
//        int[][] numBoard = new int[row][column];
        for (int i = 0; i < len; i++) {
            charMap.put(word.charAt(i),new ArrayList<>());
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char c = board[i][j];
                if(charMap.containsKey(c)) charMap.get(c).add(new int[]{i,j});
            }
        }

        ArrayList<int[]> starts = charMap.get(word.charAt(0));
        if(word.length()==1) return !starts.isEmpty();

        boolean exists = false;
        for (int i = 0; i < starts.size(); i++) {
            if(valid2(charMap,starts.get(i),word)) exists = true;
        }
        return exists;
    }
    public boolean valid2(Map<Character,ArrayList<int[]>> charMap,int[] start,String word) {
        int[] curPos = start;
        for (int i = 1; i < word.length(); i++) {
            boolean hasNext = false;
            for(int[] nextPos: charMap.get(word.charAt(i))){
                if(neighbor2(curPos,nextPos)){
                    curPos = nextPos;
                    hasNext = true;
                    break;
                }
            }
            if(!hasNext) return false;
        }
        return true;
    }

    public boolean neighbor2(int[] p1,int[] p2) {
        int row = p1[0]-p2[0];
        int column = p1[1]-p2[1];
        return ((row==-1|| row==1)&& column==0) || ((column==-1|| column==1)&& row==0);
    }
}

/**
 * 同leetcode 79题，看完题解自己写一遍 DFS+剪枝
 */
class myExist {
    static int m;
    static int n;
    static int wordLen;
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        m = board.length;
        if(m==0) return false;
        n = board[0].length;
        if(n==0) return false;
        wordLen = word.length();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(validPath(board,chars,i,j,0)) return true;
            }
        }
        return false;
    }
    /**
     1. 参数
     当前位置：i,j
     当前需要匹配的字符在word中的位置k
     2. 递归结束条件
     1. i,j位置超出边界，false
     2. k== length 路径走通，true
     3. 当前位置的字符!=匹配字符 false

     3. 递归传递
     传递到下一个位置的时候，把当前位置进行标记（已访问）
     递归回来的时候，恢复标记

     */
    public boolean validPath(char[][] board, char[] word,int i,int j,int k){
        if(i<0 || i >= m || j<0||j>=n) return false;
        if(board[i][j]!= word[k]) return false;
        if(k==wordLen-1) return true;
        char tmp = board[i][j];
        board[i][j] = '\0';
        boolean ret = validPath(board,word,i+1,j,k+1) ||
        validPath(board,word,i-1,j,k+1) ||
        validPath(board,word,i,j+1,k+1) ||
        validPath(board,word,i,j-1,k+1);
        board[i][j] = tmp;
        return ret;
    }
}
