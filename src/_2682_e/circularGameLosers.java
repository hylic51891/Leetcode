package _2682_e;

/**
 * ClassName: circularGameLosers
 * Package: _2682_e
 * Description:
 *  https://leetcode.cn/problems/find-the-losers-of-the-circular-game/
 * @Author hylic
 * @Create 2023/8/16 19:32
 * @Version 1.0
 */
public class circularGameLosers {
    public static void main(String[] args) {
        circularGameLosers(5,2);
    }
    public static int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        int step = 1;
        int count = n-1;
        visited[0] = true;
        while(true){
            int index = (k*step*(step+1)/2)%n;
            if(visited[index]) break;
            visited[index] = true;
            count--;
            step++;
        }
        int[] ret = new int[count];
        int idx = 0;
        for(int i = 0;i<n;i++){
            if(visited[i]!=true) ret[idx++] = i+1;
        }
        return ret;
    }
}
