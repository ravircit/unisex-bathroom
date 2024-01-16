package closestpair;

import java.util.Arrays;

class ClosestPairDistance {
    public static void main(String[] args) {
        int[] array = {10, 2, 5, -9, 15, 111, 117};

        double closestDistance = findClosestPairDistance(array);

        System.out.println("Shortest distance between closest pair: " + closestDistance);
    }

    public static double findClosestPairDistance(int[] array) {
        int n = array.length;

        Arrays.sort(array);

        int minDistance = 99999;

        for (int i = 0; i < n - 1; i++) {
            int distance = Math.abs(array[i] - array[i + 1]);
            minDistance = Math.min(minDistance, distance);
        }

        return minDistance;
    }
}
