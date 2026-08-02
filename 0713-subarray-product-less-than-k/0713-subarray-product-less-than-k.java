class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k<=0)
            return 0;
        long productSum = 1;
        int count= 0;
        int left = 0;

        for(int right = 0;right<nums.length;right++)
        {
            productSum = productSum*nums[right];
                while(left<=right && productSum>=k){
                    productSum = productSum/nums[left];
                    left++;
                }

                count = count +(right-left+1);

        }
        return count;
    }
}