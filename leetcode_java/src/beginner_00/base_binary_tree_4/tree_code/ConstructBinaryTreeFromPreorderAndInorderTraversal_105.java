package beginner_00.base_binary_tree_4.tree_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**105.从前序与中序遍历序列构造二叉树
 *给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 *       3
 *     /   \
 *    9     20
 *         /  \
 *       15    7
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序遍历第一个元素为根节点，然后在中序遍历中找到根节点元素所在位置，则前半部分为左子树，后半部分为右字数
        if (Objects.isNull(preorder) || preorder.length ==0) {
            return null;
        }

        int root_val = preorder[0]; // 根节点的值
        TreeNode root = new TreeNode(root_val); // 初始化根节点

        // 在中序遍历数组中找到根节点的下标索引
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root_val) {
                break;
            }
        }
        // 构建左子树
        root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1), Arrays.copyOfRange(inorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length), Arrays.copyOfRange(inorder,i+1,preorder.length));
        return root;
    }

    // 递归,传入中序遍历后的键值对(键是树的值,值是索引下标),先序,中序遍历列表,先序遍历左右指针,中序遍历左右指针
    private TreeNode solver(Map<Integer, Integer> inorderMap, int[] preorder, Integer pre_left, Integer pre_right, Integer in_left, Integer in_right) {
        if (pre_left > pre_right) {
            return null;
        }

        int root_val = preorder[pre_left];
        TreeNode root = new TreeNode(root_val);
        int idx = inorderMap.get(root_val); // 节点对应的索引下标
        int left_size = idx - in_left;

        root.left = solver(inorderMap, preorder, pre_left+1, pre_left+left_size, in_left, idx-1);
        root.right = solver(inorderMap, preorder, pre_left+left_size+1, pre_right, idx+1, in_right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return solver(inorderMap,preorder,0,preorder.length-1,0,inorder.length-1);
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
