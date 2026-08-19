class Solution {
    public int maxAbsoluteSum(int[] nums) {

        if(nums.length==1)
        {
            if(nums[0]<0)
                return nums[0]*(-1);
            return nums[0];
        }

        int maxSum = nums[0];
        int sum1 = nums[0];
        int sum2 = nums[0];
        int minSum = Integer.MAX_VALUE;

        for(int i=1; i<nums.length; i++)
        {
            sum1 = Math.max(sum1+nums[i], nums[i]);
            sum2 = Math.min(sum2+nums[i], nums[i]);
            maxSum = Math.max(sum1, maxSum);
            minSum = Math.min(sum2, minSum);
        }
         minSum = minSum*(-1);
        return Math.max(maxSum, minSum);
    }
}