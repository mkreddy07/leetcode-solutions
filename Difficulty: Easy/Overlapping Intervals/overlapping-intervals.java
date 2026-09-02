class Solution {
    
   static boolean isInterction(int a[], int b[])
    {
        if(a[1]>=b[0] && a[0]<=b[1])
            return true;
        return false;
    }
    
    
    static boolean isIntervals(int[][] intervals)
    {
        for(int i=0;i<intervals.length; i++)
        {
            for(int j=i+1; j<intervals.length; j++)
            {
                if(isInterction(intervals[i], intervals[j])){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    static boolean isIntersect(int[][] intervals) {
        // Code Here
        if(isIntervals(intervals))
            return true;
        
        else
            return false;
    }
}