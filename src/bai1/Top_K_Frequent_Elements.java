package bai1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        // step 1:  create a hash map to put a key is a number in the array
        // value is how many times that number appear in the array
        Map<Integer, Integer> counter = new HashMap<>();

        // iterate through the array and put it in the hash map, if first the
        // number n is not in the hash map it will push the number n is a key and
        // and when the number n does not exist it will push that number with the value + 1
        // and when it appear the second time it will get the value from the first one and
        // plus one more
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        // create a heap as a priority queue and compare by using the valye
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );
        // use to add the key and value of the map in heap
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            heap.offer(entry);
        }
        // so next we create a array res with the value of k
        // to return to K frequen  element the appear the most
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(heap.poll()).getKey();
        }

        return res;
    }
    public static void main(String[] args) {
        Top_K_Frequent_Elements t = new Top_K_Frequent_Elements();
        int[] k =t.topKFrequent(new int[]{1,1,1,3,3,3,3}, 2);
        System.out.println(k);
    }

}
