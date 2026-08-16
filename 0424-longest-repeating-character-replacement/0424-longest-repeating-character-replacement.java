class Solution {
    public int characterReplacement(String s, int k) {
        
        int freq[] = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for(int right=0;right<s.length();right++)
        {
            char ch = s.charAt(right);
            int index = ch - 'A';
            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);
            //number of characters we need to replace
            int windowLength = right - left+1;
            int replaceMent = windowLength - maxFreq;

            while(replaceMent>k)
            {
                freq[s.charAt(left)-'A']--;
                left++;

                windowLength = right-left+1;
                replaceMent = windowLength-maxFreq;

            }

            //valid window
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}