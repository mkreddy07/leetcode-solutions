class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int minSum = arr[0];
        int sum = arr[0];
        
        for(int i=1; i<arr.length; i++)
        {
            sum = Math.min(sum+arr[i], arr[i]);
            minSum = Math.min(sum, minSum);
        }
        return minSum;
    }
}