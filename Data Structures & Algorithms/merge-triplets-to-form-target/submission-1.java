class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false;
        boolean b = false;
        boolean c = false;

        for (int[] t : triplets) {
            // Ignore triplets having any value greater than target
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            // This triplet can contribute to target
            if (t[0] == target[0]) {
                a = true;
            }

            if (t[1] == target[1]) {
                b = true;
            }

            if (t[2] == target[2]) {
                c = true;
            }
        }

        return a && b && c;
    }
}