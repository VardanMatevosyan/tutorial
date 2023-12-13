package com.practice.sliding_window;

/**
 * Best Time to Buy And Sell Stock
 */
class BestTimeToBuyAndSellStock {

  public static void main(String[] args) {
    BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
//    int i = solution.maxProfit(new int[]{2,1,2,1,0,1,2}); // expected = 2
//    int i = solution.maxProfit(new int[]{2,4,1}); // expected = 2
    int i = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // expected = 5;
    System.out.println("i = " + i);
  }


  // good sliding window or two pointer approach O(n) and memory O(1)
  public int maxProfit(int[] prices) {
//    int buyPrise = 0;
    int maxProfit = 0;
    int l = 0;
    int r = 1;

    while (r < prices.length) {
      if (prices[l] < prices[r]) {
        int dayProfit = prices[r] - prices[l];
        if (maxProfit < dayProfit) {
          maxProfit = dayProfit;
        }
      } else {
        l = r;
      }
      r++;
    }


    // bad brute force approach O(n^2)

//    for (int i = 0; i < prices.length; i++) {
//      buyPrise = prices[i];
//
//      int dayProfit = prices[i] - buyPrise;
//      for (int j = i + 1; j < prices.length; j++) {
//        int tempProfit = prices[j] - buyPrise;
//        if (dayProfit < tempProfit) {
//          dayProfit = tempProfit;
//        }
//      }
//
//      if (profit < dayProfit) {
//        profit = dayProfit;
//      }
//    }
    return maxProfit;
  }
}