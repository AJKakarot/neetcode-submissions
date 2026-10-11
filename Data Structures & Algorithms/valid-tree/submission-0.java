


class Solution {
    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if (hasCycle(0, -1, adj, visited)) {
            return false;
        }

        // Check whether every node is connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
        int node,
        int parent,
        List<List<Integer>> adj,
        boolean[] visited
    ) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (neighbor == parent) {
                continue;
            }

            if (visited[neighbor]) {
                return true;
            }

            if (hasCycle(neighbor, node, adj, visited)) {
                return true;
            }
        }

        return false;
    }
}
