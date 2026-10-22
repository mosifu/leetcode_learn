package hot_100.base;

/**704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        // 使用二分查找,设置左右指针（左闭右开）和中间指针
        int left = 0, right = nums.length;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 中间值小于目标值说明偏右，移动左指针
                left = mid + 1; // 左闭右开，因为中间值已经被排除，所以移动到中间值的下一位
            } else {
                // 中间值大于目标值，说明偏左，移动右指针
                right = mid;    // 右开区间，正好移动到中间值那里，不包括中间值
            }
            mid = (right + left) / 2;   //移动后重新计算中间值
        }
        return -1;  // 不满足返回-1
    }
}
