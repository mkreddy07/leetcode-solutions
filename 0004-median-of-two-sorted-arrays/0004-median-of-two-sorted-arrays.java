class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;

        //number of elements on left side
        int half = (n1+n2+1)/2;

        while(low<=high)
        {
            int i = low +(high-low)/2;
            int j = half-i;

            int left1 = (i==0) ? Integer.MIN_VALUE: nums1[i-1];
            int right1 = (i==n1)? Integer.MAX_VALUE: nums1[i];
            int left2 = (j==0)? Integer.MIN_VALUE: nums2[j-1];
            int right2 = (j==n2)? Integer.MAX_VALUE: nums2[j];

        //valid symmetry
            if(left1<=right2 && left2<=right1)
            {
                //if elements are odd
                if((n1+n2)%2 == 1 )
                {
                    return Math.max(left1, left2);
                }

                // if elements are even
                int left = Math.max(left1, left2);
                int right = Math.min(right1, right2);

                return ((double)left+right)/2;
            }

            else if(left1>right2)
            {
                high = i-1;
            }
            else
            {
                low = i+1;
            }

        }
        return 0.0;
    }
}