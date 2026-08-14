class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start =0;
        int end =0;
        int sum =0;
        int result =Integer.MAX_VALUE;
      
      while(end<nums.length){
            sum +=nums[end++];
            while(sum>=target){
           result = Math.min(result,end -start );
           sum -=nums[start++];
            }
           
        }
        return result ==Integer.MAX_VALUE ? 0 : result;

        
    }
}