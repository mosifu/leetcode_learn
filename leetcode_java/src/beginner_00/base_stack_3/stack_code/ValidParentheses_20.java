package beginner_00.base_stack_3.stack_code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**20.有效的括号
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([])"
 * 输出：true
 *
 * 示例 5：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class ValidParentheses_20 {
    public static boolean isValid(String s) {
        // 使用栈的思想,用一个列表来存出现的左括号,遇到右括号时,从列表取出最近存进去的符号(后进先出)
        // 先做左右括号配对,使用map集合(Java中遍历字符串得到得是字节)
        HashMap<Character,Character> map_str = new HashMap<>();
        map_str.put('(',')');
        map_str.put('[',']');
        map_str.put('{','}');
        // 创建stack栈,用来存左括号
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map_str.containsKey(c)) {
                // 存到栈顶
                stack.push(c);
            } else {
                if (stack.isEmpty() || !map_str.get(stack.pop()).equals(c)) {
                    // 如果栈为空或者当前栈顶对应的右括号不等于现在遍历的右括号
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.printf(isValid("()[]{}")? "True":"False");
    }
}
