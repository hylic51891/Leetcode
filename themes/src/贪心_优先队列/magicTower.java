package 贪心_优先队列;

import java.util.PriorityQueue;

/**
 * ClassName: magicTower
 * Package: 贪心_优先队列
 *  LCP 30. 魔塔游戏
 *  https://leetcode.cn/problems/p0NxJO/description/
 * @description
 * @Author hylic_desktop
 * @Create 2023/9/11 17:07
 * @Version 1.0
 */
public class magicTower {
    public int magicTower(int[] nums) {
        long sum = 1;
        for(int num:nums){
            sum+=num;
        }
        if(sum<=0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 最小堆，扣血越多的房间越先出pq
        long HP = 1;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            HP += nums[i];   //先选择当前的
            if(nums[i]<=0){
                pq.offer(nums[i]);
                if(HP<=0){
                    HP-= pq.poll();
                    count++;
                }
            }
        }
        return count;
    }
}
