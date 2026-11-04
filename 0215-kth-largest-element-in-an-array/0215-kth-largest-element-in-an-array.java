class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,a));

        for(int num : nums)
        {
            pq.add(num);
        }
        int count = 0;
        while(!pq.isEmpty())
        {
            int current = pq.poll();
            count++;

            if(count==k)
            {
                return current;
            }

        }
        return -1;
    }
}