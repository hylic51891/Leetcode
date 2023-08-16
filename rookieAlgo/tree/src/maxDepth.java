import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: maxDepth
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/6 14:41
 * @Version 1.0
 */
public class maxDepth {
    /**
     * 递归，DFS
     */
    public int maxDepth(TreeNode root) {
        int leftDepth;
        int rightDepth;
        if(root == null) return 0;
        else{
            leftDepth = maxDepth(root.left);
            rightDepth = maxDepth(root.right);
        }
        return 1+((leftDepth>rightDepth)?leftDepth:rightDepth);
    }

    /** 尝试 广度优先算法 BFS
     * 1. 用queue维护当前层的节点 FIFO
     * 2. 流程：获得当前queue的大小。queue.pop取出当前层的节点，如果子节点不为null，就放入queue
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return 0;

        queue.add(root);
        int size = 0;
        int depth = 0;
        TreeNode curNode = new TreeNode();
        while(!queue.isEmpty()){
            size = queue.size();
            while(size-- > 0){
                curNode = queue.poll();
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
