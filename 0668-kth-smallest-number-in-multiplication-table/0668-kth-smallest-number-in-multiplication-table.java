class Solution 
{
    public int findKthNumber(int m, int n, int k) 
    {
        long low = 1;
        long high = (long)n*m;

        while(low<high)
        {
            long mid = low + (high-low)/2;
            long count = 0;
            for(int i=1; i<=m; i++)
            {
                count+=Math.min(n, mid/i);
            }

            if(count<k)
            {
                low = mid+1;
            }
            else
                high = mid;
            

        }
        return (int)low;
    }
}