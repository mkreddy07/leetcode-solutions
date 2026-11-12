class Solution 
{
    public int lastStoneWeight(int[] stones) 
    {

        //create maxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b,a)
        );

        for(int stone: stones)
        {
            pq.add(stone);
        }

        while(pq.size()>1)
        {
            int first = pq.poll();
            int second = pq.poll();

            if(first!=second)
            {
                pq.add(first - second);
            }
        }
        return pq.isEmpty()? 0: pq.poll();

    }
}
