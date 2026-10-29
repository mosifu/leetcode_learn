package beginner_00.base_linked_list_2.linked_code;

/**21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class MergeTwoSortedLists_21 {
     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode();
        // 定义当前指针指向虚拟节点的引用
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // 说明list1小,那么虚拟头节点连接到list1
                current.next = list1;
                // 移动list1头节点
                list1 = list1.next;
                // 移动当前节点到list1

            } else {
                // 连接到list2
                current.next = list2;
                list2 = list2.next;

            }
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return dummy.next;
    }

    // 使用int数组构建链表
    public static ListNode buildListNodeList(int[] list) {
         ListNode dummy = new ListNode();
         ListNode current = dummy;
         for (int n : list) {
             current.next = new ListNode(n);
             current = current.next;
         }
         return dummy.next;
    }

    // 格式输出链表链->
    public static void printListNode(ListNode head) {
         ListNode current = head;
         while (current != null) {
             System.out.print(current.val);
             if (current.next != null) {
                 System.out.print("->");
             }
             current = current.next;
         }
        System.out.println();

    }

    public static void main(String[] args) {
        ListNode list1 = buildListNodeList(new int[] {1,2,4});
        ListNode list2 = buildListNodeList(new int[] {1,3,4});
        MergeTwoSortedLists_21 obj = new MergeTwoSortedLists_21();
        ListNode listNode = obj.mergeTwoLists(list1, list2);
        printListNode(listNode);
    }
}
