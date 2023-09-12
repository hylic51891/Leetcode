package 二分查找;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: repairCars
 * Package: 二分查找
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/7 10:16
 * @Version 1.0
 */

// 我的想法：动态规划，时间复杂度O(N!),剪枝也没用
public class _2594_m_20230907 {
    long minTime = Integer.MAX_VALUE;
    public long repairCars(int[] ranks, int cars) {
        // 动态规划，完全背包
        // 第i名员工选择修理k辆的时候，最少的总时长。
        // 目标：最少时间
        // 容量：cars
        // 价值：员工修车时间
        dfs(ranks,0,cars,0);
        return minTime;
    }
    // 第i个员工，剩余车数量
    public void dfs(int[] ranks, int index, int carNum,long curMinTime){
        if(carNum == 0){
            minTime = minTime<curMinTime?minTime:curMinTime;
            return;
        }

        if(index == ranks.length-1){
            long curTime = ranks[index]*carNum*carNum;
            long nextMinTime = (curMinTime > curTime)? curMinTime:curTime;
            dfs(ranks,index+1,0,nextMinTime);
            return;
        }

        for(int i = 0;i<=carNum;i++){
            long curTime = ranks[index]*i*i;
            long nextMinTime = (curMinTime > curTime)? curMinTime:curTime;
            if(nextMinTime > minTime) continue;
            dfs(ranks,index+1,carNum-i,nextMinTime);
        }

    }

}

// 二分查找
class Solution {
    int[] workers;
    int carNum;
    int length;
    public long repairCars(int[] ranks, int cars) {
        length = ranks.length;
        workers =ranks;
        carNum = cars;

        long left = 0;
        long right = (long) ranks[0] *cars*cars;

        while(left <= right){
            long mid = left+(right-left)/2;
            if(calculateCarNum(mid)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public boolean calculateCarNum(long time){
        int num = 0;
        for (int i = 0; i < length; i++) {
            num += Math.sqrt(time*1.0/workers[i]);
        }
        return num >= carNum;
    }
}

// 根据题给条件，可以先把workers统计成长度100的频率数组
class Solution2 {
    public long repairCars(int[] ranks, int cars) {
        long[] workers = new long[100 + 1];
        for (int r : ranks) {
            workers[r]++;
        }

        long left = 0;
        long right = (long) ranks[0] * cars * cars;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (calculateCarNum(workers, cars, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean calculateCarNum(long[] workers, int cars, long time) {
        long num = 0;
        for (int i = 1; i < workers.length; i++) {
            if (workers[i] == 0) continue;
            num += workers[i] * (long) Math.sqrt(time * 1.0 / i);
            if (num >= cars) return true;
        }
        return false;
    }
}

