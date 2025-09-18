package heap;

public class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private void heapifyUp(int index){
        while(index > 0){
            int parent = (index - 1) / 2;

            if(heap[index] > heap[parent]){
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
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < size && heap[left] > heap[largest]) largest = left;
        if(right < size && heap[right] > heap[largest]) largest = right;

        if(largest != index){
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapifyDown(largest);
        }
    }

    public void insert(int val){
        if(size == capacity) throw new IllegalStateException("Heap full");
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    public int extractMax(){
        if(size == 0) throw new IllegalStateException("Heap is Empty");

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return max;
    }

    public void buildHeap(int[] arr){
        this.heap = arr;
        this.size = arr.length;

        for(int i = size / 2 - 1; i >= 0; i--){
            heapifyDown(i);
        }
    }
}
