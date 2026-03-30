// 121. Best Time to Buy and Sell Stock
public class n121_two_pointer {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int min = prices[0];
        int max = prices[1] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            max = Math.max(max, profit);
            min = Math.min(min, prices[i]);
        }

        System.out.println(max);
    }
}


// class Solution {
//     public int maxProfit(int[] prices) {

//         int minPrice = prices[0];
//         int maxProfit = 0;

//         for (int i = 1; i < prices.length; i++) {

//             int profit = prices[i] - minPrice;
//             maxProfit = Math.max(maxProfit, profit);

//             minPrice = Math.min(minPrice, prices[i]);
//         }

//         return maxProfit;
//     }
// }