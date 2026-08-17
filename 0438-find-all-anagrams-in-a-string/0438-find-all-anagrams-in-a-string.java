class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        if(p.length()>s.length())
            return new ArrayList<>();

        int windowLength = p.length();

        int Pfreq[] = new int[26];

        int windFreq[] = new int[26];

        List<Integer> result = new ArrayList<>();
        int left = 0;
      

        for(int i=0; i<p.length(); i++)
            Pfreq[p.charAt(i)-'a']++;

        int windowSize = p.length();

        for(int i=0;i<windowSize; i++)
            windFreq[s.charAt(i)-'a']++;
        
        if(matches(Pfreq, windFreq)){
           result.add(0);
        }

        for(int right=windowSize; right<s.length(); right++)
        {

            windFreq[s.charAt(right)-'a']++;
            windFreq[s.charAt(left)-'a']--;
            left++;

            if(matches(Pfreq, windFreq)){
                result.add(left);
            }
        }
        return result;
        
    }
    public boolean matches(int pFreq[], int windFreq[])
    {
        for(int i=0; i<26; i++)
        {
            if(pFreq[i]!=windFreq[i])
                return false;
        }
        return true;
    }
}