
import java.util.*;

class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        for (int count : freq) {
            if (count > 0) {
                pq.add(count);
            }
        }

        int intervals = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;
            int tasksExecuted = 0;

            for (int i = 0; i < cycle; i++) {

                if (!pq.isEmpty()) {

                    int current = pq.poll();

                    current--;

                    if (current > 0) {
                        temp.add(current);
                    }

                    tasksExecuted++;
                }
            }

            for (int count : temp) {
                pq.add(count);
            }

            if (!pq.isEmpty()) {
                intervals += cycle;
            } else {
                intervals += tasksExecuted;
            }
        }

        return intervals;
    }
}
