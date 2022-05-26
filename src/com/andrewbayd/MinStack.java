package com.andrewbayd;

import java.util.ArrayDeque;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

https://leetcode.com/problems/min-stack/
 */
class MinStack {
    private final ArrayDeque<Integer> elements;
    private final ArrayDeque<Integer> mins;

    public MinStack() {
        elements = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }

    public void push(int val) {
        elements.add(val);
        if (mins.isEmpty() || val <= mins.peekLast()) {
            mins.add(val);
        }
    }

    public void pop() {
        int popped = elements.pollLast();
        if (popped == mins.peekLast()) {
            mins.pollLast();
        }
    }

    public int top() {
        return elements.peekLast();
    }

    public int getMin() {
        return mins.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

