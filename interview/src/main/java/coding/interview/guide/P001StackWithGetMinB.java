package coding.interview.guide;

import java.util.Stack;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/11 21:48
 */
public class P001StackWithGetMinB {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public P001StackWithGetMinB() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }

        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        return this.stackMin.peek();
    }
}
