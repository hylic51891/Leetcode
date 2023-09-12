package _10_binarySearch;

/**
 * ClassName: findMedianSortedArrays
 * Package: _10_binarySearch
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/6 12:09
 * @Version 1.0
 */
public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        new findMedianSortedArrays().findMedianSortedArrays(nums1,nums2);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;


    }
    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2,int k){
        int length1 = end1 - start1 +1;
        int length2 = end2 - start2 +1;
        if(length1 > length2) return getKth(nums2,start2,end2,nums1,start1,end1,k);

        if(length1 <= 0) return nums2[start2+k-1];
        if(k == 1) return Math.min(nums1[start1],nums2[start2]);

        int i = start1+Math.min(length1,k/2) -1;
        int j = start2+Math.min(length2,k/2) -1;
        if(nums1[i]  > nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k - (j-start2+1));
        }
        else{
            return getKth(nums1,i+1,end1,nums2,start2,end2,k - (i-start1+1));
        }
    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays2(B, A);
        }
        /** m中的间隔位置i,可选0-m , n中的间隔位置j,可选0-n
         * A[i-1]指向左半边的最大值，A[i]指向右半边的最小值
         * B[j-1]指向左半边的最大值，B[j]指向右半边的最小值
         *
         * 前置条件：
         * 满足 i+j = m-i + n-j;
         * j = (m+n)/2 -i;
         * 统一奇偶 j = (m+n+1)/2 -i;
         * 中位数条件：
         * 右部分的最大小于左部分的最小
         * max(A[i-1],B[j-1]) <= min(A[i],B[j])
         */
        int iMin = 0;
        int iMax = m;
        int i = 0;
        int j = 0;
        while (iMin <= iMax) {
            i = iMin + (iMax - iMin) / 2;
            j = (m + n + 1) / 2 - i;  // 总数为奇数时，左半部分的长度比右半部分大 1
            // 没有到边界，且i需要减小
            if (i != 0 && j != n && A[i - 1] > B[j]) {
                iMax = i - 1;
            }
            // 没有到边界，且i需要增大
            else if (i != m && j != 0 && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else {   // 满足条件
                int leftMax;

                if (i == 0) leftMax = B[j - 1];  // i切在最左边
                else if (j == 0) leftMax = A[i - 1]; // j切在最左边
                else {   // 非边界找到有效i
                    leftMax = Math.max(A[i - 1], B[j - 1]);
                }
                // 如果为奇数，取左半边的最大值即为结果
                if ((m + n) % 2 == 1) return 1.0 * leftMax;

                int rightMin;
                if (i == m) rightMin = B[j];
                else if (j == n) rightMin = A[i];
                else {
                    rightMin = Math.min(A[i], B[j]);
                }
                // 如果为偶数，取左半边的最大值和右半边最小值的平均
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}
