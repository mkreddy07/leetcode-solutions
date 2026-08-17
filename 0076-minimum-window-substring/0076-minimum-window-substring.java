class Solution {
    public String minWindow(String s, String t) {

        if(s.equals(t))
            return s;
        if(t.length()>s.length())
            return "";

        int left = 0;
        int minStart = 0;

        int mapS[] = new int[256];
        int mapT[] = new int[256];

          String result="";
            int minLength = Integer.MAX_VALUE;

        for(char ch: t.toCharArray())
            mapT[ch]++;

        for(int right=0; right<s.length(); right++)
        {
            mapS[s.charAt(right)]++;

            while(containsAll(mapT, mapS))
            {
                if(right-left+1<minLength)  
                {
                    minLength = right-left+1;
                    minStart = left;
                } 
                mapS[s.charAt(left++)]--;

            }
        }
            return minLength==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLength);
    }

    public boolean containsAll(int mapT[], int mapS[])
    {
       for(int i=0; i<256; i++)
       {
        if(mapT[i]>mapS[i])
            return false;
       }
        return true;
    }
}