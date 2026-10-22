"""
给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

示例 1：
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。

示例 2：
输入：target = 4, nums = [1,4,4]
输出：1

示例 3：
输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
"""


class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        # 使用滑动窗口(快慢指针)
        slow, fast = 0, 0
        my_sum = 0  # 快慢指针区间数之和
        min_len = float('inf')  # 设置无限大
        while fast < len(nums): # 快指针小于数组长度说明还未走完整个数组
            my_sum += nums[fast]    # 快慢指针都是从0开始,快指针优先行动且每次+1,那么区间总长就是快指针走过的数之和
            while my_sum >= target:
                min_len = min(min_len, fast - slow + 1) # 比较区间长度
                # 移动慢指针
                my_sum -= nums[slow]    # 针对慢指针+1之后又减一,可以在+1之前就减去对应索引的数值,减少混淆
                slow += 1
                # my_sum -= nums[slow-1]  # 慢指针移动后的位置-1即是要减去的索引对应的数

            # 慢指针达成最短区间之后,继续移动快指针
            fast += 1
        return min_len if min_len != float('inf') else 0
