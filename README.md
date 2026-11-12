# LeetCode 刷题学习仓库

按 **Hot 100 高频题** 系统练习算法，每道题用 **Python** 与 **Java** 双语言实现，并附学习笔记。解题代码与笔记分离存放，按「难度层级 → 题型套路」分级归档，便于回看与横向对比。

当前进度：**30 题**（数组 12 + 链表 4 + 栈 6 + 二叉树 8），Python 与 Java 双语言均已实现，每题配套学习笔记（代码与笔记分目录存放）。二叉树专题已收尾，正在开始**回溯算法**专题。

## 目录结构

```
leetcode_learn/
├── leetcode_python/
│   └── 00.beginner/                        # 入门级
│       ├── 1.入门数组常见套路/              # 数组题解题代码（.py）
│       ├── 2.入门链表常见套路/              # 链表题解题代码（.py）
│       ├── 3.入门栈常见套路/                # 栈题解题代码（.py）
│       ├── 4.入门二叉树常见套路/            # 二叉树题解题代码（.py）
│       ├── 5.回溯算法常见套路/              # 回溯题解题代码（.py）
│       └── 0.learn_docs/                   # 学习笔记（.md）
│           ├── 1.入门数组常见套路/
│           ├── 2.入门链表常见套路/
│           ├── 3.入门栈常见套路/
│           ├── 4.入门二叉树常见套路/
│           └── 5.回溯算法常见套路/
├── leetcode_java/
│   └── src/beginner_00/                    # 入门级
│       ├── base_array_1/
│       │   ├── array_code/                 # 数组题解题代码（.java）
│       │   └── array_docs/                 # 数组题学习笔记（.md）
│       ├── base_linked_list_2/
│       │   ├── linked_code/                # 链表题解题代码（.java）
│       │   └── linked_docs/                # 链表题学习笔记（.md）
│       ├── base_stack_3/
│       │   ├── stack_code/                 # 栈题解题代码（.java）
│       │   └── stack_docs/                 # 栈题学习笔记（.md）
│       ├── base_binary_tree_4/
│       │   ├── tree_code/                  # 二叉树题解题代码（.java）
│       │   └── tree_docs/                  # 二叉树题学习笔记（.md）
│       └── base_backtracking_5/
│           ├── backtracking_code/          # 回溯题解题代码（.java）
│           └── backtracking_docs/          # 回溯题学习笔记（.md）
├── .gitignore
└── README.md
```

目录约定：

- **代码与笔记分目录**：代码目录放可运行的解法，笔记目录放思路拆解、复杂度分析与易错点。
- **Java 包名与目录严格对应**：`array_code/` → `beginner_00.base_array_1.array_code`，`linked_code/` → `beginner_00.base_linked_list_2.linked_code`，`stack_code/` → `beginner_00.base_stack_3.stack_code`，`tree_code/` → `beginner_00.base_binary_tree_4.tree_code`，`backtracking_code/` → `beginner_00.base_backtracking_5.backtracking_code`。
- **公共辅助类型**：二叉树分类下 `TreeNode.java`（顶层公共节点类型）、`BuildTree.java`（由层序列表构建树）与 Python 侧 `buildTree.py` 供同分类各题共用，不计入题目数。
- **文件命名**：Python 以「题号.题名」命名；Java 类名采用英文驼峰 + 题号后缀（如 `BinarySearch_704`、`BinaryTreeTraversal_144_94_145`），与笔记题号一一对应。
- **不入库内容**：`leetcode_java/out/`（编译产物）、`leetcode_python/.venv/`、`__pycache__/`、`*.pyc`、`.idea/` 均已在 `.gitignore` 中排除。

## 题目进度

### 数组

