package beginner_00.base_array_1.array_code;

/**41.缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 */

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        // 原地哈希+交换(常数级空间)
        int i = 0;  // 设置开始索引
        while (i < nums.length) {
            int curr_num = nums[i]; // 当前索引对应的值
            if (1 <= curr_num && curr_num <= nums.length && curr_num != nums[curr_num-1]) {
                // 当前索引对应的值在1-n之间,且不等于需要交换的值
                int target = nums[curr_num-1];
                nums[i] = target;
                nums[curr_num-1] = curr_num;
            } else {
                i++;
            }
        }
        // 上面while循环跑完一遍拍好序了,然后进行遍历,查看哪个位置没有(索引+1=索引对应元素值)归档
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                return j+1;
            }
        }
        return nums.length+1;
    }
}
