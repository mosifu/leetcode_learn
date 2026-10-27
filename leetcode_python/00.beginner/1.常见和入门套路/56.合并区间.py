"""
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

示例 3：
输入：intervals = [[4,7],[1,4]]
输出：[[1,7]]
解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
"""

class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        # 先排序,可以直接调用python内置的sort排序方式
        intervals.sort(key=lambda x: x[0])  # lambda 匿名函数,x是输入,x[0]是输出

        # 再合并
        res = []    # 接收合并后的数组
        index = 0   # 开始索引
        current_interval = intervals[0] # 当前比较数组
        while index + 1 < len(intervals):
            next_interval = intervals[index+1]
            if current_interval[1] >= next_interval[0]: # 当前数组的右边大于等于下一个数组的左边,说明重叠
                current_interval[1] = max(next_interval[1], current_interval[1])    # 比较当前两个数组的右边谁大,谁就是合并后的数组右边
            else:   # 不重叠,先把当前数组放在合并后数组中
                res.append(current_interval)
                current_interval = next_interval    # 将当前数组设置成下一个的,然后下次循环在进行比较
            index += 1

        # 因为最后一次不重叠情况的话就会直接退出,没有添加进入res中,所以需要额外执行
        res.append(current_interval)
        return res

if __name__ == '__main__':
    intervals = [[1,3],[2,6],[8,10],[15,18]]
    print(Solution().merge(intervals))
