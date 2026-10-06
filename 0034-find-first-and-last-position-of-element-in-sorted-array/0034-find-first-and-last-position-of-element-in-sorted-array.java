class Solution {
    public int[] searchRange(int[] nums, int target) {

        int startIndex = startIndex(nums, target);
        int endIndex = endIndex(nums, target);
        return new int[]{startIndex, endIndex};
    }

    public static int startIndex(int nums[], int target)
    {
        int left = 0;
        int right = nums.length-1;
        int startIndex = -1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
            {
                startIndex = mid;
                right = mid-1;
            }
            else if(target>nums[mid])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        return startIndex;
    }

    public static int endIndex(int nums[], int target)
    {
        int left = 0;
        int right = nums.length-1;
        int endIndex = -1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
            {
                endIndex = mid;
                left = mid+1;
            }
            else if(target>nums[mid])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        return endIndex;
    }


}