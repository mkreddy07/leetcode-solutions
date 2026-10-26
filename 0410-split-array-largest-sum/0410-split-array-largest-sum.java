class Solution 
{
    public int splitArray(int[] nums, int k) 
    {

        if(k>nums.length)
            return -1;

        int max = 0;
        int sum = 0;
        for(int num: nums)
        {
            max = Math.max(num, max);
            sum+=num;
        }
        int low = max;
        int high = sum;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int result = getResult(nums, mid);
            if(result>k)
            {
                low = mid+1;
            }
            else
             high = mid-1;
        }

        return low;
    }

    int getResult(int nums[], int num)
    {
        int count = 1;
        int largestSum = 0;

        for(int j=0; j<nums.length; j++)
        {
            if(largestSum+nums[j]<=num)
            {
                largestSum+=nums[j];
            }
            else
            {
                count++;
                largestSum = nums[j];
            }
        }
        return count;
    }
}