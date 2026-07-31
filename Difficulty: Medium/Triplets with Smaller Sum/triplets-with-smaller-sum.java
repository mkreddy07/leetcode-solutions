class Solution {
    int countTriplets(int sum, int arr[]) {
        
        int c = 0;
        Arrays.sort(arr);
        // code here
        for(int i=0;i<arr.length-2;i++)
        {
           int left = i+1;
           int right = arr.length-1;
           
           while(left<right)
           {
               int sumVal = arr[i]+arr[left]+arr[right];
               
               if(sumVal<sum)
               {
                   c+=right-left;
                   left++;
               }
               
               else
                 right--;
           }
        }
        return c;
    }
}