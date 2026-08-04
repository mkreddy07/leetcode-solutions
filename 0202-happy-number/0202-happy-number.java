class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while(n!=1 && !seen.contains(n))
        {
            seen.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    int getNextNumber(int n)
    {
        int sum = 0;
        while(n>0)
        {
            int num = n%10;
            sum+=num*num;
            n/=10;
        }
        return sum;
    }

}