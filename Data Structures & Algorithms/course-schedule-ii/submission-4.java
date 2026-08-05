class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> daGraph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            daGraph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            daGraph.get(course).add(pre);
        }
        
        int[] state = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, daGraph, state, order)) {
                    return new int[0];
                }
            }
        }
        return order.stream().mapToInt(i -> i).toArray();
    }
    private static boolean dfs(int course, List<List<Integer>> daGraph, int[] state, List<Integer> order) {
        if (state[course] == 1) {
            return false; 
        }
        if (state[course] == 2) {
            return true; 
        }
        state[course] = 1; 
        for (int nextCourse : daGraph.get(course)) {
            if (!dfs(nextCourse, daGraph, state, order)) {
                return false;
            }
        }
        state[course] = 2;
        order.add(course);
        return true;
    }
}
