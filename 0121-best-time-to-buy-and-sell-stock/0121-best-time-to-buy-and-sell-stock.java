class Solution {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int maxProfit = 0;


        for(int i=1; i<prices.length; i++)
        {
            minValue = Math.min(minValue, prices[i]);
            int profit = prices[i]-minValue;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}