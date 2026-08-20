class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Total cards must be divisible into equal-sized groups
        if (hand.length % groupSize != 0) {
            return false;
        }

        // TreeMap stores cards in sorted order with their frequencies
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Store frequency of each card
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Keep creating groups until all cards are used
        while (!map.isEmpty()) {
            // The smallest card must be the start of a group
            int start = map.firstKey();

            // Try to create a consecutive group
            for (int i = 0; i < groupSize; i++) {
                int card = start + i;

                // Required consecutive card is missing
                if (!map.containsKey(card)) {
                    return false;
                }

                // Use one occurrence of the card
                int count = map.get(card);

                // Remove card if no occurrences are left
                if (count == 1) {
                    map.remove(card);
                } else {
                    map.put(card, count - 1);
                }
            }
        }

        // All cards were successfully grouped
        return true;
    }
}