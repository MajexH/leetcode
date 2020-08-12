package highFrequency.stackAndHeap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {

    // 给定一组数 每个 interval 表示一个会议的开始时间和结束时间
    // 问 最少需要占用多少个会议室
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(pre -> pre[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (queue.size() != 0) {
                // 加入结束时间

                // 如果最早结束的时间比开始时间晚 则说明需要新的会议室
                int earlyEnd = queue.peek();
                if (earlyEnd <= interval[0]) {
                    // 如果小于等于开始时间 则说明可以接着用
                    queue.poll();
                }
            }
            queue.add(interval[1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(new MeetingRoomII().minMeetingRooms(new int[][]{
                {0, 30},

                {5, 10},
                {15, 20}

        }));
    }
}
