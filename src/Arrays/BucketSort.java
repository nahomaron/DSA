package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args){
        float[] arr = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(float[] arr){
       int n = arr.length;
       if(n <= 0) return;

       List<Float>[] buckets = new ArrayList[n];

       for(int i = 0; i < n; i++){
           buckets[i] = new ArrayList<>();
       }

       for(float num : arr){
         int index = (int) num * n;
         buckets[index].add(num);
       }

       for(List<Float> bucket : buckets){
           Collections.sort(bucket);
       }

       int index = 0;
       for(List<Float> bucket : buckets){
           for(float num : bucket){
               arr[index++] = num;
           }
       }
    }
}
