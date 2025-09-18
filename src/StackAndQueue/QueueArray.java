package StackAndQueue;

public class QueueArray<T>{

    private T[] queue;
    private int size;
    private int capacity;
    private int front;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity){
        this.queue = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.front = 0;
    }

    public void enqueue(T data){
        if(size == capacity){
            System.out.println("Queue is full");
            return;
        }

        queue[(front + size) % capacity] = data;
        size++;
    }

    public T dequeue(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }

        T item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T peek(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }

        return queue[front];
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Queue : [");
        for (int i = 0; i < size; i++) {
            sb.append(queue[(front + i) % capacity]);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}