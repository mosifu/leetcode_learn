package beginner_00.base_binary_tree_4.tree_code;

import java.util.Arrays;
import java.util.Objects;

/**98.验证二叉搜索树
 *给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 * 提示：
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class ValidateBinarySearchTree_98 {

    // 传入当前节点和对于左子节点的最大限制和对于右子节点的最小限制(使用long类型,防止int边界情况)
    private boolean isBST(TreeNode curNode, Long minLimit, Long maxLimit) {
        if (Objects.isNull(curNode)) {
            return true;
        }
        boolean leftIsBST = isBST(curNode.left, minLimit, (long) curNode.val); // 对于当前节点的左子节点,传入的是最大限制值
        boolean rightIsBST = isBST(curNode.right, (long) curNode.val, maxLimit);

        // 左子节点和右子节点为真,且当前节点的值大于最小限制值小于最大限制值返回真,否则返回假
        return leftIsBST && rightIsBST && minLimit < curNode.val && curNode.val < maxLimit;
    }

    private boolean isBST2(TreeNode curNode, Long minLimit, Long maxLimit) {
        if (Objects.isNull(curNode)) {
            return true;
        }
        if (curNode.val <= minLimit || curNode.val >= maxLimit) {
            return false;
        }
        if (!isBST2(curNode.left, minLimit, (long) curNode.val)) {
            return false;
        }
        if (!isBST2(curNode.right, (long)curNode.val, maxLimit)) {
            return false;
        }
        return true;
    }

    private Long pre = Long.MIN_VALUE;

    private boolean isBST3(TreeNode curNode, Long minLimit, Long maxLimit) {

        // 采用中序遍历与前一个节点进行比较
        if (Objects.isNull(curNode)) {
            return true;
        }

        if (!isBST3(curNode.left, minLimit, (long) curNode.val)) {
            return false;
        }

        if (curNode.val <= pre) {
            return false;
        }
        pre = (long) curNode.val;

        if (!isBST3(curNode.right, (long)curNode.val, maxLimit)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static void main(String[] args) {
        TreeNode tree = new BuildTree().buildTree(Arrays.asList(2,1,3));
        ValidateBinarySearchTree_98 obj = new ValidateBinarySearchTree_98();
        System.out.println(obj.isValidBST(tree));
    }
}

