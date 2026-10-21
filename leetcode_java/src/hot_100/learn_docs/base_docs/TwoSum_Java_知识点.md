# LeetCode Hot 100：两数之和（Two Sum）Java 知识点总结

## 一、题目回顾

### 1. 题目描述

给定一个整数数组 `nums` 和一个整数 `target`，找出数组中和为 `target` 的两个元素，并返回它们的下标。

示例：

```java
int[] nums = {2, 7, 11, 15};
int target = 9;
```

因为：

```text
nums[0] + nums[1] = 2 + 7 = 9
```

因此返回：

```java
new int[]{0, 1}
```

### 2. 题目约束与注意事项

- 数组中的同一个元素不能重复使用。
- 返回的是数组下标，而不是元素值。
- 两个下标可以按任意顺序返回，题目通常不要求固定顺序。
- 题目保证存在一组有效答案时，不需要考虑无解情况；为了让方法在所有执行路径上都有返回值，可以在循环结束后写一个兜底返回。
- 哈希表解法应当先查询补数，再存入当前元素，避免当前元素被自己匹配。

---

## 二、Java 基础语法知识

### 1. 方法定义

```java
public int[] twoSum(int[] nums, int target) {
    // 方法体
    return new int[]{0, 1};
}
```

各部分含义：

| 语法 | 含义 |
|---|---|
| `public` | 访问修饰符，表示方法可以被其他类访问 |
| `int[]` | 返回类型，表示返回一个整数数组 |
| `twoSum` | 方法名 |
| `int[] nums` | 整数数组参数 |
| `int target` | 整数参数 |
| `{}` | 方法体 |
| `return` | 返回结果并结束当前方法 |

LeetCode 通常要求提交指定的方法签名，不应随意修改方法名、参数或返回类型。

### 2. 数组定义与访问

定义数组：

```java
int[] nums = {2, 7, 11, 15};
```

访问数组：

```java
int first = nums[0];  // 2
int second = nums[1]; // 7
```

获取数组长度：

```java
int length = nums.length; // 4
```

注意：

- Java 数组下标从 `0` 开始。
- 最后一个合法下标是 `nums.length - 1`。
- `nums.length` 是属性，不是方法，因此没有括号。

### 3. 创建并返回数组

```java
return new int[]{i, j};
```

表示创建一个包含两个整数的数组，并立即返回。

例如：

```java
return new int[]{0, 1};
```

不能直接写成：

```java
return {0, 1}; // 错误
```

因为在 `return` 表达式中，需要使用 `new int[]{...}` 创建数组。

### 4. `for` 循环

暴力解法使用双重循环：

```java
for (int i = 0; i < nums.length; i++) {
    for (int j = i + 1; j < nums.length; j++) {
        // 处理 nums[i] 和 nums[j]
    }
}
```

外层循环：

```java
int i = 0;
i < nums.length;
i++;
```

含义：

- `int i = 0`：从下标 `0` 开始。
- `i < nums.length`：下标必须小于数组长度。
- `i++`：每轮结束后，`i` 加 `1`。

内层循环从 `i + 1` 开始，保证：

1. 不使用同一个元素两次。
2. 不重复检查同一对元素的反向组合。

例如，检查 `(0, 1)` 后，不需要再检查 `(1, 0)`。

### 5. `if` 条件判断

```java
if (nums[i] + nums[j] == target) {
    return new int[]{i, j};
}
```

相关运算符：

| 运算符 | 含义 |
|---|---|
| `+` | 加法 |
| `-` | 减法 |
| `==` | 判断两个值是否相等 |
| `=` | 赋值 |
| `<` | 小于 |
| `&&` | 逻辑与 |
| `!` | 逻辑非 |

注意区分：

```java
int target = 9;      // 赋值
target == 9          // 判断是否相等
```

### 6. `return` 与空数组

```java
return new int[]{};
```

表示返回一个长度为 `0` 的整数数组。

它与 `null` 不同：

```java
return new int[]{}; // 返回空数组
return null;        // 返回 null
```

空数组仍然是一个数组对象，可以访问 `.length`，结果为 `0`；而对 `null` 访问 `.length` 会引发 `NullPointerException`。

---

## 三、暴力解法

