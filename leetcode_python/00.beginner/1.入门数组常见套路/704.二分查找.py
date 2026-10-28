"""
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
你必须编写一个具有 O(log n) 时间复杂度的算法。

示例 1:
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4

示例 2:
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
"""

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        # 使用二分查找来解决,先定义左右指针(采取左闭右开的原则,右指针取区间长度对应的索引就是区间索引+1,为右开),还有计算中间指针
        left, right = 0, len(nums)
        mid = (left +right) // 2    # 左闭右开区间的中间指针索引即为左右指针相加整除2
        while left < right:
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                # 中间指针对应元素小于目标值,说明目标值偏右,把左指针移动到
                # 原中间指针那(因为中间指针已经确认不满足条件了,区间又是左闭右开的,所以左指针移动的时候需要+1),然后跟新中间指针
                left = mid + 1
            else:
                right = mid # 如果中间值大于目标值,说明在左边,移动右指针到中间指针位置,因为右指针为开,且中间指针已经被排除,所以直接取中间指针值就行
            mid = (right + left) // 2  # 重新计算中间指针
        return -1