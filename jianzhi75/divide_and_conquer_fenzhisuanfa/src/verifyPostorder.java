/**
 * ClassName: verifyPostorder
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/18 20:13
 * @Version 1.0
 */
public class verifyPostorder {
    public static void main(String[] args) {
        int[] postorder = new int[]{4,6,7,5};
        int[] postorder2 = new int[]{179, 437, 1405, 5227, 8060, 8764, 8248, 4687, 3297, 13038, 12691, 15744, 16195, 15642, 19813, 17128, 21051, 20707, 22177, 21944, 23644, 23281, 19970, 23652, 26471, 31467, 33810, 32300, 33880, 27334, 25987, 35643, 35103, 36489, 42534, 42990, 42942, 37090, 36075, 34516, 16624, 11335, 10737, 44641, 45754, 47096, 46021, 49150, 48013, 49814, 51545, 52555, 50701, 47875, 56783, 57558, 53812, 62008, 61737, 63052, 63478, 62799, 59246, 64765, 64066, 63862, 65384, 67449, 66552, 57741, 45618, 44412, 667, 69718, 75519, 76819, 72971, 79319, 78145, 80615, 84280, 80984, 86598, 85903, 84334, 80867, 87993, 92361, 88465, 87738, 80364, 94380, 94446, 96785, 93694, 76847, 99655, 98675, 97001, 72112};
        System.out.println(new verifyPostorder().verifyPostorder(postorder2));
    }
    public int[] postorder;
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0) return false;
        this.postorder = postorder;
        return recur(0,postorder.length-1);
    }

    public boolean recur(int start,int end) {
        /** 后序遍历
         1. 最后一个节点是根节点
         2. 右子树都大于root
         3. 左子树都小于root
         递归：
         1.先左后右，找到第一个大于根节点的下标
         2.判断之后有无小于根节点的值，有则返回false;
         3.判断两个子树是否符合条件
         */

        /** 终止条件
        start==end 子树只有一个节点，return true
         start>end 超出边界 return false
         */
        if(start==end) return true;
        else if (start > end) return false;
        int val = postorder[end];
        int index = -1;
        for (int i = start; i <= end; i++) {
            if(postorder[i] >= val){
                index = i;  // 第一个大于等于根节点的index
                break;
            }
        }
        for (int i = index+1; i < end; i++) {
            if(postorder[i] < val){
                return false;
            }
        }
        // index == end 全小于,只有一个子树
        // index == 0 全大于，只有一个子树
        if(index == start || index == end) return recur(start,end-1);
        return recur(start,index-1) && recur(index,end-1);
    }

    /** 简洁写法
     *
     */
    public boolean recur2(int i,int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur2(i, m - 1) && recur2( m, j - 1);

    }
}
