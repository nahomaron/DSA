package StackAndQueue;

class StackArray<T>{
    private T[] stack;
    private int capacity;
    private int top;

    @SuppressWarnings("unchecked")
    public StackArray(int capacity){
        this.stack = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.top = - 1;
    }

    public int size(){
        return top + 1;
    }

    public void push(T data){
        if(size() == capacity - 1){
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = data;
    }

    public T peek(){
        if (isEmpty()){
            return null;
        }
        return stack[top];
    }
    
    public T pop(){
        if (top == -1){
            return null;
        }
        return stack[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("Stack: [");

        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i != top) sb.append(", ");
        }

        sb.append("]");

        return sb.toString();
    }

}