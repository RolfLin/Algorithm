package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 *
 * 思路：在全排列的思想基础上改进。先进行排序，然后遍历时判断当前是否为相同值元素的第一个，不是则跳过该次递归。
 */

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                // nums[i] == nums[i-1] && !used[i - 1] 保证了经过排序后，相同的值只有第一个会做排列的遍历
                // 因为按位置遍历时，第一个值先为true再往下走，满足遍历条件
                // 之后的值因为前一个的值都为false不满足条件，直接continue
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(a));
    }
}
