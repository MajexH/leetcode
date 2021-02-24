package highFrequency.stackAndHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII_New {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> {
            if (l[0] == r[0]) {
                return l[1] - r[1];
            }
            return l[0] - r[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (pq.size() == 0) {
                pq.add(interval[1]);
                continue;
            }
            int earliestEndTime = pq.peek();

            if (earliestEndTime <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}
