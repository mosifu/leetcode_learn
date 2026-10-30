"""
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。

示例 1：
输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([])"
输出：true

示例 5：
输入：s = "([)]"
输出：false

提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
"""

class Solution:
    def isValid(self, s: str) -> bool:
        # 使用栈的思想,遇到左括号的时候存入栈,遇到右括号的时候,把存的左括号按最近存入取出(栈-后进先出),然后配对
        stack = []
        # 给左右括号做配对
        map_str : dict[str, str] = {"(": ")", "[": "]", "{": "}"}
        for char in s:
            if char in map_str.keys():  # 如果是左括号,存入列表
                stack.append(char)
            else:   # 先判断列表是否存在元素
                if not (stack and char == map_str[stack.pop()]):
                    # 列表为空，或者左右括号不匹配
                    return False
        if stack:
            return False
        return True

if __name__ == '__main__':
    s = Solution()
    print(s.isValid("()[]{}"))