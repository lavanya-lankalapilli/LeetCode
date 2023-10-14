package TopInterviewQuestions;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastVal = list.get(list.size() - 1);
            int ind = map.get(val);
            map.put(lastVal, ind);
            list.set(ind, lastVal);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int i = 10;
        while (i-- > 0) {
            System.out.println(rand.nextInt(5));
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
