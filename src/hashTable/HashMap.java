package hashTable;

import java.util.ArrayList;
import java.util.List;

class Pair{
    String key;
    String value;

    public Pair(String key, String value){
        this.key = key;
        this.value = value;
    }
}
public class HashMap {
    private final List<List<Pair>> buckets;
    private final int size;

    public HashMap(int size){
        this.size = size;
        this.buckets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public int hash(String key){
        return Math.abs(key.hashCode()) % size;
    }

    public void put(String key, String value){
        int index = hash(key);
        List<Pair> bucket = buckets.get(index);

        for (Pair pair: bucket){
            if(pair.key.equals(key)){
                pair.value = value;
                return;
            }
        }

        bucket.add(new Pair(key, value));
    }

    public String get(String key){
        int index = hash(key);
        List<Pair> bucket = buckets.get(index);

        for (Pair pair: bucket){
            if(pair.key.equals(key)){
                return pair.value;
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        List<Pair> bucket = buckets.get(index);
        bucket.removeIf(pair -> pair.key.equals(key));
    }

    public void printMap(){
        System.out.println("===== HashMap =====");
        for (int i = 0; i < size; i++) {
            List<Pair> bucket = buckets.get(i);
            System.out.print("\nB" + i + ": ");
            bucket.forEach(pair -> System.out.print("[" + pair.key + ":" + pair.value + "]"));
        }
    }
}
