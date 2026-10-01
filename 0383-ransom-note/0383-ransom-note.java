class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomFreq = new HashMap<>();
        HashMap<Character, Integer> magazineFreq = new HashMap<>();

        for(char ch: ransomNote.toCharArray())
        {
            ransomFreq.put(ch, ransomFreq.getOrDefault(ch, 0)+1);
        }

        for(char ch: magazine.toCharArray())
        {
            magazineFreq.put(ch, magazineFreq.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<ransomNote.length(); i++)
        {
            char ch = ransomNote.charAt(i);
            if(ransomFreq.get(ch) > magazineFreq.getOrDefault(ch,0))
            {
                return false;
            }
        }
        return true;
    }
}