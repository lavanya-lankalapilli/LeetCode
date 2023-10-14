package TopInterviewQuestions;

import java.util.*;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= endTimes.peek()) {
                endTimes.poll();
            }
            endTimes.add(intervals[i][1]);
        }
        return endTimes.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        System.out.println(new MeetingRooms().minMeetingRooms(intervals));
    }
}
