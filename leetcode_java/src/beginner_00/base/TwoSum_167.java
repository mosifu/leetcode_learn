package beginner_00.base;

import java.util.HashMap;
import java.util.Map;

/**167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列。
 * 请你从数组中找出满足相加之和等于目标数 target 的 两个 数。令这两个数分别是 numbers[index1] 和 numbers[index2] ，其中 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常数级的额外空间。
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 */
public class TwoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        // 使用哈希表来实现（不符合题目要求“所设计的解决方案必须只使用常数级的额外空间。”）
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];    // 当前索引对应的另一个满足target的数
            if (cache.containsKey(other)) {
                return new int[]{cache.get(other)+1, i+1};
            }
            cache.put(numbers[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] numbers, int target) {
        // 使用双指针,不引入其他数据结构
        int left = 0;
        int right = numbers.length - 1;
        while (left != right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return new int[]{};
    }

}