### 1. 代码

```java
public int[] twoSum1(int[] nums, int target) {
    // 循环遍历求解
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }

    return new int[]{};
}
```

### 2. 解题思路

枚举数组中的所有合法元素对：

1. 外层循环选择第一个元素 `nums[i]`。
2. 内层循环选择后面的元素 `nums[j]`。
3. 判断两个元素之和是否等于 `target`。
4. 如果满足条件，返回两个下标。
5. 如果遍历结束仍未找到，返回空数组。

### 3. 执行过程

输入：

```text
nums = [2, 7, 11, 15]
target = 9
```

| `i` | `j` | `nums[i]` | `nums[j]` | 两数之和 | 结果 |
|---:|---:|---:|---:|---:|---|
| 0 | 1 | 2 | 7 | 9 | 找到，返回 `[0, 1]` |

因为找到答案后立即执行 `return`，方法结束，不会继续检查其他元素对。

### 4. 时间复杂度

外层循环最多执行 \(n\) 次，内层循环会检查后续元素。

总比较次数最多为：

\[
\frac{n(n-1)}{2}
\]

因此：

\[
T(n)=O(n^2)
\]

时间复杂度为 **\(O(n^2)\)**。

### 5. 空间复杂度

除输入数组外，算法只使用了少量固定变量 `i` 和 `j`。

因此辅助空间复杂度为：

\[
S(n)=O(1)
\]

---

## 四、Java 哈希表知识

### 1. 什么是哈希表？

Java 中常用的哈希表实现是 `HashMap`。

哈希表通过键（Key）映射到值（Value），支持根据键快速查找对应的数据。

在两数之和中：

```java
Map<Integer, Integer> cache = new HashMap<>();
```

我们将：

- Key：数组中的元素值。
- Value：该元素对应的数组下标。

例如：

```java
cache.put(2, 0);
cache.put(7, 1);
```

逻辑结构如下：

| Key（元素值） | Value（下标） |
|---:|---:|
| 2 | 0 |
| 7 | 1 |

因此：

```java
cache.containsKey(2); // true
cache.get(2);         // 0
```

### 2. `Map` 与 `HashMap`

```java
Map<Integer, Integer> cache = new HashMap<>();
```

这里涉及 Java 接口与实现类的概念：

- `Map` 是接口，定义键值映射的常见操作。
- `HashMap` 是 `Map` 的一种实现，使用哈希表组织键值对。
- `new HashMap<>()` 创建实际对象。
- `Map<Integer, Integer>` 表示键和值都使用 `Integer` 类型。

这种写法体现了“面向接口编程”：变量使用接口类型声明，具体对象使用实现类创建。

通常需要导入：

```java
import java.util.HashMap;
import java.util.Map;
```

### 3. 泛型 `<Integer, Integer>`

```java
Map<Integer, Integer> cache = new HashMap<>();
```

`<Integer, Integer>` 是泛型参数：

- 第一个 `Integer`：Key 的类型。
- 第二个 `Integer`：Value 的类型。

这里使用 `Integer` 而不是 `int`，因为 Java 泛型类型参数必须是引用类型，不能直接写基本类型 `int`。

Java 支持基本类型与包装类型之间的自动装箱和拆箱：

```java
int number = 2;

Integer boxed = number; // 自动装箱
int value = boxed;      // 自动拆箱
```

### 4. `HashMap` 常用方法

| 方法 | 作用 | 示例 |
|---|---|---|
| `put(key, value)` | 添加或更新键值对 | `cache.put(2, 0)` |
| `get(key)` | 根据键获取值 | `cache.get(2)` |
| `containsKey(key)` | 判断键是否存在 | `cache.containsKey(2)` |
| `containsValue(value)` | 判断值是否存在 | `cache.containsValue(0)` |
| `remove(key)` | 删除指定键 | `cache.remove(2)` |
| `size()` | 获取键值对数量 | `cache.size()` |
| `isEmpty()` | 判断是否为空 | `cache.isEmpty()` |
| `clear()` | 清空集合 | `cache.clear()` |

重点区分：

```java
cache.containsKey(2);   // 判断 Key 是否存在
cache.containsValue(2); // 判断 Value 是否存在
cache.get(2);           // 获取 Key=2 对应的 Value
```

