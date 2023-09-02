package _8_graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: orangesRotting
 * Package: _8_graph
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/1 16:48
 * @Version 1.0
 */
public class orangesRotting {
    public static void main(String[] args) {
         int[][] grid = new int[][]{
                 {2,1,1},
                 {1,1,0},
                 {0,1,1}
         };
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        // BFS
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> twos = new LinkedList<>();
        int ones = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 2) twos.offerLast(new int[]{i,j});
                else if(grid[i][j] == 1) ones++;
            }
        }
        if(ones == 0) return 0;
        int minute = 0;

        while(true){
            int lastones = ones;
            int size = twos.size();
            while(size-->0){
                int[] two = twos.poll();
                int i = two[0];
                int j = two[1];
                if(i>0 && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    ones--;
                    twos.offerLast(new int[]{i-1,j});
                }
                if(i<m-1 && grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    ones--;
                    twos.offerLast(new int[]{i+1,j});
                }
                if(j>0 && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    ones--;
                    twos.offerLast(new int[]{i,j-1});
                }
                if(j<n-1 && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    ones--;
                    twos.offerLast(new int[]{i,j+1});
                }
            }
            if(lastones == ones) return minute==0||ones!=0 ? -1:minute;
            minute++;
        }
    }
}
