package nowCoder.binaryTree;

import java.util.HashMap;

/**
 * Created by billlin on 2019/1/21
 */
public class ReConstructBinaryTree {

    /**
     * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */


    /*
        思路：
        每次通过先序拿到根节点，在中序数组中该节点左侧为左子树，右侧为右子树，将左右子树都建连接上，递归操作，直到叶节点。
    */

//      Definition for binary tree
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i =  0; i < in.length; i++){
            map.put(in[i], i);
        }

        TreeNode root = reBuildChild(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
        return root;
    }

    public TreeNode reBuildChild(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn, HashMap<Integer, Integer> map){
        if(startPre > endPre || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        int index = map.get(pre[startPre]);
        root.left = reBuildChild(pre, startPre + 1, startPre + (index - startIn), in, startIn, index - 1, map);
        root.right = reBuildChild(pre, startPre + (index - startIn) + 1, endPre, in, index + 1, endIn, map);

        return root;
    }
}
