package StackAndQueue;

class Node<T>{
    Node<T> next;
    T data;

    public Node(T data){
        this.next = null;
        this.data = data;
    }
}

class StackLinkedList <T> {

    private Node<T> head;
    private int size;

    public void push(T data){
        Node<T> newNode = new Node<>(data);

        if (head != null){
            newNode.next = head;
        }

        head = newNode;
        size++;
    }

    public T pop(){
        if (head == null){
            return null;
        }

        T popped = head.data;
        head = head.next;
        size--;

        return popped;
    }

    public int size(){
        return size;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Stack: [");

        Node<T> temp = head;
        while(temp != null){
            sb.append(temp.data);
            sb.append(temp.next != null? " -> ": "");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

}