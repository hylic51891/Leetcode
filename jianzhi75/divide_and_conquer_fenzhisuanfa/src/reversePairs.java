/**
 * ClassName: reversePairs
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/18 22:21
 * @Version 1.0
 */


/** 归并排序
 *  TO 98%
 */
public class reversePairs {

    public int[] tmp;
    public int count = 0;
    /**
     归并排序：相邻逆序对交换，排序为升序数组之后，交换次数即为逆序对数量
     */
    /**
     终止条件：只有一个数，直接返回
     递归工作:
     1. 分别递归排序左右两个子数组
     2. 合并两个子数组
     i指向左数组起始，j指向右数组起始
     if(L[i] > R[j]) 逆序对+=n-i+1个，把R[j]放到最前面
     */
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        tmp = new int[nums.length];
        sort(nums,0,nums.length-1);
        return count;

    }

    /**
     * 双闭区间
     */
    public void sort(int[] nums,int low,int high){
        if(low>=high) return;
        int mid = low + (high-low)/2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    /**
     * 左闭右开，合并两个有序数组
     */
    public void merge(int[] nums,int low,int mid,int high){
        int index = low;
        System.arraycopy(nums,low,tmp,low,high-low+1);
        int leftIndex = low;
        int rightIndex = mid+1;
        while(leftIndex <= mid && rightIndex <= high){
            if(tmp[leftIndex] > tmp[rightIndex]){
                count+= (mid-leftIndex);
                nums[index++] = tmp[rightIndex++];
            }
            else{
                nums[index++] = tmp[leftIndex++];
            }
        }
//        while(leftIndex<mid){
//            nums[index++] = tmp[leftIndex++];
//        }
//        while(rightIndex<high){
//            nums[index++] = tmp[rightIndex++];
//        }
        if(leftIndex<=mid) System.arraycopy(tmp,leftIndex,nums,index,mid-leftIndex+1);
        else if (rightIndex<=high) System.arraycopy(tmp,rightIndex,nums,index,high-rightIndex+1);
    }
}
