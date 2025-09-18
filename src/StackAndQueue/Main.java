package StackAndQueue;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        StackArray<Integer> stack = new StackArray<>(5);
//        Deque<Integer> stack = new ArrayDeque<>(2);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//
//        System.out.println(stack);
//
//        System.out.println(stack.pop());
//
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack);

//        StackLinkedList<Integer> stack = new StackLinkedList<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);

//        QueueArray<Integer> queue = new QueueArray<>(6);
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//        queue.enqueue(6);
//
//        System.out.println(queue);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.peek());
//        System.out.println(queue);

        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println(queue);
        System.out.println("Deque " + queue.dequeue());
        System.out.println("Deque " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Peek " + queue.peek());
        System.out.println(queue);
//

    }
}
