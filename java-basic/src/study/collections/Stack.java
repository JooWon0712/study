package study.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JooWon0712.
 * User: joowon
 * Date: 2019-03-03
 * Time: 21:52
 */
public class Stack {

    private int top;
    private List<Object> stack;
    private int size;

    private Stack(int size) {
       this.top = -1;
       this.stack = new ArrayList<>(size);
       this.size = size;
    }

    private void pop() {
        if (this.top == -1) {
            System.out.println("Exception : stack no elements");
            return;
        }

        Object object = this.stack.get(this.top);
        System.out.println("== POP ("+object.toString()+") ==");
        this.stack.remove(object);
        this.top = this.stack.size() - 1;
    }

    private void push(Object object) {
        if (this.size == this.stack.size()) {
            System.out.println("Exception : Stack full");
            return;
        }

        System.out.println("== PUSH ("+object.toString()+") ==");
        this.top = stack.size();
        this.stack.add(object);
    }

    private void peek() {
        System.out.println("== PEEK ("+this.stack.get(this.top)+") ==");
    }

    private void print() {
        System.out.println("## Stack print start");
        for (int i = this.stack.size()-1; i >= 0; i--) {
            System.out.println(this.stack.get(i));
        }
        System.out.println("## Stack print end");
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push("String");
        stack.push(1);
        stack.push(3.14);
        stack.pop();
        stack.peek(); // 1
        stack.pop();
        stack.pop();
        stack.pop(); // stack no elements
        stack.push(3.14);
        stack.push(14);
        stack.push("Str");
        stack.push("Str1234"); // stack full
        stack.print();
    }
}