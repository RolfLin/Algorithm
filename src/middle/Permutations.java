package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：全排列问题。
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 *
 * 思路：回溯法。每轮排列完成后，返回上层递归前，将当前排列的末尾移除，用来方便上一层递归接着往下走，类似于深度搜索。
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                System.out.print(tempList + " ");
                tempList.remove(tempList.size() - 1);
                System.out.println(tempList);
            }
        }
    }


    public static void set(List<Integer> l, int i) {
        l.add(i);
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] a = new int[]{1,2,3};
        List<List<Integer>> list = permutations.permute(a);
//        for(List<Integer> l : list) {
//            System.out.println(l);
//        }


        List<Integer> list1 = new ArrayList<>();
        set(list1, 1);
        set(list1, 2);
        System.out.println(list1.size());
    }
}
