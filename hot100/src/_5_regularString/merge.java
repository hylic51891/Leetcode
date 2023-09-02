package _5_regularString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: merge
 * Package: _5_regularString
 * Description:
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked
 * @Author hylic
 * @Create 2023/8/24 22:17 做完 22:49
 * @Version 1.0
 */
public class merge {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        quickSort(intervals,0,intervals.length-1);
    }
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len==1) return intervals;
        quickSort(intervals,0,len-1);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(list.get(count-1)[1]>=intervals[i][0]) list.get(count-1)[1] = Math.max(list.get(count-1)[1],intervals[i][1]);
            else{
                list.add(intervals[i]);
                count++;
            }
        }
        return list.toArray(new int[count][]);
//        int[][] ret = new int[count][2];
//        for (int i = 0; i < count; i++) {
//            ret[i] = list.get(i);
//        }
//        return ret;
    }
    public static void quickSort(int[][] intervals,int left,int right){
        if (left>=right) return;
        int divide = intervals[left][0];
        int i = left+1;
        int j = right;
        while(i<=j){
            while(i<=j && intervals[i][0]<divide) i++;
            while(i<=j && intervals[j][0]>=divide) j--;
            if(i<j){
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }
        if(left!=j){
            int[] temp = intervals[left];
            intervals[left] = intervals[j];
            intervals[j] = temp;
        }
        quickSort(intervals,left,j-1);
        quickSort(intervals,j+1,right);
    }
}
