package heap;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        MaxHeap myHeap = new MaxHeap(10);
        myHeap.insert(5);
        myHeap.insert(1);
        myHeap.insert(6);
        myHeap.insert(2);
        myHeap.insert(3);
        myHeap.insert(10);

        System.out.println("max: " + myHeap.extractMax());

        int[] arr = new int[]{6, 8, 1, 0, 2, 10, 19, 88};
        myHeap.buildHeap(arr);
        System.out.println("max - build: " + myHeap.extractMax());

        PriorityQueue<Integer> maxPriority = new PriorityQueue<>((a,b) -> (b - a));
        maxPriority.add(-5);
        maxPriority.add(1);
        maxPriority.add(6);
        maxPriority.add(2);
        maxPriority.add(3);
        maxPriority.add(10);

        System.out.println("max priority: " + maxPriority.poll());
        System.out.println("Peek: " + maxPriority.peek());


//        MinHeap myMinHeap = new MinHeap(10);
//        myMinHeap.insert(5);
//        myMinHeap.insert(1);
//        myMinHeap.insert(6);
//        myMinHeap.insert(2);
//        myMinHeap.insert(3);
//        myMinHeap.insert(10);
//
//        System.out.println("min: " + myMinHeap.extractMin());
//        System.out.println(myMinHeap.peek());
//
//        int[] arr = new int[]{6, 8, 1, 0, 2, 10, 19, 88};
//        myMinHeap.buildHeap(arr);

//        System.out.println("min: " + myMinHeap.extractMin());
//        myMinHeap.traverse();
//        myMinHeap.sortedExtract();


//        PriorityQueue<Integer> minPriority = new PriorityQueue<>();
//        minPriority.add(-5);
//        minPriority.add(1);
//        minPriority.add(6);
//        minPriority.add(2);
//        minPriority.add(3);
//        minPriority.add(10);
//
//        System.out.println("min priority: " + minPriority.poll());
//        System.out.println("Peek: " + minPriority.peek());
//
//
//

    }
}
