class Solution {
    public String removeDuplicates(String s, int k) 
    {
       Deque<int[]> stack = new ArrayDeque<>();

      for(char ch: s.toCharArray())
      {
        if(!stack.isEmpty() && stack.peek()[0] == ch)
        {
            stack.peek()[1]++;
            if(stack.peek()[1] == k)
            {
                stack.pop();
            }
        }
        else
        {
            stack.push(new int[]{ch, 1});
        }
      }
      StringBuilder sb = new StringBuilder();

      while(!stack.isEmpty())
      {
        int current[] = stack.pop();

        for(int i=0; i<current[1];i++)
        {
            sb.append((char)current[0]);
        }
        
      }
      return sb.reverse().toString();
    }
}