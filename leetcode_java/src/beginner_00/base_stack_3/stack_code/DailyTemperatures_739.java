package beginner_00.base_stack_3.stack_code;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


/**739.每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class DailyTemperatures_739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        // 使用单调栈,先存入第一天的温度索引,然后比较比较后一天的温度,如果后一天的大于,则销毁前一天的,然后计算间隔天(索引相减),,直到没有大于的,把当前天索引入栈
        Deque<Integer> stack = new ArrayDeque<>(List.of(0));
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 当前的温度大于栈顶的温度
                int stack_top = stack.pop();   // 取出
                answer[stack_top] = i - stack_top;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
