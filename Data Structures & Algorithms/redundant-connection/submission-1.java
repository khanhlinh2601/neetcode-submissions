class Solution {
    public static int[] findRedundantConnection(int[][] edges) {
        //1 -> n
        int n = edges.length;
        //create adj graph
        List<List<Integer>> adjGraph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjGraph.add(new ArrayList<>());
        }
        for (int[] node: edges) {
            int u = node[0];
            int v = node[1];
            //Check has any path between u and v using BFS
            if (hasPath(adjGraph, u, v, n)) {
               return node;
            }
             adjGraph.get(u).add(v);
                adjGraph.get(v).add(u);
        }
        return new int[0];
        
    }

    private static boolean hasPath(List<List<Integer>> graph, int u, int v, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == v) {
                return true;
            }
            for (int neighbor: graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
