import java.util.Arrays;
class Solution 
{
    public List<List<Integer>> fourSum(int[] arr, int target) 
    {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for(int i=0;i<n-3;i++)
        {

            //to remove first duplicate
            if(i>0 && arr[i] == arr[i-1])
                continue;

            for(int j=i+1;j<n-2;j++)
            {
                //to remove second duplicate
                if(j>i+1 && arr[j]==arr[j-1])
                    continue;

                int left = j+1;
                int right = n-1;
                
                while(left<right)
                {
                    long sum = (long)arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum == target)
                    {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                    left++;
                    right--;


                    //to remove third duplicate
                    while(left<right && arr[left]==arr[left-1])
                    {
                        left++;
                    }

                    //to remove fourth duplicate
                    while(left<right && arr[right] == arr[right+1])
                    {
                        right--;
                    }
                 }
                 else if(sum<target)
                 {
                left++;
                 }
                 else
                 {
                right--;
                  }

                }
        }
        
        }
        return result;

    }
}