import java.util.*;

/**
 * ClassName: levelOrder
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/6 17:01
 * @Version 1.0
 */
public class levelOrder {
    /** 广度有限搜索，迭代思路
     * 1 ms
     * 84.23%
     * 42.9 MB
     * 16.18%
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        int size = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        TreeNode node;
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> curLayer = new ArrayList<>();
            while(size-- > 0){
                node = queue.poll();
                if(node == null) continue;
                curLayer.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(!curLayer.isEmpty()) result.add(curLayer);
        }
        return result;
    }

    /** 递归思路,其实是BFS，把结果传递给每一层
     * 0 ms
     * 100%
     * 42.9 MB
     * 22.80%
     */
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        levelBST(res,root,0);
        return res;
    }
    // 对于当前node,需要知道在那一层
    public void levelBST(List<List<Integer>> result,TreeNode root,int level) {
        if(root == null) return;
        // 现在结果里面有多少层
        int size = result.size();
        // 结果还没有当前层，只会少一层
        if( level > size-1 ){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelBST(result,root.left,level+1);
        levelBST(result,root.right,level+1);
    }
}
