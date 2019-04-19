package middle.dp;


/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 思路：当前的sum大于零时，对于后面的子序列和有利，继续叠加；否则，后面的子序列肯定不包含当前序列，省略掉，令sum = num;
 * 最后，取res和sum的最大者
 */

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }else if(nums.length == 1) {
            return nums[0];
        }

        int sum = 0;
        int res = nums[0];
        for(int num : nums) {
            if(sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,3,1,3};
        System.out.println(maxSubArray(arr));
    }
}
