package nowCoder.binaryTree;

import java.util.ArrayList;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-15 10:43
 **/
public class Mirror {
    /**
     * 题目描述：操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     * 思路：按左右孩子进行逐层递归遍历时，将左右孩子进行反转即可。
     * （即先反转再递归，也可以先递归再反转）
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public void Mirror(TreeNode root) {
            trade(root);
        }

        public void trade(TreeNode node) {
            if (node != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) {
                    trade(node.left);
                }
                if (node.right != null) {
                    trade(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
    }
}
