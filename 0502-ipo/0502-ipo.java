class Solution 
{
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) 
    {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        //storing all capitals and profits as well
        for(int i=0; i<capital.length; i++)
        {
            minHeap.add(new int[]{capital[i], profits[i]});
        }


        //max heap for storing max profits;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b, a));


        //inserting all affordable projects;

        for(int i=0; i<k; i++)
        {
            while(!minHeap.isEmpty() && minHeap.peek()[0]<=w)
            {
                maxHeap.add(minHeap.poll()[1]);
            }

            if(maxHeap.isEmpty())
            {
                break;
            }

            w+=maxHeap.poll();
        }
        return w;
    }
}