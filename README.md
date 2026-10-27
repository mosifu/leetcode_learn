# LeetCode 刷题学习仓库

按 **Hot 100 高频题** 系统练习算法，每道题用 **Python** 与 **Java** 双语言实现，并附学习笔记。解题代码与笔记分离，按「难度层级 → 题型套路」分级归档，便于回看与横向对比。

## 目录结构

```
leetcode_learn/
├── leetcode_python/                  # Python 解题
│   └── 00.beginner/                  # 入门级
│       ├── 1.常见和入门套路/          # 解题代码（.py）
│       └── 0.learn_docs/
│           └── 1.常见和入门套路/      # 学习笔记（.md）
├── leetcode_java/                    # Java 解题
│   └── src/beginner_00/              # 入门级
│       ├── base/                     # 解题代码（.java）
│       └── base_docs/                # 学习笔记（.md）
├── .gitignore
└── README.md
```

- **代码** 与 **笔记** 分目录存放：代码目录放可运行的解法，笔记目录放思路拆解、复杂度分析与易错点。
- `leetcode_java/out/` 为 IDE 编译产物，已在 `.gitignore` 中排除，不入库。

## 题目进度

| 题号 | 题目 | 主要考点 | Python | Java |
|------|------|----------|:------:|:----:|
| 1    | [两数之和](leetcode_python/00.beginner/1.常见和入门套路/1.两数之和.py) | 哈希表 | ✅ | ✅ |
| 3    | [无重复字符的最长子串](leetcode_python/00.beginner/1.常见和入门套路/3.无重复字符串的最长子串.py) | 滑动窗口 | ✅ | ✅ |
| 26   | [删除有序数组中的重复项](leetcode_python/00.beginner/1.常见和入门套路/26.删除有序数组中的重复项.py) | 双指针 | ✅ | ✅ |
| 59   | [螺旋矩阵 II](leetcode_python/00.beginner/1.常见和入门套路/59.螺旋矩阵II.py) | 模拟 / 边界收缩 | ✅ | ✅ |
| 167  | [两数之和 II - 输入有序数组](leetcode_python/00.beginner/1.常见和入门套路/167.两数之和II-输入有序数组.py) | 双指针 / 哈希 | ✅ | ✅ |
| 209  | [长度最小的子数组](leetcode_python/00.beginner/1.常见和入门套路/209.长度最小的子数组.py) | 滑动窗口 | ✅ | ✅ |
| 303  | [区域和检索 - 数组不可变](leetcode_python/00.beginner/1.常见和入门套路/303.区域和检索-数组不可变.py) | 前缀和 | ✅ | ✅ |
| 560  | [和为 K 的子数组](leetcode_python/00.beginner/1.常见和入门套路/560.和为K的子数组.py) | 前缀和 / 哈希 | ✅ | ✅ |
| 704  | [二分查找](leetcode_python/00.beginner/1.常见和入门套路/704.二分查找.py) | 二分查找 | ✅ | ✅ |

> 每题的笔记与对应代码放在同题型目录下，文件名以「题号.题名」统一命名，方便对照。

## 本地运行

### Python

每个 `.py` 文件末尾都带有 `if __name__ == '__main__':` 自测样例，可直接运行：

```bash
python leetcode_python/00.beginner/1.常见和入门套路/1.两数之和.py
```

### Java

用 IntelliJ IDEA 打开 `leetcode_java/` 目录即可（已含 `.idea` 配置）。含 `public static void main` 的类可直接运行；其余为可被调用的解法类。编译产物输出到 `out/`（已忽略，不入库）。

命令行方式（以第 1 题为例）：

```bash
cd leetcode_java
javac -encoding UTF-8 -d out src/beginner_00/base/TwoSum.java
java -cp out beginner_00.base.TwoSum
```

## 提交约定

- 代码（`.py` / `.java`）与学习笔记（`.md`）成对提交，单题独立成 commit。
- 需要仅推送某一语言时，按目录或显式文件路径暂存，避免误带未完成的另一语言文件。
- 远端主分支为 `main`，仓库公开可见。

---

仓库地址：https://github.com/mosifu/leetcode_learn
