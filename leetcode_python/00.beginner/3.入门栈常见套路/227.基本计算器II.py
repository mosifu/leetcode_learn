"""
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
整数除法仅保留整数部分。
你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。

示例 1：
输入：s = "3+2*2"
输出：7

示例 2：
输入：s = " 3/2 "
输出：1

示例 3：
输入：s = " 3+5 / 2 "
输出：5

提示：
1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个有效表达式
表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
题目数据 保证 答案是一个 32-bit 整数
"""

class Solution:
    def calculate(self, s: str) -> int:
        fix_s = s.replace(" ", "")  # 去除空格
        # 设置默认运算+
        pre_sign = "+"
        stack = []  # 栈，存储运算元素
        num = 0 # 定义当前遍历的数
        n = len(fix_s)
        for i in range(n):
            c = fix_s[i]
            if c.isdigit(): # 判断当前遍历的字符是不是数字
                # 因为字符是单个遍历，对于十位数或之上的位数时，
                # 如果连续遍历都是数字，则可以用上一步的num乘10+当前遍历的数来得到结果
                num = num * 10 + int(c)
            if not c.isdigit() or i==n-1:
                if pre_sign == "+":
                    stack.append(num)
                elif pre_sign == "-":
                    stack.append(-num)  # 存入的是负数
                elif pre_sign == "*":
                    # 拿出栈顶的元素进行相乘，然后移除，存入相乘后的
                    stack_top = stack.pop()
                    stack.append(stack_top * num)
                elif pre_sign == "/":
                    # 同样的需拿出栈顶元素相除后存入
                    stack_top = stack.pop()
                    stack.append(int(stack_top / num))
                pre_sign = c  # 记录前一步运算符
                num = 0 # 上面每一步运算符走完都需要把当前的元素清零
        return sum(stack)   # 因为减号相当于加负数，当时把负数存进去后，最后栈里数的结果就是累加和

if __name__ == '__main__':
    s = " 3+5 / 2 "
    print(Solution().calculate(s))