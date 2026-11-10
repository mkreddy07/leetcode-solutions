class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            long d1 = Math.abs((long)a-x);
            long d2 = Math.abs((long)b-x);

            if(d1!=d2)
            {
                return Long.compare(d2, d1);
            }
            return Integer.compare(b, a);
        });

        for(int num: arr)
        {
            pq.add(num);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
        {
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}