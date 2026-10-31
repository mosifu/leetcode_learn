package beginner_00.base_stack_3.stack_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**155.最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int value) 将元素 value 推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 *
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 */
public class MinStack_155 {
    static class MinStack {

        private final Deque<Integer> stack;
        private final Deque<Integer> min_stack;
        public MinStack() {
            // 设置两个栈,一个来存放全部元素,一个用来比较当前入栈中的最小元素,每次比较到最小时存入
            this.stack = new ArrayDeque<>();
            this.min_stack = new ArrayDeque<>();
        }

        public void push(int value) {
            // 存入操作,最小栈需要比较,只有发现最小时,才存入
            this.stack.push(value);
            if (min_stack.isEmpty() || value <= min_stack.peek()) {
                // || 是断路操作,前一部分成立时不会执行后面的部分
                min_stack.push(value);
            }
        }

        public void pop() {
            // 移除栈顶元素
            int value = this.stack.pop();
            if (!this.min_stack.isEmpty() && value == this.min_stack.peek()) {
                // 入股移除的栈顶元素与最小栈的栈顶元素一样,则同步移除
                this.min_stack.pop();
            }
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin() {
            return this.min_stack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(-2);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