| 题号 | 题目 | 主要考点 | Python | Java |
|:----:|------|----------|:------:|:----:|
| 1 | 两数之和 | 哈希表 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/1.两数之和.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/TwoSum.java) |
| 3 | 无重复字符的最长子串 | 滑动窗口 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/3.无重复字符串的最长子串.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/LongestSubstringWithoutRepeatingCharacters_3.java) |
| 26 | 删除有序数组中的重复项 | 双指针 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/26.删除有序数组中的重复项.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/RemoveDuplicatesFromSortedArray_26.java) |
| 41 | 缺失的第一个正数 | 原地哈希 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/41.缺失的第一个正数.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/FirstMissingPositive_41.java) |
| 56 | 合并区间 | 排序 + 贪心 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/56.合并区间.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/MergeIntervals_56.java) |
| 59 | 螺旋矩阵 II | 模拟 / 边界收缩 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/59.螺旋矩阵II.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/SpiralMatrixII_59.java) |
| 167 | 两数之和 II - 输入有序数组 | 双指针 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/167.两数之和II-输入有序数组.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/TwoSum_167.java) |
| 209 | 长度最小的子数组 | 滑动窗口 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/209.长度最小的子数组.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/MinimumSizeSubarraySum_209.java) |
| 303 | 区域和检索 - 数组不可变 | 前缀和 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/303.区域和检索-数组不可变.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/RangeSumQueryImmutable_303.java) |
| 560 | 和为 K 的子数组 | 前缀和 + 哈希 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/560.和为K的子数组.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/SubarraySumEqualsK_560.java) |
| 704 | 二分查找 | 二分查找 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/704.二分查找.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/BinarySearch_704.java) |
| 1109 | 航班预订统计 | 差分数组 | [✅](leetcode_python/00.beginner/1.入门数组常见套路/1109.航班预订统计.py) | [✅](leetcode_java/src/beginner_00/base_array_1/array_code/CorporateFlightBookings_1109.java) |

### 链表

| 题号 | 题目 | 主要考点 | Python | Java |
|:----:|------|----------|:------:|:----:|
| 21 | 合并两个有序链表 | 双指针 / 递归 | [✅](leetcode_python/00.beginner/2.入门链表常见套路/21.合并两个有序链表.py) | [✅](leetcode_java/src/beginner_00/base_linked_list_2/linked_code/MergeTwoSortedLists_21.java) |
| 141 | 环形链表 | 快慢指针 | [✅](leetcode_python/00.beginner/2.入门链表常见套路/141.环形链表.py) | [✅](leetcode_java/src/beginner_00/base_linked_list_2/linked_code/LinkedListCycle_141.java) |
| 142 | 环形链表 II | 快慢指针 / 环入口 | [✅](leetcode_python/00.beginner/2.入门链表常见套路/142.环形链表II.py) | [✅](leetcode_java/src/beginner_00/base_linked_list_2/linked_code/LinkedListCycleII_142.java) |
| 206 | 反转链表 | 双指针 / 递归 | [✅](leetcode_python/00.beginner/2.入门链表常见套路/206.反转链表.py) | [✅](leetcode_java/src/beginner_00/base_linked_list_2/linked_code/ReverseLinkedList_206.java) |

### 栈

| 题号 | 题目 | 主要考点 | Python | Java |
|:----:|------|----------|:------:|:----:|
| 20 | 有效的括号 | 栈 | [✅](leetcode_python/00.beginner/3.入门栈常见套路/20.有效的括号.py) | [✅](leetcode_java/src/beginner_00/base_stack_3/stack_code/ValidParentheses_20.java) |
| 155 | 最小栈 | 辅助栈 | [✅](leetcode_python/00.beginner/3.入门栈常见套路/155.最小栈.py) | [✅](leetcode_java/src/beginner_00/base_stack_3/stack_code/MinStack_155.java) |
| 227 | 基本计算器 II | 表达式求值 / 栈 | [✅](leetcode_python/00.beginner/3.入门栈常见套路/227.基本计算器II.py) | [✅](leetcode_java/src/beginner_00/base_stack_3/stack_code/BasicCalculatorII_227.java) |
| 232 | 用栈实现队列 | 双栈 | [✅](leetcode_python/00.beginner/3.入门栈常见套路/232.用栈实现队列.py) | [✅](leetcode_java/src/beginner_00/base_stack_3/stack_code/ImplementQueueUsingStacks_232.java) |
| 394 | 字符串解码 | 辅助栈 | [✅](leetcode_python/00.beginner/3.入门栈常见套路/394.字符串解码.py) | [✅](leetcode_java/src/beginner_00/base_stack_3/stack_code/DecodeString_394.java) |
| 739 | 每日温度 | 单调栈 | [✅](leetcode_python/00.beginner/3.入门栈常见套路/739.每日温度.py) | [✅](leetcode_java/src/beginner_00/base_stack_3/stack_code/DailyTemperatures_739.java) |

### 二叉树

> 第 144/94/145 题（前 / 中 / 后序遍历）合并存放于同一份代码与笔记文件中；`TreeNode` 为分类内公共类型。

