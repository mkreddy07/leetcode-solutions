class Solution 
{
    public int maximumCandies(int[] candies, long k) 
    {
        long sum = 0;
        int max = 0;
        for(int candi: candies)
        {
            sum+=candi;
            max = Math.max(max, candi);
        }
        if(sum<k)
        {
            return 0;
        }

        int low = 1;
        int high = max;
        int answer = 0;
       while(low<=high)
       {
        int mid = low + (high-low)/2;
        long children = 0;
        for(int candi: candies)
        {
            children+=candi/mid;
        }
         if(children>=k)
         {
            answer = mid;
            low = mid+1;
         }
         else
         {
            high = mid-1;
         }
    }
         return answer; 
    }
}