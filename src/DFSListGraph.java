import java.util.ArrayList;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visit;

    public static void main(String[] args) {
        int[][] input = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int node_n = 5;
        visit = new boolean[node_n];
        adjList = new ArrayList<>();
        for (int i = 0; i < node_n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : input) {
            addEdge(ints[0], ints[1]);
        }
        System.out.println(adjList);
        dfs(0);
    }

    static void addEdge(int a, int b) {
//        a는 출발지 b는 도착지
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static void dfs(int start) {
        System.out.println(start);
        visit[start] = true;
        for (int target : adjList.get(start)) {
            if (!visit[target]) {
                dfs(target);
            }
        }
    }
}
