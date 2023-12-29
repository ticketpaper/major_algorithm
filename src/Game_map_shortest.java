import java.util.*;

public class Game_map_shortest {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int m = maps.length;
        int n = maps[0].length;

        visited = new boolean[m*n];
        adjList = new ArrayList<>();
        distance = new int[m*n];
        for(int i=0; i<m*n; i++){
            adjList.add(new ArrayList<>());
        }
        Arrays.fill(distance, 1);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++ ){
                if(maps[i][j]==0) continue;
                int[]dx = {-1,1,0,0};
                int[]dy = {0,0,-1,1};
                for(int d=0; d<4; d++){
                    int target_i = i+dx[d];
                    int target_j = j+dy[d];
                    if(target_i>=0 && target_i<m && target_j>=0 && target_j<n && maps[target_i][target_j]==1){
                        addEdge((i)*n + j, (target_i)*n+target_j);
                    }
                }
            }
        }
        System.out.println(bfs(0, m*n-1));
    }

    static int bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int next = queue.poll(); //방문
            for(int taget : adjList.get(next)){
                if(visited[taget] != true){
                    queue.add(taget); //방문예정인 데이터를 큐에 담는것.
                    distance[taget] = distance[next] + 1;
                    visited[taget] = true;
                    if(taget==end){
                        return distance[end];
                    }
                }
            }
        }
        return -1;
    }
    static void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}



