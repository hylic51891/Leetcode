package array;

import java.util.*;

/**
 * ClassName: array.rotate
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 16:28
 * @Version 1.0
 */
public class rotate {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] nums = new int[]{1,2};
        rotate3(nums,3);
        for (int num:
             nums) {
            System.out.print(num);
            System.out.print(",");
        }
    }
    /*
    1. 切分字符串，然后重新concat，然后写回去
    2. 放到queue,一共pop和pushK次，转回字符串
    3. 反转，再分别反转前后两段
    4. 原地算法：
        做K次，元素依次替换+k的位置的元素
        1. 长度能整除K，则做K次，
        2. 不能整除，则一直替换元素，直到落在第length%k个元素为止
    */

    // 环形：时间超过限制，数据量大用arraylist不行
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if(k == 0 || length == 1 || length == 0){
            return;
        }
        int res = length%k;
        int targetIndex = 0;
        int putNum = 0;
        int tempNum = 0;
//        boolean[] visited = new boolean[length];
        List<Integer> visited = new ArrayList<Integer>();
        targetIndex = 0;
        putNum = nums[0];
        while(visited.size()!= length){
            targetIndex = (targetIndex+ k) % length;
            if(visited.contains(targetIndex)){
                targetIndex =(targetIndex+ 1) % length;
                putNum = nums[targetIndex];
            }
            else{
                tempNum = nums[targetIndex];
                nums[targetIndex] = putNum;
                visited.add(targetIndex);
                putNum = tempNum;
            }
        }
    }
    // 环形：用数组维护是否访问过
    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        if(k == 0 || length == 1 || length == 0){
            return;
        }
        int targetIndex = 0;
        int putNum = 0;
        int tempNum = 0;
        boolean[] visited = new boolean[length];
//        List<Integer> visited = new ArrayList<Integer>();
        targetIndex = 0;
        putNum = nums[0];
        // 总共做length次替换
        for(int i = 0;i< length;i++){
            targetIndex = (targetIndex+ k) % length;
            if(visited[targetIndex]){
                targetIndex =(targetIndex+ 1) % length;
                putNum = nums[targetIndex];
                i--;
            }
            else{
                tempNum = nums[targetIndex];
                nums[targetIndex] = putNum;
                visited[targetIndex] = true;
                putNum = tempNum;
            }
        }
    }
    // 多次反转
    public static void rotate3(int[] nums, int k){
        int length = nums.length;
        if(k == 0 || length == 1 || length == 0){
            return;
        }
        k = k%length;
        swap(nums,0, length-1);
        swap(nums,0, k-1);
        swap(nums,k, length-1);
    }
    public static void swap(int[] nums,int start, int end){
        int i = start;
        int j = end;
        int temp;
        while(i<j){
            temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
