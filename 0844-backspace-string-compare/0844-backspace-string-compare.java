class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        StringBuilder sb = new StringBuilder();
    for(int i=0;i<s.length();i++)
    {
        char ch = s.charAt(i);
        if(ch == '#')
        {
            if(sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
        }
         else
                sb.append(ch);
    }

    StringBuilder sb1 = new StringBuilder();

    for(int i=0;i<t.length();i++)
    {
        char ch = t.charAt(i);
        if(ch == '#')
        {
            if(sb1.length()>0)
                sb1.deleteCharAt(sb1.length()-1);
        }
         else
                sb1.append(ch);
    }

    if(sb.compareTo(sb1)==0)
        return true;
    else
        return false;
}
}