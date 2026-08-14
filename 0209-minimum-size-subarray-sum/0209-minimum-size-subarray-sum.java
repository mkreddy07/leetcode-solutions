class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right<nums.length; right++)
        {
            //expand the window size
            sum+=nums[right];

            //shrink the window size
            while(sum>=target)
            {
                int length = right-left+1;
                minLength = Math.min(minLength, length);
                sum-=nums[left];
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;

    }
}