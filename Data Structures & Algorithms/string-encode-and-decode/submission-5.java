

class Solution {

    // Encode List<String> -> String
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {

            // length + '#' + string
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    // Decode String -> List<String>
    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get length
            int len = Integer.parseInt(str.substring(i, j));

            // Get original string
            String word = str.substring(j + 1, j + 1 + len);

            ans.add(word);

            // Move to next encoded string
            i = j + 1 + len;
        }

        return ans;
    }
}