class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
      int n = matrix.length;
      int m = matrix[0].length;

// int low = matrix[0][0];
// int high = matrix[n-1][n-1];

// while(low<high)
// {
//     int mid = low+(high-low)/2;

//     int count = 0;

//     int row = n-1;
//     int col = 0;

//     while(row>=0 && col<n)
//     {
//         if(matrix[row][col]<=mid)
//         {   
//             count+=row+1;
//             col++;
//         }
//         else
//         {
//             row--;
//         }
//     }
//     if(count<k)
//     {
//         low =mid+1;
//     }
//     else
//     {
//         high =mid;
//     }
// }
// return low;

//     }

PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> {
        return Integer.compare(a[0], b[0]);
    }
);

for(int i=0; i<matrix.length; i++)
{
    pq.add(new int[]{matrix[i][0], i, 0});
}
int count = 0;
while(!pq.isEmpty())
{
    int current[] = pq.poll();
    int val = current[0];
    int row = current[1];
    int col = current[2];
    count++;
    if(count == k)
        return val;
    if(col+1<m)
    {
        pq.add(new int[]{matrix[row][col+1], row, col+1});
    }
}
return -1;

}
}
