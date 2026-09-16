class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> result = new ArrayDeque();

        for(char ch: s.toCharArray())
        {
            if(!result.isEmpty()&&ch==result.peek())
            {
                char top = result.pop();
            }
            else
            {
                result.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!result.isEmpty())
        {
            ans.append(result.pop());
        }
        return ans.reverse().toString();
    }
}