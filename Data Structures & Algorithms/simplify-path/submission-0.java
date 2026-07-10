class Solution {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        // Split by "/"
        String[] folders = path.split("/");

        for (String folder : folders) {

            // Ignore empty and current directory
            if (folder.equals("") || folder.equals(".")) {
                continue;
            }

            // Go back one directory
            if (folder.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            }
            // Normal folder
            else {
                stack.push(folder);
            }
        }

        // Root path
        if (stack.isEmpty()) {
            return "/";
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (String folder : stack) {
            ans.append("/").append(folder);
        }

        return ans.toString();
    }
}