### 5. Key 的唯一性

在 `HashMap` 中，每个 Key 是唯一的。

例如：

```java
Map<Integer, Integer> cache = new HashMap<>();

cache.put(2, 0);
cache.put(2, 5);
```

第二次 `put` 会更新 Key 为 `2` 的映射，因此最终：

```java
cache.get(2); // 5
```

这意味着如果数组中存在重复数字，后一次存储可能覆盖前一次的下标。

对于本题的常见哈希表解法，由于每次先查询、后存储，因此在首次找到答案时，会使用此前保存的某个匹配下标。若要保留重复元素中最早的下标，可以按具体需求调整存储策略。

### 6. `HashMap` 如何判断 Key 相等？

对于普通对象，`HashMap` 的键匹配主要依赖：

- `hashCode()`：帮助定位可能存放键的桶。
- `equals()`：判断键是否相等。

自定义类如果要作为 Key，通常需要正确实现 `equals()` 和 `hashCode()`。

对于本题中的 `Integer`，Java 已经实现了这两个方法，因此直接使用：

```java
cache.containsKey(other)
```

即可，无需手动比较 `Integer` 对象。

### 7. 哈希表的时间复杂度

在哈希分布较均匀的通常情况下：

| 操作 | 平均时间复杂度 | 最坏情况说明 |
|---|---|---|
| `put()` | \(O(1)\) | 可能退化，复杂度受碰撞与扩容等因素影响 |
| `get()` | \(O(1)\) | 可能退化 |
| `containsKey()` | \(O(1)\) | 可能退化 |

刷题时通常把 `HashMap` 的查找和插入视为平均 \(O(1)\)，但这不是任何输入下都绝对保证的常数时间。

---

## 五、哈希表解法

### 1. 代码

```java
public int[] twoSum(int[] nums, int target) {
    // 使用哈希表求解
    Map<Integer, Integer> cache = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        // 当前元素对应的目标补数
        int other = target - nums[i];

        // 判断补数是否已经存在于 Map 中
        if (cache.containsKey(other)) {
            return new int[]{i, cache.get(other)};
        }

        // 保存当前元素及其下标
        cache.put(nums[i], i);
    }

    return new int[]{};
}
```

### 2. 解题思路

核心公式：

\[
other = target - nums[i]
\]

假设当前元素是 `nums[i]`，那么另一个元素必须是：

\[
other = target - nums[i]
\]

不再遍历所有后续元素，而是直接查询哈希表中是否存在这个补数。

如果存在，说明此前出现过符合要求的元素，可以直接返回两个下标。

### 3. 逐步模拟

输入：

```text
nums = [2, 7, 11, 15]
target = 9
```

初始状态：

```text
cache = {}
```

第一次循环：

```java
i = 0;
nums[i] = 2;
other = 9 - 2; // 7
```

查询：

```java
cache.containsKey(7); // false
```

因为 `7` 尚未出现，将当前元素存入：

```java
cache.put(2, 0);
```

此时：

```text
cache = {2=0}
```

第二次循环：

```java
i = 1;
nums[i] = 7;
other = 9 - 7; // 2
```

查询：

```java
cache.containsKey(2); // true
```

取得此前存储的下标：

```java
cache.get(2); // 0
```

返回：

```java
new int[]{1, 0}
```

结果是 `[1, 0]`。它与 `[0, 1]` 表示同一组下标，只是顺序不同。

### 4. 为什么先查找，再存储？

正确顺序：

```java
if (cache.containsKey(other)) {
    return new int[]{i, cache.get(other)};
}

cache.put(nums[i], i);
```

原因是当前元素不能被自己使用。

如果先存储当前元素，再查询补数，当 `target == 2 * nums[i]` 时，可能会让当前元素与自身匹配，从而错误地返回同一个下标两次。

先查找、后存储可以避免这个问题。

---

## 六、两种解法的复杂度对比

设数组长度为 \(n\)。

