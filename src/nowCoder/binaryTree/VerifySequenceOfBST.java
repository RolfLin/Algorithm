package nowCoder.binaryTree;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-16 16:47
 **/
public class VerifySequenceOfBST {
    /**
     * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     *
     * 思路：
     * 特点1. 二叉搜索树的左子树都小于根，右子树都大于根。
     * 特点2. 后序遍历，则遵循左右中原则，根节点在最后遍历
     * 因此可以从数组末尾根节点处，递归判断左右子树中，是否满足该特性，
     * 其中，子树左右孩子下标相遇时遍历完成，返回true
     *
     */


    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    /**
     * @param left 子树最左节点
     * @param right 子树根节点
     */
    public static boolean verify(int[] s, int left, int right){
        if(left >= right){
            return true;
        }
        // right为当前子树根节点
        int i = right;
        // 遍历到小于根的节点，说明该节点左侧为左子树
        while(i > left && s[i - 1] > s[right]){
            i--;
        }
        for(int j = i - 1;j >= left; j--){
            // 若左子树某节点大于根，说明不是二叉搜索树，返回false
            if(s[j] > s[right]){
                return false;
            }
        }
        // 左子树和右子树递归判断
        return verify(s, left, i - 1) && verify(s, i, right - 1);
    }
}
