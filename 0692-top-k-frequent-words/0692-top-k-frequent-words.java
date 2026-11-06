class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word : words)
        {
            hm.put(word, hm.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> 
        {
            if(!hm.get(a).equals(hm.get(b)))
            {
                return Integer.compare(hm.get(b), hm.get(a));
            }
            return a.compareTo(b);
        });
       

        String result[] = new String[k];

        for(String word: hm.keySet())
        {
            pq.add(word);
        }

        for(int i=0; i<k; i++)
        {
            result[i] = pq.poll();
        }
        return Arrays.asList(result);
    }
}