public class DFSArrayGraph {
    static boolean[] visit;
    static int[][] static_graph;
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };
        static_graph = graph;
        visit = new boolean[graph.length];
        dfs(0);
    }

    static void dfs(int start) {
        System.out.println(start);
        visit[start] = true;
        for (int i = 0; i < static_graph[start].length; i++) {
            if (!visit[i] && static_graph[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
