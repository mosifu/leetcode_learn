package beginner_00.base_array_1.array_code;
/*
 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

提示：
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
 */

import java.util.HashMap;
import java.util.Map;

class TwoSum{
    public int[] twoSum1(int[] nums, int target) {
        // 循环遍历求解
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++ ){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        // 使用哈希表求解
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 当前遍历对象,对应的目标值
            int other = target - nums[i];
            // 判断是已存在map中
            if (cache.containsKey(other)) {
                return new int[]{i, cache.get(other)};
            }
            cache.put(nums[i], i);
        }
        return new int[]{};
    }
}