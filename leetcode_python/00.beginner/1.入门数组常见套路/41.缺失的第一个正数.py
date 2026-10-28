"""
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

示例 1：
输入：nums = [1,2,0]
输出：3
解释：范围 [1,2] 中的数字都在数组中。

示例 2：
输入：nums = [3,4,-1,1]
输出：2
解释：1 在数组中，但 2 没有。

示例 3：
输入：nums = [7,8,9,11,12]
输出：1
解释：最小的正数 1 没有出现。
"""

class Solution:
    def firstMissingPositive(self, nums: list[int]) -> int:
        # 原地哈希+加交换排序
        # nums从第一位开始判断,判断当前索引对应的元素值是不是索引+1(0 -> 1, 1 -> 2,类似归档一样)
        # 如果是的话,索引移动下一位再进行判断,如果不是,判断当前元素是否有对应的索引下标(元素值-1),有的话进行交换
        # 没有的话,索引下标又进行移动,直到遍历完整个列表,得到排好序的列表
        # 然后在进行一个循环,查找没有归位的索引,即为缺失的第一个正整数(索引+1)
        i = 0   # 设置开始的索引下标
        while i < len(nums):
            curr_num = nums[i]
            if curr_num == i+1:
                # 属于归位状态,下标进行移动
                i += 1
            else:
                # 未归位状态,需判断对应的值,是否满足可以交换的条件(1<=nums[i]<=len(nums))
                if 1 <= curr_num <= len(nums) and nums[i] != nums[curr_num-1]:  # 需要交换的两个值不能相同
                    # 说明可以交换,当前的索引对应的值与值-1对应索引位置的元素进行交换
                    # exchange_num = nums[curr_num-1] # 待交换的索引对应的值
                    # nums[i] = exchange_num  # 当前索引存放交换后的值
                    # nums[curr_num-1] = curr_num # 当前索引对应原来的值交换过去
                    nums[curr_num-1], nums[i] = nums[i], nums[curr_num-1]   # 解包操作
                else:
                    # 说明当前值没有找到满足的区间索引下标,位置不变,下标继续移动
                    i += 1
        for i in range(len(nums)):
            if nums[i] == i+1:
                pass
            else:
                return i+1
        return len(nums)+1




