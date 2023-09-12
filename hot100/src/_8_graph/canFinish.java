package _8_graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ClassName: canFinish
 * Package: _8_graph
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/1 17:50
 * @Version 1.0
 */
public class canFinish {
    // 练习：多叉树遍历/图的回溯
    boolean visited[];  // 记录是否已经遍历过课程i位置
    boolean onPath[];   // 记录一次遍历过程中出现过的课程，用于检测是否有环
    int num;
    boolean hasCycle;   // 记录所有遍历中是否出现过环
    LinkedList<Integer>[] adjList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.num = numCourses;
        this.visited = new boolean[numCourses];
        this.onPath = new boolean[numCourses];
        buildGraph(prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traversal(i);
            if(hasCycle) return false;
        }
        return true;
    }
    // 建立邻接表的模板函数
    public void buildGraph(int[][] prerequisites){
        adjList = new LinkedList[num];
        for (int i = 0; i < num; i++) {
            adjList[i] = new LinkedList<>();
        }
        int len = prerequisites.length;
        for(int[] pre: prerequisites){
            adjList[pre[1]].add(pre[0]);
        }
    }
    public void traversal(int start){
        if(onPath[start]){
            hasCycle = true;
        }
        if(visited[start] || hasCycle) return;
        visited[start] = true;
        onPath[start] = true;
        for(int index:adjList[start]){
            traversal(index);
        }
        onPath[start] = false;
    }
}
