class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0,1);
        int prefixSum = 0;
        int result = 0;
        for(int num: nums)
        {
            prefixSum+=num;
            if(sumCount.containsKey(prefixSum-k))
            {
                result+=sumCount.get(prefixSum-k);
            }
            sumCount.put(prefixSum, sumCount.getOrDefault(prefixSum, 0)+1);
        }
        return result;
}
}