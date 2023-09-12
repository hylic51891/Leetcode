package 模板.排序;

/**
 * ClassName: heapSort
 * Package: 模板.排序
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/8 14:52
 * @Version 1.0
 */
public class heapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4,6,4,789,6,4,3,374,568,778,7,323,5,2,21,6,352,789,5};
        new heapSort().heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
    public void heapSort(int[] nums){
        int len = nums.length;
        // 对当前序列建立顺序存储的完全二叉树，构建大根堆
        buildHeap(nums,len-1);
        // 依次把最后一个元素和头元素互换，然后在无序段重构二叉树
        for(int i = len-1;i>=1;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums,0,i-1);
        }

    }
    // 构建大根堆
    public void buildHeap(int[] nums,int end){
        // 1. 每个节点和他的左右子节点比较：位置i的节点的左右子节点位置是2i+1和2i+2
        // 2. 从底向上构建，先保证下面的是堆，再把前面的数加入堆中，调整为堆

        // 最后一个元素的父节点位置在(end-1)/2 或 (end-2)/2,如果当前节点是右节点，-1和-2向下取整没区别，如果是左节点，则只能-1
        for (int i = (end - 1) / 2; i >= 0; i--) {
            adjust(nums, i, end);
        }
    }
    // 调整堆，从上自下调整。调整堆时，除了堆顶元素，其余的都满足堆的性质，所以从上向下把较大的元素移到上面
    public void adjust(int[] nums,int start,int end){
        int maxIndex,left,right;
        // 只需要遍历所有的父节点，就可以完成调整
        for (int i = start; i <= (end - 1) / 2; i++) {
            maxIndex = i;
            left = 2*i+1;
            right = 2*i+2;
            if(left <= end && nums[maxIndex] < nums[left]) maxIndex=left;
            if(right <= end && nums[maxIndex] < nums[right]) maxIndex=right;
            if(maxIndex!=i){
                int temp = nums[i];
                nums[i] = nums[maxIndex];
                nums[maxIndex] = temp;
            }
        }
    }
}
