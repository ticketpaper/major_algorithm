import java.util.*;

public class far_node {
    static List<List<Integer>> adjList;
    static boolean[] visit;
    static int[] distance;
    public static void main(String[] args) {
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n = 6;
        adjList = new ArrayList<>();
        visit = new boolean[n];
        distance = new int[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : edge) {
            addEdge(ints[0]-1, ints[1]-1);
        }
        bfs(0);
        System.out.println(adjList);
        System.out.println(Arrays.toString(distance));
        int max = distance[0];
        for (int i : distance) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);
        int answer =0;
        for (int i : distance) {
            if (i == max) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start]= true;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (Integer target : adjList.get(next)) {
                if (visit[target] != true) {
                    queue.add(target);
                    distance[target] = distance[next] + 1;
                    visit[target] = true; // true로 안하면 또 방문해버림
                }
            }
        }
    }
}
