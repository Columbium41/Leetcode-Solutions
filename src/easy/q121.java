package easy;

public class q121 {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int bestProfit = 0;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    if (prices[i] - min > bestProfit) {
                        bestProfit = prices[i] - min;
                    }
                }
            }

            return bestProfit;
        }
}
