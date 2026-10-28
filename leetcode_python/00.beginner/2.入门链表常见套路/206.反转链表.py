"""
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

示例 2：
输入：head = [1,2]
输出：[2,1]

示例 3：
输入：head = []
输出：[]
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList1(self, head: ListNode | None) -> ListNode | None:
        # 创建一个新链表来接收
        # 创建当前节点指向
        cur = None
        while head != None:
            cur = ListNode(head.val, cur)
            head = head.next
        return cur


    def reverseList2(self, head: ListNode | None) -> ListNode | None:
        # 原地翻转
        # 定义一个指针来接收翻转时上一步指针指向
        pre = None
        while head != None:
            next = head.next    # 下一步指针用来接收头指针得移动
            head.next = pre     # 头指针指向翻转
            pre = head          # 上一步指针移动
            head = next         # 头指针移动
        return pre