package array;

import java.util.*;

/**
 * ClassName: array.intersect
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 18:41
 * @Version 1.0
 */
public class intersect {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2,2};
        int[] nums2 = new int[]{2,2,1,1,1,1};
        int[] nums3 = intersect(nums1,nums2);
        for (int num:
                nums3) {
            System.out.print(num);
            System.out.print(",");
        }
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0 || len2 == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        HashMap<Integer,Integer> map2 = new HashMap<>();
        ArrayList<Integer> result= new ArrayList<>();
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{   // 相等：都出现
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] re = new int[result.size()];
        for(int k = 0;k < result.size();k++){
            re[k] = result.get(k);
        }
        return re;
    }
}
