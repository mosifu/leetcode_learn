"""
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
测试用例保证输出的长度不会超过 105。

示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"

示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"

示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"

示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"

提示：
1 <= s.length <= 30
s 由小写英文字母、数字和方括号 '[]' 组成
s 保证是一个 有效 的输入。
s 中所有整数的取值范围为 [1, 300]
"""

class Solution:
    def decodeString(self, s: str) -> str:
        # 遍历字符串，依次存入栈中(数字,字母,[),对于数字还需对多位数进行适配,
        # 然后遍历到]括号时,弹出字母拼接在一起,直到[出现,然后再弹出数字
        num = 0
        stack = []
        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            elif char == '[':
                stack.append(num)
                num = 0
                stack.append(char)
            elif char == ']':
                # 需弹出字母,然后拼接在一起
                str_stack = []  # 用来拼接字母的列表
                while stack:    # 栈一直有值
                    cur_str = stack[-1] # 栈顶元素
                    if cur_str == '[':
                        stack.pop() # 直到遇见右括号结束循环,并删除
                    elif isinstance(cur_str,int):   # 是数字
                        stack.pop()
                        rev_str_stack = str_stack[-1::-1]
                        rev_str = "".join(rev_str_stack)
                        stack.append(rev_str*cur_str)
                        break
                    else:
                        str_stack.append(stack.pop())   # 字母先添加进列表
            else:
                stack.append(char)
        return "".join(stack)


if __name__ == '__main__':
    s = Solution()
    print(s.decodeString("3[a]2[bc]"))

