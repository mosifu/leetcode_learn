"""
给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

提示：
0 <= s.length <= 105
s 由英文字母、数字、符号和空格组成
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 使用滑动窗口
        left, right = 0, 0  # 设置左右两个指针
        max_set = set() # set集合用来装区间字符
        max_len = 0 # 区间最大长度
        while right < len(s):
            if s[right] in max_set: # 如果当前索引对应的字符串字符在set集合内
                max_set.remove(s[left])    # 移除左指针对应的字符,然后左指针往前移动
                left += 1

            else:
                max_set.add(s[right])   # 当前字符不在区间添加进去
                max_len = max(max_len, len(max_set))    # 区间长度取最长的
                right += 1  # 右指针继续往前移动
        return max_len