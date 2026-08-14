class Solution {
    public int longestKSubstr(String s, int k) {
        
        // code here
       HashMap<Character, Integer> hm = new HashMap<>();
       int left = 0;
       
       int maxLength = -1;
       
       for(int right=0; right<s.length(); right++)
       {
           char ch = s.charAt(right);
           
           hm.put(ch, hm.getOrDefault(ch, 0)+1);
           
           while(hm.size()>k)
           {
                char leftChar = s.charAt(left);
                hm.put(leftChar, hm.get(leftChar)-1);
                
                if(hm.get(leftChar) == 0)
                    hm.remove(leftChar);
                    
                left++;
           }
           
           if(hm.size() == k)
                maxLength = Math.max(maxLength, right-left+1);
       }
       return maxLength;
    }
}