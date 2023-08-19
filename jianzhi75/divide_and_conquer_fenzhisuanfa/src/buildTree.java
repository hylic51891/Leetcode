import java.util.HashMap;

;

/**
 * ClassName: buildTree
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/18 17:13
 * @Version 1.0
 */
public class buildTree {
    public int[] preorder;
    public int[] inorder;
    HashMap<Integer,Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null ||inorder==null) return new TreeNode();
        this.preorder = preorder;
        this.inorder = preorder;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return recur(0,0,inorder.length);
    }

    public TreeNode recur(int preStart,int inStart,int len) {
        if(preStart >= preorder.length) return null;
        if(len == 1 ) return new TreeNode(preorder[preStart]);
        /** 1 找根节点
         前序 1 N M
         中序 N 1 M
         中序节点和index放入hashmap,然后找前序的第一个节点所在下标
         */
        int rootIndex = inorderMap.get(preorder[preStart]);
        int leftLen = rootIndex-inStart;
        int rightLen = inStart+len-1-rootIndex;
        /** 2 分治算法
         * 分解成根节点的左右子节点子问题
         */
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = recur(preStart+1,inStart,leftLen);
        root.right = recur(preStart+leftLen,rootIndex+1,rightLen);
        return root;
    }

}
