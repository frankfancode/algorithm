package com.ff.offer;

import java.util.Stack;

class Offer09 {
    public static void main(String[] args) {

    }
}

class CQueue {
    Stack<Integer> mainStack;
    Stack<Integer> comStack;

    public CQueue() {
        mainStack = new Stack<>();
        comStack = new Stack<>();
    }

    public void appendTail(int value) {
        mainStack.push(value);
    }

    public int deleteHead() {
        int result = -1;
        while (!mainStack.isEmpty()) {
            comStack.push(mainStack.pop());
        }

        if (!comStack.isEmpty()){
            result = comStack.pop();
            while (!comStack.isEmpty()){
                mainStack.push(comStack.pop());
            }
        }

        return result;
    }
}
