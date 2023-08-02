package _167_m;

/**
 * ClassName: Solution
 * Package: _167_m
 * Description:
 *
 * @Author hylic
 * @Create 2023/6/13 18:58
 * @Version 1.0
 */
public class Solution {
    // 暴力
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int remain;
        boolean flag = false;
        for (int i = 0;i < numbers.length-1;i++){
            index[0] = i;
            if(2*numbers[index[0]] > target) break;
            remain = target-numbers[index[0]];
            index[1] = i+1;
            while(index[1] < numbers.length && numbers[index[1]] <= remain){
                if(numbers[index[1]] == remain){
                    flag = true;
                    break;
                }
                index[1]++;
            }
            if(flag) break;
        }
        index[0]+=1;
        index[1]+=1;
        return index;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;
        int remain;
        boolean flag = false;
        for (index1 = 0;index1 < numbers.length-1;index1++){
            if(2*numbers[index1] > target) break;
            remain = target-numbers[index1];
            index2 = index1+1;
            while(index2 < numbers.length && numbers[index2] <= remain){
                if(numbers[index2] == remain){
                    flag = true;
                    break;
                }
                index2++;
            }
            if(flag) break;
        }

        return new int[]{index1+1,index2+1};
    }
}
