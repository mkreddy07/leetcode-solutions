class Solution {
    public int compress(char[] chars) 
    {
        int read = 0;
        int write = 0;

        while(read<chars.length)
        {
            int count = 0;
            char currentCharacter = chars[read];

            //checking consecutive characters
            while(read<chars.length && chars[read]==currentCharacter)
            {
                read++;
                count++;
            }
            chars[write] = currentCharacter;
            write++;

            if(count>1)
            {
            String num = String.valueOf(count);

            for(char ch: num.toCharArray())
            {
                chars[write] = ch;
                write++;
            }
            }
        }
            return write;
    }
}