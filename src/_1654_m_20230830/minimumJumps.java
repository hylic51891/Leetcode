package _1654_m_20230830;

import java.util.*;

/**
 * ClassName: minimumJumps
 * Package: _1654_m_20230830
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/30 10:53
 * @Version 1.0
 */
public class minimumJumps {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        //BFS+限定上界
        Set<Integer> forbiddenSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int forbiddenMax  = 0;
        for(int index:forbidden){
            forbiddenMax = (index>forbiddenMax)?index:forbiddenMax;
            forbiddenSet.add(index);
        }
        int upper = Math.max(forbiddenMax+a,x)+b;
        int lower = 0;
        Deque<int[]> queue = new LinkedList<>();

        visited.add(0);
        queue.offer(new int[]{0,1,0});  // BFS，队列记录 当前位置，走到这个地方来的方向（1是前进，-1是后退），步数
        while(!queue.isEmpty()){
            int[] status = queue.poll();
            int curPosition = status[0];
            int lastDirection = status[1];
            int step = status[2];

            if(curPosition==x) return step; // 退出条件:当前走到X，即为最少step

            int nextPosition = curPosition+a;
            int nextDirection = 1;
            // 可以选择前进
            if(nextPosition >= lower && nextPosition <= upper && !visited.contains(nextPosition*nextDirection)&&!forbiddenSet.contains(nextPosition)){
                visited.add(nextPosition*nextDirection);
                queue.offerLast(new int[]{nextPosition,nextDirection,step+1});
            }
            // 到这个位置，上一个方向是前进，这个位置才可以选择后退
            if(lastDirection==1){
                nextPosition = curPosition-b;
                nextDirection = -1;
                if(nextPosition >= 0 && nextPosition <= upper && !visited.contains(nextPosition*nextDirection)&&!forbiddenSet.contains(nextPosition)){
                    visited.add(nextPosition*nextDirection);
                    queue.offerLast(new int[]{nextPosition,nextDirection,step+1});
                }
            }

        }
        return -1;

    }
}
