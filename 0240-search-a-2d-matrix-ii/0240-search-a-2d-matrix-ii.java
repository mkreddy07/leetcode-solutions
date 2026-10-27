class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int m = matrix[0].length;
        for(int i=0; i<matrix.length; i++)
        {
            if(target>=matrix[i][0] && target<=matrix[i][m-1])
                {
                    if(searchElement(matrix[i], target))
                         return true;
                    
                }
        }
        return false;
    }

    boolean searchElement(int[] matrix, int target)
    {
        int low = 0;
        int high = matrix.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(target==matrix[mid])
            {
                return true;
            }
           else if(target>matrix[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }
}