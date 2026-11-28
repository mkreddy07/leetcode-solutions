class Solution {
    int a = 0;
    int b = 1;
    public int fib(int n) 
    {
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else
          return getFibonacciNumber(a, b, n);
    }

    public int getFibonacciNumber(int a, int b, int n)
    {
        int c = 0;
        
        for(int i=1; i<n; i++){
            c = a+b;
            a =b;
            b = c;
        }
        return c;
    }

}