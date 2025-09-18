package heap;

public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity){
        heap = new int[capacity];
        size = 0;
    }

    private void heapifyUp(int index){
        while(index > 0){
            int parent = (index - 1) / 2;

            if(heap[index] < heap[parent]){
                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;
                index = parent;
            }else{
                break;
            }
        }
    }

    private void heapifyDown(int index){
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < size && heap[left] < heap[smallest]) smallest = left;
        if(right < size && heap[right] < heap[smallest]) smallest = right;

        if(smallest != index){
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            heapifyDown(smallest);
        }
    }

    public void insert(int val){
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    public int extractMin(){
        if(size == 0) throw new IllegalStateException("heap empty");

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return min;
    }

    public int peek(){
        if(size == 0) throw new IllegalStateException("heap empty");
        return heap[0];
    }

    public void buildHeap(int[] arr){
        this.heap = arr;
        this.size = arr.length;

        for(int i = size / 2 - 1; i >= 0; i--){
            heapifyDown(i);
        }
    }

    public void traverse(){
        inOrderTraverse(0, size);
    }

    private void inOrderTraverse(int i, int n){
        if(i >= n) return;

        System.out.print(heap[i] + ", ");
        inOrderTraverse(2 * i + 1, n);
        inOrderTraverse(2 * i + 2, n);
    }

    public void sortedExtract(){
        System.out.println();
        while(size > 0){
            System.out.print(extractMin() + ", ");
        }
    }
}
