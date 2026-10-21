"""
给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列。
请你从数组中找出满足相加之和等于目标数 target 的 两个 数。令这两个数分别是 numbers[index1] 和 numbers[index2] ，其中 1 <= index1 < index2 <= numbers.length 。
以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
你所设计的解决方案必须只使用常数级的额外空间。

示例 1：
输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。

示例 2：
输入：numbers = [2,3,4], target = 6
输出：[1,3]
解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。

示例 3：
输入：numbers = [-1,0], target = -1
输出：[1,2]
解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。

提示：
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers 按 非递减顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案
"""


class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        # 模仿1的解法-使用哈希表(不符合题目要求"所设计的解决方案必须只使用常数级的额外空间。")
        cache: dict[int, int] = {}
        for index, num in enumerate(numbers):
            other: int = target - num
            if other in cache:
                # 因为numbers是从小到大排列的，且要求返回的列表的索引是从小到大,所以当前的索引index一定会比已经存在cache中的索引大
                return [cache[other]+1, index+1]    # numbers 下标从1开始
            cache[num] = index

        return []

    def twoSum2(self, numbers: list[int], target: int) -> list[int]:
        # 在只使用常数级空间的情况下,针对题目说到的"数组已按 非递减顺序排列"可以考虑使用双指针+while循环的方式找到满足目标的数的下标
        left =  0               # 左指针
        right = len(numbers)-1  # 右指针
        while left != right:
            my_sum = numbers[left] + numbers[right]
            if my_sum == target:
                return [left+1, right+1]
            elif my_sum < target:
                # 数组是递增的,当最左边+最右边小于目标值时,则左指针需要向右移动
                left += 1
            elif my_sum > target:
                right -= 1
        return []