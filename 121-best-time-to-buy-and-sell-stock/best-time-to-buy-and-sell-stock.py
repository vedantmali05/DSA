class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 1: return 0
        
        l, r = 0, 1
        maxP = 0

        while (r < len(prices)):
            if (prices[r] > prices[l]):
                profit = prices[r] - prices[l]
                maxP = max(maxP, profit)
            else:
                l = r
            r += 1
        return maxP