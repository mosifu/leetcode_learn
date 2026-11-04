package beginner_00.base_binary_tree_4.tree_code;

import java.util.*;

/**144_94_145.二叉树前_中_后序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 解释：
 *   1
 *    \
 *     2
 *    /
 *   3
 *
 * 示例 2：
 * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * 输出：[1,2,4,5,6,7,3,8,9]
 * 解释：
 *         1
 *       /   \
 *     2       3
 *   /   \      \
 *  4     5      8
 *       / \    /
 *      6   7  9
 *
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 4：
 * 输入：root = [1]
 * 输出：[1]
 *
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class BinaryTreeTraversal_144_94_145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return new ArrayList<>(){};
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }


    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return new ArrayList<>(){};
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return new ArrayList<>(){};
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    // 由整形列表创建二叉树
    public TreeNode buildTree(List<Integer> list) {
        // 先判断是否为空(判断列表是否存在(null)，存在是否为空列表([]),以及存在列表但第一个元素是否为null([null,1,2]))
        if (list == null || list.isEmpty() || list.get(0) == null) {
            return null;
        }
        TreeNode treeRoot = new TreeNode(list.get(0));  // 创建根节点
        Queue<TreeNode> queue = new ArrayDeque<>();  // 定义变量队列类型,实现数组双端队列类
        queue.offer(treeRoot);  // 把当前根节点的信息添加到队列
        int i = 1;  // 下一步要遍历的数组下标
        while (!queue.isEmpty() && i < list.size()) {
            TreeNode node = queue.poll();   // 第一次循环时,node就已经指向的引用就是根节点指向的引用
            Integer leftVal = list.get(i++);
            if (leftVal!=null) {
                node.left = new TreeNode(leftVal);
                queue.offer(node.left);
            }
            if (i < list.size()) {
                Integer rightVal = list.get(i++);
                if (rightVal != null) {
                    node.right = new TreeNode(rightVal);
                    queue.offer(node.right);
                }
            }
        }
        return treeRoot;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal_144_94_145 obj = new BinaryTreeTraversal_144_94_145();
        TreeNode treeNode = obj.buildTree(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,9));
        System.out.printf(obj.preorderTraversal(treeNode).toString());  //前序
    }
}
