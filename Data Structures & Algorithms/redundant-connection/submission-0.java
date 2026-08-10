class Solution {
        public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        // 1. SỬA LỖI 1: Khởi tạo n + 1 danh sách kề (đỉnh từ 1 đến n)
        List<List<Integer>> adjGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjGraph.add(new ArrayList<>());
        }

        // 2. SỬA LỖI 3: Duyệt TỪNG cạnh một trong edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Kiểm tra xem trước khi thêm cạnh [u, v] thì giữa u và v ĐÃ CÓ ĐƯỜNG ĐI CHƯA
            if (hasPathBFS(adjGraph, u, v, n)) {
                return edge; // Nếu đã có đường đi -> cạnh [u, v] này là cạnh thừa!
            }

            // SỬA LỖI 2: Thêm cạnh VÔ HƯỚNG (cả 2 chiều) vào đồ thị
            adjGraph.get(u).add(v);
            adjGraph.get(v).add(u);
        }

        return new int[0];
    }

    // Hàm BFS kiểm tra tồn tại đường đi giữa source và target
    private static boolean hasPathBFS(List<List<Integer>> adjGraph, int source, int target, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == target) {
                return true; // Đã tìm thấy đường đi từ source đến target
            }

            for (int neighbor : adjGraph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
