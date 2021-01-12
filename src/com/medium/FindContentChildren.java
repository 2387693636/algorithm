package com.medium;

import java.util.Arrays;

/**
 * 贪心思想保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
 *
 * 每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
 * 因为最小的孩子最容易得到满足，因此先满足最小孩子。给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。
 *
 * 假设在某次选择中，贪心策略选择给第 i 个孩子分配第 m 个饼干，并且第 i 个孩子满足度最小，
 * 第 m 个饼干为可以满足第 i 个孩子的最小饼干，利用贪心策略最终可以满足 k 个孩子。假设最优策略在这次选择中给 i 个孩子分配第 n 个饼干，
 * 并且这个饼干大于第 m 个饼干。我们发现使用第 m 个饼干去替代第 n 个饼干完全不影响后续的结果，因此不存在比贪心策略更优的策略，即贪心策略就是最优策略。
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
