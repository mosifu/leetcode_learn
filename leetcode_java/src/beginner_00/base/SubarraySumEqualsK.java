package beginner_00.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // 使用前缀和+哈希表
        int[] pre_sums = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            pre_sums[i+1] = pre_sums[i] + nums[i];
        }
        // 创建集合,k为出现过的前缀和,value为出现过的次数
        Map<Integer, Integer> cache = new HashMap<>();
        int count = 0;
        for (int i_sum : pre_sums) {
            int other = i_sum - k;
            if (cache.containsKey(other)) {
                count += cache.get(other);
            }
            // 如果cache中没有存在当前的前缀和,则加入且计数为1,已存在的话计数+1
            cache.put(i_sum, cache.containsKey(i_sum) ? cache.get(i_sum) + 1 : 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1, 1}, 2));
    }
}
