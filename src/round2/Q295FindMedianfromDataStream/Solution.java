package round2.Q295FindMedianfromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    class MedianFinder {

        private PriorityQueue<Integer> minHeap, maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });
        }

        // maxHeap first
        public void addNum(int num) {
            if (maxHeap.size() > minHeap.size()) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else { // maxHep.size() == minHeap.size()
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size()+minHeap.size()==0)
                return 0;
            return maxHeap.size()>minHeap.size()?(maxHeap.peek()*1.0):( (maxHeap.peek()+minHeap.peek())/2.0 );
        }
    }

}
