"""
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
子数组是数组中元素的连续非空序列。

示例 1：
输入：nums = [1,1,1], k = 2
输出：2

示例 2：
输入：nums = [1,2,3], k = 3
输出：2
"""
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # 使用前缀和+哈希表方式实现
        # pre_sums[i] 表示 nums 前 i 个元素的和
        # pre_sums[0] = 0，表示前 0 个元素的和
        # 因此前缀和数组的长度比 nums 多 1
        pre_sums = [0] * (len(nums)+1)
        for i in range(len(nums)):
            pre_sums[i+1] = pre_sums[i] + nums[i]
        # 寻找子数组的和为k出现的次数即可以判断前缀和数组中是否直接存在对应索引等于k的(为nums前n项的子数组)
        # 或者寻找有没有pre_sums[j]-pre_sums[i](len[pre_sums]-1>=j>i>=0)的即对应nums[j-1]+...nums[i]
        # 使用前缀和 + 哈希表统计和为 k 的子数组个数
        # 子数组 nums[j:i] 的和 = pre_sums[i] - pre_sums[j]
        # 若子数组的和为 k，则 pre_sums[j] = pre_sums[i] - k
        # 因此，只需查找当前前缀和减去 k 的值是否在历史前缀和中
        cache = {}  # k为前缀和,value该前缀和此前出现的次数
        count = 0
        # 遍历前缀和数组找到满足目标值的区间
        for i, i_num in enumerate(pre_sums):
            other = i_num - k   # 当前前缀和-目标k,如果这个值存在前缀和数组中,满足满足条件,可以找到区间nums
            if other in cache:
                # 若存在匹配的历史前缀和，
                # 每出现一次匹配，就找到一个和为 k 的子数组
                count += cache[other]
            cache[i_num] = cache.get(i_num, 0) + 1  # 第i项前缀和,如果不存在就存入初始化然后+1,存在的话直接+1

        return count

if __name__ == '__main__':
    s = Solution()
    print(s.subarraySum([1,1,1], 2))


