class Solution 
{
    public int maxSubarraySumCircular(int[] nums) 
    {
        int maxSum = nums[0];
        int currentMax = nums[0];

        int minSum = nums[0];
        int currentMin = nums[0];

        int totalSum = 0;


        for(int i=0; i<nums.length; i++)
        {
            totalSum+=nums[i];
            if(i>0)
            {
               currentMax = Math.max(currentMax+nums[i], nums[i]);
               maxSum = Math.max(currentMax, maxSum);

               currentMin = Math.min(currentMin+nums[i], nums[i]);
               minSum = Math.min(currentMin, minSum); 
            }
        }

        //normal sub array
        if(maxSum<0)
            return maxSum;

        //circular sub array
        int currentSum = totalSum - (minSum);

        return Math.max(maxSum, currentSum);
        

    }
}