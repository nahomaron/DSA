package hashTable;

import java.util.ArrayList;
import java.util.List;

class HashSet {
    private final int size;
    private int count;
    private final List<List<String>> buckets;

    public HashSet(int size){
        this.size = size;
        this.count = 0;
        this.buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public int hash(String key){
        return Math.abs(key.hashCode()) % size;
    }

    public void insert(String key){
        int index = hash(key);
        List<String> bucket = buckets.get(index);
        if(!bucket.contains(key)){
            bucket.add(key);
            count++;
        }
    }

    public void remove(String key){
        int index = hash(key);
        List<String> bucket = buckets.get(index);
        if(bucket.remove(key)){
            count--;
        }
    }

    private boolean contains(String key){
        int index = hash(key);
        List<String> bucket = buckets.get(index);
        return bucket.contains(key);
    }
}
