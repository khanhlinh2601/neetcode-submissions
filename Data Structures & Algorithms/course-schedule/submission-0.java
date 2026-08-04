class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //Create a graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //Create a indegree array
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[1];
            int pre = prerequisite[0];
            indegree[course]++;
            graph.get(pre).add(course);
        }
        //Create a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i); //0
            }
        }
        //BFS
        int learnedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
                        learnedCourses++;

            for (int next: graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return learnedCourses == numCourses;
    }
}
