class Solution 
{
    public boolean circularArrayLoop(int[] nums) 
    {
        int n = nums.length;

        for (int start = 0; start < n; start++)
        {
            if (nums[start] == 0) 
                continue;

            boolean direction = nums[start] > 0;
            int slow = start;
            int fast = start;
            boolean foundCycle = false;

            while (true)
            {
                int nextSlow = nextIndex(nums, slow);
                if (nums[nextSlow] == 0 || (nums[nextSlow] > 0) != direction || nextSlow == slow)
                    break;

                int firstHopFast = nextIndex(nums, fast);
                if (nums[firstHopFast] == 0 || (nums[firstHopFast] > 0) != direction || firstHopFast == fast)
                    break;

                int secondHopFast = nextIndex(nums, firstHopFast);
                if (nums[secondHopFast] == 0 || (nums[secondHopFast] > 0) != direction || secondHopFast == firstHopFast)
                    break;

                slow = nextSlow;
                fast = secondHopFast;

                if (slow == fast)
                {
                    foundCycle = true;
                    break;
                }
            }

            if (foundCycle)
                return true;

            int i = start;
            while (nums[i] != 0 && (nums[i] > 0) == direction)
            {
                int next = nextIndex(nums, i);
                nums[i] = 0;
                i = next;
            }
        }

        return false;
    }

    public int nextIndex(int[] nums, int i)
    {
        int n = nums.length;
        return (((i + nums[i]) % n) + n) % n;
    }
}