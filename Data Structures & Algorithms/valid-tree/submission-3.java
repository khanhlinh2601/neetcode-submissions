class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
             return false;
        }
        //Create list adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int vistedCount = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            vistedCount++;
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return n == vistedCount;
    }
}
