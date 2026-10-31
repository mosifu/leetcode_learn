package beginner_00.base_stack_3.stack_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**227.基本计算器II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 *
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 *
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据 保证 答案是一个 32-bit 整数
 */
public class BasicCalculatorII_227 {
    public static int calculate(String s) {
        // 先去除字符串的空格
        char[] chars = s.replace(" ", "").toCharArray();
        int chars_len = chars.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;    // 当前数
        char pre_sign = '+';    //上一步运算符,如果是加减号则需要先存储起来,看看后面有没有乘除,乘除符号先运算
        for (int i = 0; i < chars_len; i++) {
            char current = chars[i];
            if (Character.isDigit(current)) {
                // 当前字符是数字
                num = num*10 + (current-'0'); // 连续字符是数字,说明不是个位数,则需要乘10相加
            }
            if (!Character.isDigit(current) || i == chars_len-1) {
                // 当前字符不是数字或者已经到了最后一个字符(最后一个字符需要进行计算)
                if (pre_sign == '+') {
                    stack.push(num);
                } else if (pre_sign == '-') {
                    stack.push(-num);
                } else if (pre_sign == '*') {
                    stack.push(stack.pop()*num);
                } else if (pre_sign == '/') {
                    stack.push(stack.pop() / num);
                }
                pre_sign = current;
                num = 0;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
