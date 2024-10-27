package round4.q692TopKFrequentWords;

import java.util.*;
class Solution {
    class Pair {
        String word;
        int cnt;

        Pair(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || k > words.length) {
            return result;
        }

        // cnt
        Map<String, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            cntMap.put(words[i], cntMap.getOrDefault(words[i], 0) + 1);
        }

        // sort
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if (p1.cnt == p2.cnt) {
                    return p2.word.compareTo(p1.word);
                }

                return Integer.compare(p1.cnt, p2.cnt);
            }

        });
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            // System.out.println(entry.getKey());
            minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // assemble
        while(!minHeap.isEmpty()) {
            result.add(minHeap.poll().word);
        }
        Collections.reverse(result);
        return result;
    }
}