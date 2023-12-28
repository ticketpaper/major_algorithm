import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSListGraph {
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

        bfs(0);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            System.out.print(next + " ");
            for (int target : adjList.get(next)) {
                if (visit[target] != true) {
                    queue.add(target);
                    visit[target] = true;
                }
            }
        }
    }
    static void addEdge(int a, int b) {
//        a는 출발지 b는 도착지
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}
