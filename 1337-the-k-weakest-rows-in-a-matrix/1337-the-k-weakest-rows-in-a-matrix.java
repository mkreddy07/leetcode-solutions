class Solution {
            
     PriorityQueue<Integer> pq = new PriorityQueue<>();


    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b)->{
                if(a[0]!=b[0])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );
        
        for(int i=0; i<mat.length; i++)
        {
            int count = 0;
            for(int j=0; j<mat[i].length; j++)
            {
                if(mat[i][j] == 1)
                    count++;
            }
            pq.add(new int[]{count, i});
        }

        int result[] = new int[k];
        for(int i=0; i<k; i++)
        {
            int current = pq.poll()[1];
            result[i] = current;
        }

        return result;

    }
}