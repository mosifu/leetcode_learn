"""
这里有 n 个航班，它们分别从 1 到 n 进行编号。
有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。

示例 1：
输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]
解释：
航班编号        1   2   3   4   5
预订记录 1 ：   10  10
预订记录 2 ：       20  20
预订记录 3 ：       25  25  25  25
总座位数：      10  55  45  25  25
因此，answer = [10,55,45,25,25]

示例 2：
输入：bookings = [[1,2,10],[2,2,15]], n = 2
输出：[10,25]
解释：
航班编号        1   2
预订记录 1 ：   10  10
预订记录 2 ：       15
总座位数：      10  25
因此，answer = [10,25]
"""

class Solution:
    def corpFlightBookings(self, bookings: list[list[int]], n: int) -> list[int]:
        # 使用差分数组解决
        diff = [0] * (n+1)  # 定义数组diff长度为n+1(+1是为了防止last刚好为第n项航班时,diff[n]索引越界)用来收集，bookings列表中每一项对应的开始索引，和结束索引(即航班区间)的座位变化
        for first, last, seats in bookings:
            diff[first-1] += seats  # 航班n在diff中对应的索引为n-1,表示当前航班预定了多少个位置
            diff[last] -= seats # 直接是n,不用减1,因为题目中预定是左右都包含,所以n项截至的话,表示第n项也预定了座位(即diff[n-1]),然后后面的都没有(即从diff[n]和它之后)
        answer = [0] * n    # 定义返回的航班座位数
        current_seats = 0   # 当前航班的预定总数
        for i in range(n):
            answer[i] = current_seats + diff[i]
            current_seats = answer[i]
        return answer

