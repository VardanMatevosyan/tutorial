package com.practice.binary_search;

class KokoEatingBananas {

  public static void main(String[] args) {
    KokoEatingBananas solution = new KokoEatingBananas();
//    int speed = solution.minEatingSpeed(new int[]{30, 11}, 6);
//    int speed = solution.minEatingSpeed(new int[]{30,11,23,4,20}, 6);
//    int speed = solution.minEatingSpeed(new int[]{30,11,40,4,20,2,1,33}, 8);
//    int speed = solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
    int speed = solution.minEatingSpeed(new int[]{312884470}, 968709470);
    System.out.println(speed);
  }
  public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = Integer.MAX_VALUE;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int time = 0;

      for (int pile : piles) {
        if (pile <= mid) {
          time++;
        } else {
          time += (pile + mid - 1) / mid;
        }
      }

      if (time <= h) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }


    return left;
  }

}