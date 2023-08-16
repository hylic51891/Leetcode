/**
 * ClassName: sortedArrayToBST
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/6 17:29
 * @Version 1.0
 */
public class sortedArrayToBST {
    /**
     * 每次插入的都是中点值，插入完成就变成平衡二叉树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode head = new TreeNode();
//        insert(head,nums,0,nums.length-1);
//        return head;
        return insert2(nums,0,nums.length-1);
    }

    /** 我的递归
     * 0 ms
     * 100.00%
     * 42.3 MB
     * 12.34%
     */
    public boolean insert(TreeNode root,int[] nums,int left,int right){
        if(left > right) return false;
        if(left == right){
            root.val = nums[left];
            return true;
        }
        int mid = left + (right-left)/2;
        root.val = nums[mid];
        root.left = new TreeNode();
        root.right = new TreeNode();
        if(!insert(root.left,nums,left,mid-1)) root.left = null;
        if(!insert(root.right,nums,mid+1,right)) root.left = null;
        return true;
    }
    /** 更简洁做法 时间复杂度O(n) 空间复杂度O(log2n) 每个数字访问一次，递归栈的深度是log2n
     * 0 ms
     * 100.00%
     * 42.3 MB
     * 12.34%
     */
    public TreeNode insert2(int[] nums,int left,int right){
        if(left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert2(nums,left,mid-1);
        root.right = insert2(nums,mid+1,right);
        return root;
    }
}
