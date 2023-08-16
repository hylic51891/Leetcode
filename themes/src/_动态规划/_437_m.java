package _动态规划;

import java.util.HashMap;

/**
 * ClassName: _437_m
 * Package: _动态规划
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/2 23:02
 * @Version 1.0
 */
public class _437_m {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> preMap = new HashMap<Long,Integer>();
        preMap.put(0L,1);
        return pathSumRecursive(root,preMap,0,targetSum);
    }
    public static int pathSumRecursive(TreeNode root, HashMap<Long,Integer> preMap, long preSum, int targetSum){
        if(root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        preSum += root.val;
        if(preMap.containsKey(preSum - targetSum)){
            count += preMap.get(preSum - targetSum);
        }
        preMap.put(preSum,preMap.getOrDefault(preSum,0)+1);
        left = pathSumRecursive(root.left,preMap,preSum,targetSum);
        right = pathSumRecursive(root.right,preMap,preSum,targetSum);
        preMap.put(preSum,preMap.getOrDefault(preSum,0)-1);
        return left+right+count;
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}