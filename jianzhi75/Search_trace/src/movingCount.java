/**
 * ClassName: movingCount
 * Package: PACKAGE_NAME
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/16 13:27
 * @Version 1.0
 */

/** 我写的回溯
 *  1ms 62%
 */
public class movingCount {

    static final int[][] directs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static int count;
    static int bound;
    static int[][] board;
    public int movingCount(int m, int n, int k) {
        count = 0;
        board = new int[m][n];
        bound = k;
        recur(m,n,0,0);
        return count;
    }
    /** 递归
     * 参数：最大范围m,n 当前位置i,j 限制 k
     * 结束条件：
     *  1. 当前位置已经设置为到达过或超出边界
     *  2. 不满足题目给定条件
     * 递归：当前位置如果满足要求，则count++
     * 递归中修改的参数：当前位置i,j的可达性设置为不可达或已走过
     */
    public void recur(int m, int n, int i, int j){
        // 超出边界
        if(i<0 || j < 0 || i>=m || j>=n) return;
        // 已经是不可达
        if(board[i][j] == -1) return;
        // 不满足条件
        int accum = sums(i)+sums(j);
        if(accum > bound) return;
        else count++;

        board[i][j] = -1;
        for (int l = 0; l < 4; l++) {
            recur(m,n,i+directs[l][0],j+directs[l][1]);
        }
    }

    public int sums(int x){
        int s = 0;
        while(x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }



}

/** 题解
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solutions/110056/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/?envType=study-plan-v2&envId=coding-interviews
 *  看完题解之后，优化点：
 *  1. 从(0,0)开始走，能够走到的满足条件的区域，只需要向右和向下
 *  2. 已经到达过可以用boolean数组来记录
 */
class movingCountOptimize {
    static final int[][] directs = new int[][]{{1,0},{0,1}};
    static int count;
    static int bound;
    static boolean[][] board;
    public int movingCount(int m, int n, int k) {
        count = 0;
        board = new boolean[m][n];
        bound = k;
        recur(m,n,0,0);
        return count;
    }
    /** 递归
     * 参数：最大范围m,n 当前位置i,j 限制 k
     * 结束条件：
     *  1. 当前位置已经设置为到达过或超出边界
     *  2. 不满足题目给定条件
     * 递归：当前位置如果满足要求，则count++
     * 递归中修改的参数：当前位置i,j的可达性设置为不可达或已走过
     */
    public void recur(int m, int n, int i, int j){
        // 超出边界
        if(i>=m || j>=n) return;
        // 已经到达过
        if(board[i][j]) return;
        // 不满足条件
        int accum = sums(i)+sums(j);
        if(accum > bound) return;
        else count++;

        board[i][j] = true;
        for (int l = 0; l < 2; l++) {
            recur(m,n,i+directs[l][0],j+directs[l][1]);
        }
    }

    public int sums(int x){
        int s = 0;
        while(x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }



}