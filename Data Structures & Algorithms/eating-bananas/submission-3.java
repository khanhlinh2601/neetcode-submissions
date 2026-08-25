class Solution {
     public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int result = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canFinish(int[] piles, int h, int k) {
        int total = 0;
        for (int i = 0; i < piles.length ; i++) {
             total += (piles[i] - 1) / k + 1; // Equivalent to ceil(pile / k)
            if (total > h) return false; // Early exit optimization

        }
        return total <= h;
    }
}
