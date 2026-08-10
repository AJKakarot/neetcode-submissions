class DetectSquares {
    // Store frequency of every point
    // key = x coordinate
    // value = map of y coordinate -> frequency
    private Map<Integer, Map<Integer, Integer>> points;

    public DetectSquares() {
        points = new HashMap<>();
    }

    // Add a point
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        // Create map for x if it doesn't exist
        points.putIfAbsent(x, new HashMap<>());

        // Increase frequency of (x, y)
        Map<Integer, Integer> yMap = points.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    // Count squares using query point
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int ans = 0;

        // Try every x-coordinate that has been added
        for (int x2 : points.keySet()) {
            // Difference between query point and another x
            int d = x2 - x;

            // d = 0 means no width
            // so a square cannot be formed
            if (d == 0) {
                continue;
            }

            // We need same vertical distance d
            // from (x,y)
            int y1 = y + d;
            int y2 = y - d;

            // Frequency of the horizontal point
            int horizontalCount = points.get(x2).getOrDefault(y, 0);

            if (horizontalCount == 0) {
                continue;
            }

            // Case 1:
            // (x2,y), (x,y+d), (x2,y+d)
            int topCount = getFrequency(x, y1) * getFrequency(x2, y1);

            // Case 2:
            // (x2,y), (x,y-d), (x2,y-d)
            int bottomCount = getFrequency(x, y2) * getFrequency(x2, y2);

            // Multiply by frequency of horizontal point
            ans += horizontalCount * (topCount + bottomCount);
        }

        return ans;
    }

    // Return frequency of a particular point
    private int getFrequency(int x, int y) {
        if (!points.containsKey(x)) {
            return 0;
        }

        return points.get(x).getOrDefault(y, 0);
    }
}