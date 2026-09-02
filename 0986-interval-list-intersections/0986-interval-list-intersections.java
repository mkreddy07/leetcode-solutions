class Solution 
{
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) 
    {
        List<int[]> result = new ArrayList<>();
        int ptr1=0;
        int ptr2 = 0;
        while(ptr1<firstList.length && ptr2<secondList.length)
        {
            int firstStart = firstList[ptr1][0];
            int firstSecond = firstList[ptr1][1];

            int secondFirst = secondList[ptr2][0];
            int secondSecond = secondList[ptr2][1];

            if(firstSecond>=secondFirst && firstStart<=secondSecond)
            {
                int max = Math.max(secondFirst, firstStart);
                int min = Math.min(firstSecond,secondSecond);
                result.add(new int[]{max, min});
            }
            
            if(firstList[ptr1][1]<secondList[ptr2][1])
            {
                ptr1++;
            }
            else
            {
                ptr2++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}