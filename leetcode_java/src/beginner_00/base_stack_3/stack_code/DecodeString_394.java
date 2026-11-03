package beginner_00.base_stack_3.stack_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**394.字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 测试用例保证输出的长度不会超过 105。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 提示：
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class DecodeString_394 {
    public static String decodeString(String s) {
        // Java是强类型语言,需要使用两个栈来装
        Deque<StringBuilder> str_deq = new ArrayDeque<>(); // 用来存[前的字母
        Deque<Integer> int_deq = new ArrayDeque<>();    // 存数字
        StringBuilder cur_str = new StringBuilder();  // 当前正在构建的字符串
        int num = 0;    // 当前数字倍数
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                // 是字母
                cur_str.append(c);
            } else if (Character.isDigit(c)) {
                // 是数字
                num = num*10 + (c-'0');
            } else if (c == '[') {
                // 左方括号
                int_deq.push(num);
                str_deq.push(cur_str);
                num = 0;
                // 重新构建字符串
                cur_str = new StringBuilder();
            } else {
                // 右方括号,此时cur_str构建的字符串就是[]区间内的字符串,而此时数字栈顶的数字就是倍数
                int count = int_deq.pop();
                StringBuilder newStr = str_deq.pop(); // 把字符串栈的顶端拿出来拼接,应对嵌套的情况
                newStr.append(cur_str.toString().repeat(count));
                cur_str = newStr;   // 把嵌套好的字符串赋值给构建字符串,重新进入循环
            }
        }
        return cur_str.toString();
    }

    public static void main(String[] args) {
        System.out.printf(decodeString("3[a2[c]]"));
    }
}
