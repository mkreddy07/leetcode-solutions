class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0)
            return 0;

        int left = 0;
        String empStr="";
        HashSet<Character> hs = new HashSet<>();

            int maxLength = 0;

        for(int right=0; right<s.length(); right++)
        {
            char ch = s.charAt(right);
            while(hs.contains(ch))
            {
                char leftChar = s.charAt(left);
                hs.remove(leftChar);
                left++;
            }
            hs.add(ch);
             maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}