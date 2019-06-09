package round1;

import structures.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q341FlattenNestedListIterator_Solution1 {

    public class NestedIterator implements Iterator<Integer> {
        private List<Integer> data;
        private Iterator<Integer> iter;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.data = new ArrayList<>();
            flatten(nestedList, this.data);
            iter = data.iterator();
        }

        private void flatten(List<NestedInteger> nestedList, List<Integer> result) {
            if (nestedList == null)
                return;

            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    result.add(nest.getInteger());
                } else  //isList
                    flatten(nest.getList(), result);
            }
        }

        @Override
        public Integer next() {
            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }
    }

}