| 比较项 | 暴力解法 | 哈希表解法 |
|---|---|---|
| 核心思想 | 枚举所有元素对 | 查找当前元素的补数 |
| 时间复杂度 | \(O(n^2)\) | 平均 \(O(n)\) |
| 辅助空间复杂度 | \(O(1)\) | \(O(n)\) |
| 是否需要额外数据结构 | 不需要 | 需要 `HashMap` |
| 主要优点 | 思路简单，易于理解 | 平均查找效率更高 |
| 主要缺点 | 数组较大时效率低 | 需要额外内存 |

### 为什么哈希表解法是 \(O(n)\)？

循环最多遍历数组一次，即 \(n\) 次。

每次循环中，主要执行：

1. 一次减法运算，\(O(1)\)。
2. 一次 `containsKey()`，平均 \(O(1)\)。
3. 必要时一次 `get()`，平均 \(O(1)\)。
4. 没有找到时一次 `put()`，平均 \(O(1)\)。

因此平均总时间复杂度为：

\[
T(n)=O(n)
\]

哈希表最多存储与数组长度成正比数量的键值对，因此辅助空间复杂度为：

\[
S(n)=O(n)
\]

---

## 七、Java 中判断 Map 的 Key 是否存在

最常用的是：

```java
if (cache.containsKey(other)) {
    // Key 存在
}
```

不要将它与以下写法混淆：

```java
cache.get(other) != null
```

虽然在本题的 `Integer` 下标映射中，存入的 Value 不为 `null`，这种写法通常也能达到目的，但 `containsKey()` 更直接表达“键是否存在”的意图。

特别注意：`HashMap` 允许 `null` 值，因此 `get(key) == null` 并不能普遍证明这个 Key 不存在。

---

## 八、常见错误与注意事项

### 1. 数组下标越界

错误：

```java
for (int j = i + 1; j <= nums.length; j++)
```

正确：

```java
for (int j = i + 1; j < nums.length; j++)
```

最后一个合法下标是 `nums.length - 1`。

### 2. 将下标和元素值混淆

```java
return new int[]{i, j};
```

返回的是下标。

而：

```java
return new int[]{nums[i], nums[j]};
```

返回的是元素值，两者含义不同。

### 3. 哈希表 Key 和 Value 放反

本题建议使用：

```java
cache.put(nums[i], i);
```

即：

```text
Key   = 元素值
Value = 数组下标
```

如果存成 `cache.put(i, nums[i])`，就需要重新设计查找逻辑。

### 4. 忘记导入集合类型

本地 Java 文件通常需要：

```java
import java.util.HashMap;
import java.util.Map;
```

如果没有导入，编译器可能提示无法识别 `Map` 或 `HashMap`。

### 5. 方法名重复但参数列表相同

在同一个类中，不能定义两个方法，它们的方法名和参数类型列表完全相同，即使返回类型不同也不行。

因此可以将两个解法分别命名为：

```java
twoSum1(...)
twoSum(...)
```

也可以分别放在不同的类中。

---

## 九、本次学习知识清单

### Java 语法

- [ ] 理解 `public int[] methodName(...)` 的结构。
- [ ] 理解 `int`、`int[]` 和数组下标。
- [ ] 掌握 `nums.length`。
- [ ] 掌握 `for` 双重循环。
- [ ] 理解 `if`、`==` 和 `return`。
- [ ] 理解 `new int[]{i, j}`。
- [ ] 理解 `Map<Integer, Integer>` 的泛型声明。
- [ ] 掌握 `put()`、`get()`、`containsKey()`。

### 算法与复杂度

- [ ] 理解暴力解法为什么是 \(O(n^2)\)。
- [ ] 理解哈希表解法平均为什么是 \(O(n)\)。
- [ ] 能区分时间复杂度与空间复杂度。
- [ ] 理解哈希表的 Key 是元素值、Value 是下标。
- [ ] 理解为什么需要先查找补数，再存储当前元素。

---

## 十、最终记忆

两数之和的核心不是记住某段代码，而是理解这个转变：

**暴力解法：** 对每个元素，遍历后面的所有元素寻找答案。

**哈希表解法：** 对每个元素，计算补数，然后直接查找补数是否已经出现。

```java
int other = target - nums[i];

if (cache.containsKey(other)) {
    return new int[]{i, cache.get(other)};
}

cache.put(nums[i], i);
```

这一模式是很多哈希表算法的基础：把已经处理过的数据存起来，让后续查找更高效。
