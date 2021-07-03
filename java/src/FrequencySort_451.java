import java.util.PriorityQueue;

public class FrequencySort_451 {

    private static class Pair {
        int count;
        char c;

        public Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

    public String frequencySort(String s) {
        int[] counter = new int[257];

        for (char c : s.toCharArray()) {
            counter[c]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        for (int i = 0; i < 257; i++) {
            if (counter[i] != 0) {
                pq.add(new Pair(counter[i], (char) (i)));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (pq.size() > 0) {
            Pair top = pq.poll();
            int t = top.count;
            while (t > 0) {
                builder.append(top.c);
                t--;
            }

        }
        return builder.toString();
    }
}
