
class Solution 
{
    public int totalFruit(int[] fruits) 
    {
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxFruits = 0;

        for(int right=0; right<fruits.length; right++)
        {
            hm.put(fruits[right], hm.getOrDefault(fruits[right],0)+1);

            while(hm.size()>2)
            {
                int fruitCount = hm.get(fruits[left]);                
                if(fruitCount == 1)
                    hm.remove(fruits[left]);
                else
                    hm.put(fruits[left], hm.get(fruits[left])-1);

                left++;
            }
            maxFruits = Math.max(maxFruits, right-left+1);
        }
        return maxFruits;
    }
}




