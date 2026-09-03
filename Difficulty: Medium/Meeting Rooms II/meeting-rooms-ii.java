class Solution
{
    public int minMeetingRooms(int[] start, int[] end) 
    {
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0;
        int maxRooms = 0;
        int i=0, j=0;
        while(i<start.length)
        {
            if(start[i]<end[j])
            {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            }
            else
            {
                rooms--;
                j++;
            }
        }
        return maxRooms;
        
        
    }
}