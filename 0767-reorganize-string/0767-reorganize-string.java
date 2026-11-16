class Solution 
{
    public String reorganizeString(String s) 
    {
    //     int freq[] = new int[26];

    //     for(char ch : s.toCharArray())
    //     {

    //         freq[ch - 'a']++;
    //     }

    //     StringBuilder sb = new StringBuilder();

    //     if(reArrange(freq, sb, s.length())){
    //         return sb.toString();
    //     }
    //     return "";
    // }

    // public boolean reArrange(int freq[], StringBuilder sb, int n)
    // {
    //     if(sb.length() == n)
    //     {
    //         return true;
    //     }

    //     for(int i=0; i<26; i++)
    //     {
    //         if(freq[i] == 0)
    //         {
    //             continue;
    //         }
    //           char ch = (char)(i+'a');

    //           //avoid to add same char in consecutively
    //         if(sb.length()>0 && sb.charAt(sb.length()-1) == ch)
    //         {
    //             continue;
    //         }
    //         sb.append(ch);
    //         freq[i]--;

    //         //explore
    //         if(reArrange(freq, sb, n))
    //             return true;
            

    //         //back tracking;
    //         sb.deleteCharAt(sb.length() - 1);
    //         freq[i]++;

    //     }
    //     return false;

    // }



//creating MaxHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0]));

        int freq[] = new int[26];

        for(char ch : s.toCharArray())
        {

            freq[ch - 'a']++;
        }


        for(int i=0; i<26; i++)
        {
            if(freq[i]>0)
            pq.add(new int[]{freq[i], i+'a'});
        }

        //storing result;
        StringBuilder sb = new StringBuilder();

        int[] prev = null;

        while(!pq.isEmpty())
        {
            int []current = pq.poll();

            char ch = (char)current[1];

            sb.append(ch);
            current[0]--;

        if(prev!=null && prev[0]>0)
        {
            pq.add(prev);
        }
        prev = current;

        }

    return sb.length() == s.length()? sb.toString() : "";

    }
}