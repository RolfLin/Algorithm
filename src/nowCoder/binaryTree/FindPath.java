package nowCoder.binaryTree;

import java.util.ArrayList;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-19 10:08
 **/
public class FindPath {
    /**
     * 题目描述：
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     *
     * 思路1：（不好）按左右孩子递归遍历，到叶节点时判断是否符合路径要求，符合则加入到全局list中。
     * 存在问题是，需要每轮都新建list空间存储当前路径，否则会因为引用而使用了同一个list
     *
     * 思路2：深度遍历。只需要利用一个全局list记录路径，随着遍历过程进行节点的添加和回退，
     * 注意在list路径加入res（所有路径的结果）时，需要new一个list加入，不然后续引用会修改list
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    static ArrayList<ArrayList<Integer>> res = new ArrayList();
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if(root == null){
            return res;
        }
        ArrayList<Integer> cur = new ArrayList();
        accumulate(root, cur, 0, target);
        return res;
    }

    static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> findPath2(TreeNode root,int target) {
        if(root == null){
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            // 防止list被后续引用后修改值，new一个list
            res.add(new ArrayList<Integer>(list));
        }
        findPath2(root.left, target);
        findPath2(root.right, target);
        // 深度遍历，回退父节点
        list.remove(list.size() - 1);
        return res;
    }


    public static void accumulate(TreeNode node, ArrayList<Integer> list, int sum, int k){
        if(node != null){
            ArrayList<Integer> cur = (ArrayList<Integer>)list.clone();
            cur.add(node.val);
            sum += node.val;
            if(node.left == null && node.right == null && sum == k){
                if(res.size() == 0){
                    res.add(cur);
                }else{
                    int i = 0;
                    while(i < res.size() && cur.size() < res.get(i).size()){
                        i++;
                    }
                    res.add(i, cur);
                }
                return;
            }
            accumulate(node.left, cur, sum, k);
            accumulate(node.right, cur, sum, k);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        findPath(node, 22);
        System.out.println(res.size());
    }
}
