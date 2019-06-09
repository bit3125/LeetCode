package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**�㷨������ʵ��һ��Set��insert��remove����O1��ͬʱ�ѵ�����ʵ��һ��randomGet������Ҳ��O1
 * ��jdk�У�Set������HashMapֱ��ʵ�֣�insert��remove����O1
 * ���Ǳ������һ�����ȡԪ�صĹ��ܣ���ͱȽ��鷳��
 *
 * �ܵ�LRU�������������ʹ��List+HashMap
 *
 * 1.LinkedList(store data)+HashMap(<key, node>)��insert O1, remove O1, random On(�����޷�������ʣ��õ�һ��randomInt��������)
 * 2.ArrayList(store data)+HashMap(<key, idx>): insert O1, random O1(�������), remove ����ó��淽���Ļ�����On
 * ��������ʹ��һ�����ɣ�ʹ��copy���remove����list����Ԫ�ظ��ǵ���ǰԪ�أ�Ȼ��remove��LastOfList(O1)
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
