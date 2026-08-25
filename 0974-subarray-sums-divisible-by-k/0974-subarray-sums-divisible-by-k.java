class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0; i<nums.length; i++)
        {

            sum+=nums[i];
            int value = sum%k;
            if(value<0)
            {
                value+=k;
            }
            if(hm.containsKey(value))
            {
                count+=hm.get(value);
            }
    
            hm.put(value, hm.getOrDefault(value, 0)+1);
        }
        return count;
    }
}
