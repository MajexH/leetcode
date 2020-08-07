package highFrequency.stackAndHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomIINew {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        // queue 保存最早结束的时间 应该是一个小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (queue.size() == 0) {
                // 添加结束的时间
                queue.add(interval[1]);
            } else {
                int preEarlyFinish = queue.peek();
                if (preEarlyFinish <= interval[0]) {
                    queue.poll();
                }
                queue.add(interval[1]);
            }
        }
        System.out.println(Arrays.deepToString(intervals));
        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(new MeetingRoomIINew().minMeetingRooms(new int[][]{
                {7, 10},
                {2, 4}
        }));
    }
}
