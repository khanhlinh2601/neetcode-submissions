class Solution {
    public static int carFleet(int target, int[] position, int[] speed) {
        double[][] pairs = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(pairs, (a, b) -> Double.compare(b[0], a[0]));
        int carFleet = 0;
        double currentBlockingTime = 0.0;

        for (double[] pair : pairs) {
            if (pair[1] > currentBlockingTime) {
                carFleet++;
                currentBlockingTime = pair[1];
            }
        }
        return carFleet;
    }
}
