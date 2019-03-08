package nowCoder.binaryTree;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-26 10:19
 **/

public class GetNext {
    /**
     * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * 思路：画图找规律。发现有三种情况
     * 1. 节点有右子树，则找到右子树最左节点即为next
     * 2. 节点无右子树，且是父节点的左孩子，则父节点就是next
     * 3. 节点无右子树，且是父节点的右孩子，则往父节点找，直到某个节点是其父节点的左孩子（同2），
     * 该父节点为next。
     */

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode != null){
            if(pNode.right != null){
                TreeLinkNode cur = pNode.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                return cur;
            }else if(pNode.next != null){
                if(pNode == pNode.next.left){
                    return pNode.next;
                }else{
                    TreeLinkNode cur = pNode;
                    while(cur.next != null){
                        if(cur.next.left == cur){
                            return cur.next;
                        }
                        cur = cur.next;
                    }
                }
            }
        }
        return null;
    }
}
