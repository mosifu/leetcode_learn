"""
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
实现 MyQueue 类：
void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false

说明：
你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。

示例 1：
输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]
解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

提示：
1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
"""

class MyQueue:
    # 队列是先进先出的，可以使用两个栈来实现，一个栈装先进后出，然后在装进另一个栈里，就是先进先出了
    def __init__(self):
        # 定义两个栈
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        # 入栈操作
        self.in_stack.append(x)

    def pop(self) -> int:
        # 获取并移除队列第一个入队的元素
        if self.out_stack:  # 出栈不为空
            return self.out_stack.pop()
        else:
            # 把入栈的元素倒着存入出栈
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
            return self.out_stack.pop()

    def peek(self) -> int:
        # 查看队列第一个元素
        if self.out_stack:
            return self.out_stack[-1]
        else:   # 先把入栈元素倒序移到出栈
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
            return self.out_stack[-1]

    def empty(self) -> bool:
        if self.out_stack or self.in_stack:
            return False
        else:
            return True