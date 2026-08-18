class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;

        int totalLength = wordLength * wordCount;

        if (totalLength > s.length()) {
            return result;
        }

        // Required words
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Try different starting offsets
        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int count = 0;

            HashMap<String, Integer> windowMap = new HashMap<>();

            for (int right = offset;
                 right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                // Word is required
                if (wordMap.containsKey(word)) {

                    windowMap.put(
                        word,
                        windowMap.getOrDefault(word, 0) + 1
                    );

                    count++;

                    // Too many copies of this word
                    while (windowMap.get(word) > wordMap.get(word)) {

                        String leftWord =
                            s.substring(left, left + wordLength);

                        windowMap.put(
                            leftWord,
                            windowMap.get(leftWord) - 1
                        );

                        left += wordLength;
                        count--;
                    }

                    // Found all words
                    if (count == wordCount) {

                        result.add(left);

                        // Move left to look for next answer
                        String leftWord =
                            s.substring(left, left + wordLength);

                        windowMap.put(
                            leftWord,
                            windowMap.get(leftWord) - 1
                        );

                        left += wordLength;
                        count--;
                    }

                } else {

                    // Word doesn't exist in words
                    windowMap.clear();

                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}