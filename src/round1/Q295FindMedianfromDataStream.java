package round1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q295FindMedianfromDataStream {

    public static class MedianFinder{

        private PriorityQueue<Integer> minHeap, maxHeap; //insert minHeap first

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });
        }

        public void addNum(int num) {
            if (minHeap.size() > maxHeap.size()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            return minHeap.size()>maxHeap.size()?minHeap.peek():(minHeap.peek() + maxHeap.peek())/2.0;
        }

    }

    public static void main(String[] args) {
        MedianFinder md = new MedianFinder();
        md.addNum(1);
        md.addNum(2);
        System.out.println(md.findMedian());
        md.addNum(3);
        System.out.println(md.findMedian());

    }
}
