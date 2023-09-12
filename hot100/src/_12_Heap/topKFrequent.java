package _12_Heap;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassName: topKFrequent
 * Package: _12_Heap
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/8 19:23
 * @Version 1.0
 */
public class topKFrequent {
    Map<Integer,Integer> map = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int size = map.size();
        int[] list = new int[size];
        Set<Integer> keySet = map.keySet();
        int index = 0;
        for(int key:keySet){
            list[index++] = key;
        }
        buildHeap(list,0,size-1);
        int[] res = new int[k];
        index = 0;
        for(int i = size-1;i>=size-k;i--){
            res[index++] = list[0];
            list[0] = list[i];
        }
        return res;
    }

    public void buildHeap(int[] list, int start,int end){
        for(int i = (end-1)/2;i>=start;i--){
            adjust(list,i, end);
        }
    }

    public void adjust(int[] list, int start,int end){
        int maxValueIndex = start;
        int left = 2*maxValueIndex +1;
        int right = 2*maxValueIndex +2;

        if(left<=end && map.get(list[maxValueIndex]) < map.get(list[left])) maxValueIndex = left;
        if(right<=end && map.get(list[maxValueIndex]) < map.get(list[right])) maxValueIndex = right;

        if(maxValueIndex!=start){
            int temp = list[start];
            list[start] = list[maxValueIndex];
            list[maxValueIndex] = temp;
            adjust(list,maxValueIndex,end);
        }
    }
}
