class Solution 
{
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare(checkDistance(a), checkDistance(b)));

    public int[][] kClosest(int[][] points, int k) 
    {
        for(int i=0; i<points.length; i++)
        {
            pq.add(points[i]);
        }
        int result[][] = new int[k][2];
        for(int i=0; i<k; i++)
        {
            result[i] = pq.poll();
        }
        return result;
    }

        public double checkDistance(int[] points)
        {
            int x1 = points[0];
            int y1 = points[1];
            double distance = Math.pow(x1, 2)+Math.pow(y1, 2);  
            return distance;
        }
}