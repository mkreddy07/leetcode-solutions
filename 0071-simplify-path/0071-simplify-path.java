class Solution 
{     
    public String simplifyPath(String path) 
    {
        Deque<String> result = new ArrayDeque<>();
        String parts[] = path.split("/");

       for(String part: parts)
       {
          if(part.equals("") || part.equals("."))
          {
            continue;
          }
          if(part.equals(".."))
          {
            if(!result.isEmpty())
            {
                result.pop();
            } 
          }
          else
          {
            result.push(part);
          }
       }

       StringBuilder sb = new StringBuilder();

        while(!result.isEmpty())
        {
            sb.append("/").append(result.removeLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }     
}