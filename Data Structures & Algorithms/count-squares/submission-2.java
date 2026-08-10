class CountSquares {

    HashMap<Integer, HashMap<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        // Create inner map if x doesn't exist
        map.putIfAbsent(x, new HashMap<>());

        // Increase frequency of (x, y)
        HashMap<Integer, Integer> yMap = map.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    // Safely get frequency of (x, y)
    private int getFrequency(int x, int y) {

        // x doesn't exist
        if (!map.containsKey(x)) {
            return 0;
        }

        // x exists, now check y
        return map.get(x).getOrDefault(y, 0);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int ans = 0;

        // Try every possible x-coordinate
        for (int x2 : map.keySet()) {

            int d = x2 - x;

            // Same x cannot make a square
            if (d == 0) {
                continue;
            }

            // Point (x2, y)
            int horizontal = getFrequency(x2, y);

            if (horizontal == 0) {
                continue;
            }

            // =========================
            // Square ABOVE
            // =========================

            int upperY = y + d;

            int leftTop = getFrequency(x, upperY);
            int rightTop = getFrequency(x2, upperY);

            ans += horizontal * leftTop * rightTop;


            // Square BELOW
        

            int lowerY = y - d;

            int leftBottom = getFrequency(x, lowerY);
            int rightBottom = getFrequency(x2, lowerY);

            ans += horizontal * leftBottom * rightBottom;
        }

        return ans;
    }
}