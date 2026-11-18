class Solution {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        //to store all duration and last days
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        int totalDays = 0;

        for(int i=0; i<courses.length; i++)
        {
            int duration = courses[i][0];
            int deadline = courses[i][1];

            totalDays+=duration;

            maxHeap.add(duration);

            if(totalDays>deadline)
            {
                totalDays-=maxHeap.poll();
            }
        }
    return maxHeap.size();
}
}