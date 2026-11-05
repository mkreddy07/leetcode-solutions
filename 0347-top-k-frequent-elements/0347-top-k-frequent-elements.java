class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hm.entrySet());


        //sorting in descending order
        entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int result[] = new int[k];

        for(int i=0; i<k; i++)
        {
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }
}