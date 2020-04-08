import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, (a, b) -> b - a);
        for (int stone: stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            heap.add(Math.abs(heap.poll() - heap.poll()));
            System.out.println(heap);
        }
        if (heap.size() == 1) return heap.poll();
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeight_1046().lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
