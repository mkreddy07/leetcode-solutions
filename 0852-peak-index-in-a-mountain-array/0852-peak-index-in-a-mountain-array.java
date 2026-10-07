class Solution 
{
    public int peakIndexInMountainArray(int[] arr) 
    {
        int max = Integer.MIN_VALUE;
         int maxValIndex = -1;
        int left = 0;
        int right = arr.length-1;
        while(left<=right)
        {
            if(arr[left]<arr[right])
            {
                left++;
            }
            else if(arr[right]<arr[left])
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return right;
    }
}