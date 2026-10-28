package beginner_00.base_linked_list_2.linked_code;

/**206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class ReverseLinkedList_206 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        // 设置上一步指针
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;  // 定义下一步指针
            head.next = pre;            // 当前指针引用进行翻转
            pre = head;                 // 上一步指针往前移动
            head = next;                // 当前指针也往前移动
        }
        return pre;
    }
}
