class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < servers.length; i++) {
            free.add(new int[]{i, servers[i]});
        }
        int res[] = new int[tasks.length];
        int time = 0, task = 0;
        while (task < tasks.length) {
            while (!busy.isEmpty() && busy.peek()[1] <= time) {
                int id = busy.poll()[0];
                free.add(new int[]{id, servers[id]});
            }
            while (!free.isEmpty() && task <= time && task<tasks.length) {
                int id = free.poll()[0];
                busy.add(new int[]{id, time + tasks[task]});
                res[task++] = id;
            }
            if (free.isEmpty()) {
                time = busy.peek()[1];
            } else {
                time++;
            }
        }
        return res;
    }
}
