class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Alien alphabet ka rank store karenge
        int[] rank = new int[26];

        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Har adjacent pair ko compare karo
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int j = 0;

            // Jab tak characters same hain, aage badho
            while (j < w1.length() && j < w2.length()) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    // Alien order check
                    if (rank[w1.charAt(j) - 'a'] > rank[w2.charAt(j) - 'a']) {
                        return false;
                    }

                    // Different character mil gaya,
                    // ab further compare karne ki zarurat nahi
                    break;
                }

                j++;
            }

            // Prefix case
            // Example: "neetcode" > "neet" => false
            if (j == w2.length() && w1.length() > w2.length()) {
                return false;
            }
        }

        return true;
    }
}
