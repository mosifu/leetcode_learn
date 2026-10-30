"""
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]

示例 2:
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]

示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]
"""

class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        # 使用单调栈,创建一个栈来存温度列表索引,然后依次比较索引对应的温度是否大于上一次入栈的索引对应的温度
        # 若大于,则索引相减就是上一个温度遇到更高温度的时间间隔,然后移除比较过的,把当前温度索引放进栈里面
        stack = [0]  # 用来装温度索引的栈
        answer = [0] * len(temperatures)    # 返回的答案列表
        n = len(temperatures)
        # 进行比较
        for i in range(1,n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                answer[index] = i - index
            stack.append(i)
        return answer

if __name__ == '__main__':
    s = Solution()
    print(s.dailyTemperatures([73,74,75,71,69,72,76,73]))



