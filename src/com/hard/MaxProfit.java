package com.hard;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 *
 * 提示：
 *
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 *
 *         当k大于等于数组长度一半时, 问题退化为贪心问题此时采用 买卖股票的最佳时机 II
 *         的贪心方法解决可以大幅提升时间性能, 对于其他的k, 可以采用 买卖股票的最佳时机 III
 *         的方法来解决, 在III中定义了两次买入和卖出时最大收益的变量, 在这里就是k租这样的
 *         变量, 即问题IV是对问题III的推广, t[i][0]和t[i][1]分别表示第i比交易买入和卖出时
 *         各自的最大收益
 *
 */
public class MaxProfit {
    public int getMaxProfit(int nums , int[] prices) {
        if(nums < 1) {
            return 0;
        }
        if (nums >= prices.length / 2) {
            return greedy(prices);
        }
        int[][] t = new int[nums][2];
        for(int i = 0; i < nums; ++i) {
            t[i][0] = Integer.MIN_VALUE;
        }
        for(int p : prices) {
            t[0][0] = Math.max(t[0][0], -p);
            t[0][1] = Math.max(t[0][1], t[0][0] + p);
            for(int i = 1; i < nums; ++i) {
                t[i][0] = Math.max(t[i][0], t[i-1][1] - p);
                t[i][1] = Math.max(t[i][1], t[i][0] + p);
            }
        }
        return t[nums-1][1];
    }

    private int greedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }

    /**
     * 数组：第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格
     * @param args
     */
    public static void main(String[] args){
        MaxProfit maxProfit = new MaxProfit();
        int maxProfit1 = maxProfit.getMaxProfit(2, new int[]{3,2,6,5,0,3});
        System.out.println(maxProfit1);
    }

}