| 题号 | 题目 | 主要考点 | Python | Java |
|:----:|------|----------|:------:|:----:|
| 94 | 二叉树的中序遍历 | 递归 / 迭代（左根右） | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/144_94_145.二叉树的前_中_后序遍历.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/BinaryTreeTraversal_144_94_145.java) |
| 98 | 验证二叉搜索树 | 上下界递归 / 中序 | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/98.验证二叉搜索树.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/ValidateBinarySearchTree_98.java) |
| 102 | 二叉树的层序遍历 | BFS / 队列 | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/102.二叉树的层序遍历.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/BinaryTreeLevelOrderTraversal_102.java) |
| 104 | 二叉树的最大深度 | 递归 / 后序 | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/104.二叉树的最大深度.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/MaximumDepthOfBinaryTree_104.java) |
| 105 | 从前序与中序遍历序列构造二叉树 | 递归分治 / 哈希索引 | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/105.从前序与中序遍历序列构造二叉树.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/ConstructBinaryTreeFromPreorderAndInorderTraversal_105.java) |
| 144 | 二叉树的前序遍历 | 递归 / 迭代（根左右） | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/144_94_145.二叉树的前_中_后序遍历.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/BinaryTreeTraversal_144_94_145.java) |
| 145 | 二叉树的后序遍历 | 递归 / 迭代（左右根） | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/144_94_145.二叉树的前_中_后序遍历.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/BinaryTreeTraversal_144_94_145.java) |
| 236 | 二叉树的最近公共祖先 | 递归 / 后序回溯 | [✅](leetcode_python/00.beginner/4.入门二叉树常见套路/236.二叉树的最近公共祖先.py) | [✅](leetcode_java/src/beginner_00/base_binary_tree_4/tree_code/LowestCommonAncestorOfABinaryTree_236.java) |

### 回溯

> 专题起步中：第 77 题目前为骨架（Python 方法体 `pass`、Java `return null`，两份笔记待补），**不计入已完成 30 题**，待实现后转为 ✅。

| 题号 | 题目 | 主要考点 | Python | Java |
|:----:|------|----------|:------:|:----:|
| 77 | 组合 | 回溯 / 剪枝 | [🚧 骨架](leetcode_python/00.beginner/5.回溯算法常见套路/77.组合.py) | [🚧 骨架](leetcode_java/src/beginner_00/base_backtracking_5/backtracking_code/Combinations_77.java) |

> 每题的笔记与对应代码按同题型归类存放，表内 ✅ 可直接跳转到对应语言的解题文件。

## 本地运行

### Python

部分题目自带自测入口（`if __name__ == '__main__':` 块），当前为 20、56、59、98、102、104、144/94/145、155、227、236、303、394、560、739，可直接运行：

```bash
python "leetcode_python/00.beginner/3.入门栈常见套路/227.基本计算器II.py"
```

其余文件为纯解法（函数或类），可按模块方式导入调用，或自行补充测试用例。二叉树分类下的 `buildTree.py` 是构建测试树的辅助模块，需与各题文件置于同一目录。

### Java

用 IntelliJ IDEA 打开 `leetcode_java/` 目录，将 `src` 标记为 **Sources Root** 即可（IDE 配置按约定不入库，需本地生成）。

部分类含 `public static void main`，当前为 3、20、21、59、98、102、104、105、1109、144/94/145、155、227、303、394、560、739，可直接运行；其余为解法类（如 232、236 仅含解法、无 `main`），供调用或自行编写测试。

命令行方式（以第 59 题为例，无外部依赖，可单文件编译）：

```bash
cd leetcode_java
javac -encoding UTF-8 -d out src/beginner_00/base_array_1/array_code/SpiralMatrixII_59.java
java -cp out beginner_00.base_array_1.array_code.SpiralMatrixII_59
```

二叉树分类下各题共用 `TreeNode.java` 与 `BuildTree.java`，**需整体编译**（单文件编译会因缺少依赖而失败）：

```bash
cd leetcode_java
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out beginner_00.base_binary_tree_4.tree_code.BinaryTreeTraversal_144_94_145
```

该命令输出示例树的前序遍历 `[1, 2, 4, 5, 6, 7, 3, 8, 9]`。编译产物输出到 `out/`（已忽略，不入库）。

## 提交约定

- 代码（`.py` / `.java`）与学习笔记（`.md`）成对提交，单题独立成 commit。
- 仅推送某一种语言时，按目录或显式文件路径暂存，避免误带未完成的另一语言文件。
- 远端主分支为 `main`，仓库公开可见。

---

仓库地址：https://github.com/mosifu/leetcode_learn
