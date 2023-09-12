package 图.课程表;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: scheduleCourse
 * Package: 图.课程表
 *  630. 课程表 III
 * @description
 * @Author hylic_desktop
 * @Create 2023/9/11 15:28
 * @Version 1.0
 */

// HARD

/** 我的思路：多叉树遍历
 * 慢：时间复杂度O(n^n)
 */
public class scheduleCourse {
    public static void main(String[] args) {
        int[][] courses = new int[][]{
                { 100,200},{200,1300},{1000,1250},{2000,3200}
        };
        System.out.println(new scheduleCourse().scheduleCourse(courses));

    }
    int len;
    boolean[] onPath;

    int max;
    public int scheduleCourse(int[][] courses) {
        // DFS，可以从任意一门开始
        // 每门课修完之后可选，最晚开始时间晚于当前时间的课程。
        len = courses.length;
        onPath = new boolean[len];
        max = 0;

        Arrays.sort(courses, Comparator.comparingInt(a -> (a[1] - a[0])));
        if(courses[0][1]-courses[0][0] < 0) return 0;
        if(len==1) return 1;
        for (int i = 0; i < len; i++) {
            dfs(courses,courses[i][0],1);
        }

        return max;
    }
    public void dfs(int[][] courses, int curTime, int count){
        int optionStart = binarySearch(courses,curTime,0,len);
        if(optionStart==-1){
            max = Math.max(max,count-1);  // 这一次遍历到头了
            return;
        }
        for(int i = optionStart;i<len;i++){
            if(onPath[i]) continue;
            onPath[i] = true;
            dfs(courses,curTime+courses[i][0],count+1);
            onPath[i] = false;
        }
    }
    // 寻找第一个大于等于target的位置
    public int binarySearch(int[][] courses,int target,int start,int end){
        //超过最后一个位置
        if(start==len-1 && target > courses[start][1]-courses[start][0]){
            return -1;
        }
        int mid = start+(end-start)/2;
        if(mid==start) return mid;

        int latestDay = courses[mid][1]-courses[mid][0];

        if(target<latestDay){
            return binarySearch(courses,target,start,mid-1);
        }
        else if(target>latestDay){
            return binarySearch(courses,target,mid+1,end);
        }
        else{
            return mid;
        }
    }
}


// 时间复杂度 O(nlogn)
class solution2{
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // 按照 lastDay 从小到大排序
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        int day = 0; // 已消耗时间
        for (int[] c : courses) {
            int duration = c[0], lastDay = c[1];
            if (day + duration <= lastDay) { // 没有超过 lastDay，直接学习
                day += duration;
                pq.offer(duration);
            } else if (!pq.isEmpty() && duration < pq.peek()) { // 该课程的时间比之前的最长时间要短
                // 反悔，撤销之前 duration 最长的课程，改为学习该课程
                // 节省出来的时间，能在后面上完更多的课程
                day -= pq.poll() - duration;
                pq.offer(duration);
            }
        }
        return pq.size();
    }
}
