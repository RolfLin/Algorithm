package nowCoder.binaryTree;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-13 17:26
 **/
public class HasSubTree {

    /**
     * 题目描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * 思路：嵌套递归，外层做A树的遍历，
     * 内层AB树一起遍历，判断A树当前节点为根节点的子树是否包含B，相同则继续往下遍历，
     * 只有达到B树遍历完了，而A树还没遍历完（或刚好也遍历完）的条件时，才说明A的子树含有B子树，
     * 否则当前节点返回false，A继续往下走，换孩子作为根节点与B重新做遍历。
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        // 空不是树的子结构
        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val == root2.val){
            result = theSameTree(root1, root2);
        }
        // result为false，A继续往下走
        if(!result){
            result = theSameTree(root1.left, root2);
        }
        if(!result){
            result = theSameTree(root1.right, root2);
        }
        return result;
    }

    public boolean theSameTree(TreeNode node1, TreeNode node2){
        // 遍历到root2为空时每个节点都相等，说明root1含有root2
        if(node2 == null){
            return true;
        }
        // root1为空，但root2不为空，说明root2不是1的子树
        if(node1 == null){
            return false;
        }
        // 每个节点都相同，才往下一起遍历
        if(node1.val != node2.val){
            return false;
        }
        // 根节点能对应，继续往孩子遍历判断
        return theSameTree(node1.left, node2.left) && theSameTree(node1.right, node2.right);
    }
}
