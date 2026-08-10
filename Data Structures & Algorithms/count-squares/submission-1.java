class CountSquares {
    // Store frequency of every point
    // x -> (y -> frequency)
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        // If x is not present, create a new HashMap
        map.putIfAbsent(x, new HashMap<>());

        // Increase frequency of this point
        HashMap<Integer, Integer> yMap = map.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int ans = 0;

        // Try every x-coordinate that we have stored
        for (int x2 : map.keySet()) {
            // Distance between query point and another x-coordinate
            int d = x2 - x;

            // Same x-coordinate cannot form a square
            if (d == 0) {
                continue;
            }

            // Frequency of the point (x2, y)
            int horizontal = map.get(x2).getOrDefault(y, 0);

            // If (x2, y) doesn't exist,
            // no square can be formed with this x2
            if (horizontal == 0) {
                continue;
            }

            // -------------------------------
            // Case 1: Square goes UP
            // -------------------------------

            int upperY = y + d;

            int p1 = map.get(x).getOrDefault(upperY, 0);
            int p2 = map.get(x2).getOrDefault(upperY, 0);

            // -------------------------------
            // Case 2: Square goes DOWN
            // -------------------------------

            int lowerY = y - d;

            int p3 = map.get(x).getOrDefault(lowerY, 0);
            int p4 = map.get(x2).getOrDefault(lowerY, 0);

            // Multiply frequencies because
            // duplicate points create multiple squares
            ans += horizontal * p1 * p2;
            ans += horizontal * p3 * p4;
        }

        return ans;
    }
}