class Solution {
    public int findDuplicate(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int number = nums[i];
            if(hs.contains(number))
            {
                return number;
            }
            else
            {
                hs.add(number);
            }
        }
        return 0;
    }
}