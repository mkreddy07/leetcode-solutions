class Solution {
    public int maxNumberOfBalloons(String text) {

        String word = "balloon";
        HashMap<Character, Integer> frequency = new HashMap<>();

        for(char ch : word.toCharArray())
        {
            frequency.put(ch, frequency.getOrDefault(ch, 0)+1);
        }

        HashMap<Character, Integer> inputFreq = new HashMap<>();
        
        for(char ch: text.toCharArray())
        {
            inputFreq.put(ch, inputFreq.getOrDefault(ch, 0)+1);
        }

        int answer = Integer.MAX_VALUE;

        for(char ch: frequency.keySet())
        {
            int required = frequency.get(ch);
            int available = inputFreq.getOrDefault(ch, 0);

            int possible = available/required;

             answer = Math.min(answer, possible);
        }

        return answer;

    }
}