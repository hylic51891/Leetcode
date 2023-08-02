package _88_E;

/**
 * ClassName: merge
 * Package: _88_E
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/2 15:39
 * @Version 1.0
 */
public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i = 0; i < m+n;i++){
                nums1[i] =  nums2[i];
            }
        }
        while(p1 < m || p2 <n ){
            if(p1 >= m){
                merge[index++] = nums2[p2++];
            }
            else if(p2>=n){
                merge[index++] = nums1[p1++];
            }
            else if(nums1[p1]<=nums2[p2]){
                merge[index++] = nums1[p1++];
            }
            else{
                merge[index++] = nums2[p2++];
            }
        }
        for(int i = 0; i < m+n;i++){
            nums1[i] =  merge[i];
        }
    }
    // 尾部指针
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1;
        int p2 = n-1;
        int index = m+n-1;
        while(p1 >= 0 || p2 >=0 ){
            if(p1 < 0){
                nums1[index--] = nums2[p2--];
            }
            else if(p2 < 0){
                nums1[index--] = nums1[p1--];
            }
            else if(nums1[p1]>=nums2[p2]){
                nums1[index--] = nums1[p1--];
            }
            else{
                nums1[index--] = nums2[p2--];
            }
        }
    }
}
