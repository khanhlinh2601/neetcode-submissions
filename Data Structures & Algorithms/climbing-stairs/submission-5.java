class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n + 1];
        for (int i = 1; i <= n; i++ ) {
            cache[i] = -1;
        }
        return flipTopdown(n);
    }

    public int flipTopdown(int i) {
        if (i <= 2) return i;
        if (cache[i] != -1) return cache[i];
        cache[i] = flipTopdown(i - 1) + flipTopdown (i - 2);
        return cache[i];
    }
    
}
