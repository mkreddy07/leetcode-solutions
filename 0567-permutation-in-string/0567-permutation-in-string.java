class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        if(s1.length()>s2.length())
            return false;
        
        int s1Freq[] = new int[26];
        int windowFreq[] = new int[26];

        int left = 0;

        for(int i=0; i<s1.length(); i++)
            s1Freq[s1.charAt(i)-'a']++;
        
        int windowLength = s1.length();

        for(int i=0;i<windowLength; i++)
        {
            windowFreq[s2.charAt(i)-'a']++;
        }

        if(matches(s1Freq, windowFreq)){
            return true;
        }

        for(int right=windowLength; right<s2.length(); right++)
        {
            char ch = s2.charAt(right);
            windowFreq[ch-'a']++;
            left = right-windowLength;
            windowFreq[s2.charAt(left)-'a']--;

            if(matches(s1Freq, windowFreq)){
                return true;
            }
        }
        return false;
    }

    public boolean matches(int s1Freq[], int windowFreq[])
    {
        for(int i=0;i<26;i++)
        {
            if(s1Freq[i]!=windowFreq[i])
                return false;
        }
        return true;
    }
}