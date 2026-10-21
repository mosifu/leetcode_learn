package hot_100.base;

/**209.长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int target, int[] nums) {
        int fast = 0, slow = 0, sum = 0; // 定义快慢指针和区间总和
        int min_len = Integer.MAX_VALUE;    // 区间最小长度,默认初始化为最大值
        while (fast < nums.length) {
            sum += nums[fast];
            while (sum >= target) {
                min_len = Integer.min(min_len, fast-slow+1);    // 取区间数总和大于目标值的区间长度
                sum -= nums[slow];  // 慢指针移动后需要减去不在区间的数
                slow += 1;   // 慢指针移动
            }
            fast += 1;  // 移动快指针
        }
        return min_len != Integer.MAX_VALUE ? min_len : 0;
    }
    
}
