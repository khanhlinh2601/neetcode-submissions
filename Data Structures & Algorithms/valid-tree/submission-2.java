class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
             return false;
        }
        List<List<Integer>> adjGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjGraph.get(edge[0]).add(edge[1]);
            adjGraph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int visitedCount = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visitedCount++;
            for (int neighbor : adjGraph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return n == visitedCount;
    }
}
