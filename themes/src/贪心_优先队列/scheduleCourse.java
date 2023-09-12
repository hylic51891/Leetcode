package 贪心_优先队列;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ClassName: scheduleCourse
 * Package: 贪心_优先队列
 *  630. 课程表 III
 *  https://leetcode.cn/problems/course-schedule-iii/description/?envType=daily-question&envId=2023-09-11
 * @description
 * @Author hylic_desktop
 * @Create 2023/9/11 17:07
 * @Version 1.0
 */
public class scheduleCourse {
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
