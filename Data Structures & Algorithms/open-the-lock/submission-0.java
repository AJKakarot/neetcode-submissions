


class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        if (dead.contains("0000")) {
            return -1;
        }

        q.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                String current = q.poll();

                if (current.equals(target)) {
                    return turns;
                }

                for (int i = 0; i < 4; i++) {
                    char[] arr = current.toCharArray();

                    // Turn this wheel forward
                    arr[i] = (char) ('0' +
                            (arr[i] - '0' + 1) % 10);
                    String next = new String(arr);

                    if (!dead.contains(next) &&
                        visited.add(next)) {
                        q.offer(next);
                    }

                    // Turn this wheel backward
                    arr[i] = (char) ('0' +
                            (arr[i] - '0' + 8) % 10);
                    next = new String(arr);

                    if (!dead.contains(next) &&
                        visited.add(next)) {
                        q.offer(next);
                    }
                }
            }

            turns++;
        }

        return -1;
    }
}
