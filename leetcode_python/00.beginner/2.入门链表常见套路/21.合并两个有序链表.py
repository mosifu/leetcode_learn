"""
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

示例 2：
输入：l1 = [], l2 = []
输出：[]

示例 3：
输入：l1 = [], l2 = [0]
输出：[0]

提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: ListNode | None, list2: ListNode | None) -> ListNode | None:
        # 使用虚拟头节点,初始化一个节点
        dummy = ListNode()
        # 定义一个当前指针先指向虚拟头节点
        current = dummy # 此时current.next = dummy
        while list1 is not None and list2 is not None:
            # 比较指针list1与list2谁小谁就接在虚拟头节点后面,然后移动当前指针到连接上来的节点上
            if list1.val < list2.val:   # 接上list1的值
                current.next = list1    # 刚开始时,current指向虚拟头节点,当list1与list2比较之后,current.next指向小的那个(即把虚拟头节点的next指向小的那个)
                list1 = list1.next  # 移动list1指针
                current = current.next # 移动当前指针
            else:   # 接上list2的值
                current.next = list2
                list2 = list2.next
                current = current.next
        if list1 is None:
            current.next = list2
        if list2 is None:
            current.next = list1
        return dummy.next
