class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        List<int[]> result = new ArrayList<>();

       //add intervals that are completely before newIntervals
       int i=0;
       while(i<intervals.length && intervals[i][1]<newStart)
       {
        result.add(intervals[i]);
        i++;
       }

        //add overlapping intervals:
       while(i<intervals.length && intervals[i][0]<=newEnd)
       {
        newStart = Math.min(newStart, intervals[i][0]);
        newEnd = Math.max(newEnd, intervals[i][1]);
        i++;
       }

        result.add(new int[]{newStart, newEnd});

        while(i<intervals.length)
        {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);



    }
}