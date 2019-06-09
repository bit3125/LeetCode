package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**算法分析：实现一个Set，insert与remove都是O1，同时难点在于实现一个randomGet操作，也是O1
 * 在jdk中，Set可以用HashMap直接实现，insert跟remove就是O1
 * 但是本题多了一个随机取元素的功能，这就比较麻烦了
 *
 * 受到LRU题的启发，尝试使用List+HashMap
 *
 * 1.LinkedList(store data)+HashMap(<key, node>)：insert O1, remove O1, random On(链表无法随机访问，得到一个randomInt后必须遍历)
 * 2.ArrayList(store data)+HashMap(<key, idx>): insert O1, random O1(随机访问), remove 如果用常规方法的话就是On
 * 但是这里使用一个技巧：使用copy替代remove，把list最后的元素覆盖掉当前元素，然后remove掉LastOfList(O1)
 *
 * */
public class Q380InsertDeleteGetRandomO1 {

    class RandomizedSet {

        private ArrayList<Integer> data;
        private Map<Integer, Integer> val2Idx;
        private Random rand ;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            data = new ArrayList<>();
            val2Idx = new HashMap<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (val2Idx.containsKey(val))
                return false;

            val2Idx.put(val, data.size());
            data.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!val2Idx.containsKey(val))
                return false;

            Integer lastVal = data.get(data.size()-1);
            data.set(val2Idx.get(val), lastVal);
            val2Idx.put(lastVal, val2Idx.get(val)); //***bug:update lastVal's idx
            data.remove(data.size() - 1);
            val2Idx.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return data.get( rand.nextInt(data.size()) );
        }
    }

}
