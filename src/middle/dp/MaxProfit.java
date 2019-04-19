package middle.dp;

/**
 * 题目：121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * 思路：动态规划。前i天的收益 = max{前i-1天的收益，当天价格-前i-1天的最小价格}
 */

public class MaxProfit {

//     public int maxProfit(int[] prices) {
//         int min = 0,max = 1;
//         int ba = 0;
//         if(prices.length == 0 || prices.length == 1) {
//             return 0;
//         }
//         for(int i = 1; i < prices.length; i++) {
//             if(prices[i] < prices[min]) {
//                 min = i;
//                 max = max < min ? min : max;
//             }else if(prices[i] >= prices[max] && i > min) {
//                 max = i;
//                 int tmp = prices[max] - prices[min];
//                 ba = tmp > ba ? tmp : ba;
//             }
//         }
//         return ba;
//     }

    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int minP = prices[0];
        for(int i = 1; i < prices.length; i++) {
            // 当前价格 - 前i-1天的最小价格
            int tmp = prices[i] - minP;
            max = tmp > max ? tmp : max;
            minP = minP < prices[i] ? minP : prices[i];
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
