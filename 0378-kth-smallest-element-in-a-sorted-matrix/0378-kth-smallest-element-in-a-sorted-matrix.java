class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int n = matrix.length;
        
        int temp[] = new int[n*n];
        int index = 0;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                temp[index++] = matrix[i][j];
            }
        }

        Arrays.sort(temp);
        return temp[k-1];
    }
}