"""
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
"""
class Solution1:
    # 暴力遍历求解
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        for i, item in enumerate(nums):
            for j in range(i+1, len(nums)):
                post = nums[j]
                if item + post == target:
                    return [i, j]
        return []

class Solution2:
    # 使用哈希表
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        # 设置字典来存
        cache = {}
        for i, item in enumerate(nums):
            cache[item] = i

        for i, item in enumerate(nums):
            other = target - item
            # 目标值-当前的值 = 需要找的另外一个数,判断那个数是否在字典的key中,如果在且对应的原列表nums的索引不是自己,就是要找的数
            if other in cache.keys() and i != cache[other]:
                return [i, cache[other]]
        return []

class Solution3:
    # 在单次遍历的时候就进行查找,查找之前遍历存的值是否有符合条件的,没有的话把当前的值存进去,然后在遍历下一个
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        cache = {}
        for i, item in enumerate(nums):
            other = target - item   # 目标值
            if other in cache:
                return [i, cache[other]]

            cache[item] = i
        return []
