import java.util.ArrayList;
import java.util.List;

public class Network {
    static int[][] computers;
    static boolean[] visit;
    public static void main(String[] args) {
        computers = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;
        visit = new boolean[n];
        int answer = 0;


        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int i = 0; i < computers[start].length; i++) {
            if (!visit[i] && computers[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
