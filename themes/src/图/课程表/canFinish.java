package 图.课程表;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: canFinish
 * Package: 图.课程表
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/9/9 14:02
 * @Version 1.0
 */
public class canFinish {
    public static void main(String[] args) {
        int[][] pres = new int[][]{
                {1,0},
                {1,2},
                {0,1}
        };
        System.out.println(new canFinish().canFinish(3,pres));
    }

    ///////////////////////////////////////  BFS  //////////////////////////////////////////
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS遍历
        // 记录出表，以及每个元素的入度
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] outList = (ArrayList<Integer>[])new ArrayList<?>[numCourses];

        for (int i = 0; i < numCourses; i++) {
            outList[i] = new ArrayList<>();
        }


        for (int[] pre:prerequisites){
            inDegree[pre[0]]++;
            outList[pre[1]].add(pre[0]);
        }
        int count = 0;
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            // 没有入度，不需要前置课程
            if(inDegree[i]==0){
                queue.offerLast(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int postCourse:outList[cur]){
                inDegree[postCourse]--;
                if(inDegree[postCourse]==0) {
                    queue.offerLast(postCourse);
                    count++;
                }
            }
        }
        return count==numCourses;
    }

    /////////////////////////////////////// DFS     //////////////////////////////////////////
    List<List<Integer>> outList;
    int[] visited;
    boolean valid = true;
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // DFS遍历
        visited = new int[numCourses];
        outList = new ArrayList<List<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            outList.add(new ArrayList<>());
        }

        for (int[] pre:prerequisites){
            outList.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        
        return valid;
    }

    // visited 0 未访问 1 正在回溯 2 回溯完成满足条件
    public void dfs(int cur){
        visited[cur] = 1;
        for(int post:outList.get(cur)){
            if(visited[post]==0){
                dfs(post);
                if(!valid) return;
            }
            else if(visited[post]==1){
                valid=false;
                return;
            }
        }
        visited[cur]=2;
    }
}
