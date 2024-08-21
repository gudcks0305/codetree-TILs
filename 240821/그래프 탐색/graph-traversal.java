import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;
    public static int n, m;

    // index를 1번 부터 사용하기 위해 MAX_NUM+1만큼 할당합니다.
    public static int[][] graph = new int[MAX_NUM + 1][MAX_NUM + 1];
    public static boolean[] visited = new boolean[MAX_NUM + 1];
    public static int vertexCnt = 0;

    public static void DFS(int vertex) {
        // 해당 정점에서 이어져있는 모든 정점을 탐색해줍니다.
        for(int currV = 1; currV <= n; currV++) {
            // 아직 간선이 존재하고 방문한 적이 없는 정점에 대해서만 탐색을 진행합니다.
            if(graph[vertex][currV] == 1 && !visited[currV]) {
                visited[currV] = true;
                vertexCnt++;
                DFS(currV);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        while(m-- > 0) {
            // 각 정점이 서로 이동이 가능한 양방향 그래프이기 때문에
            // 각 정점에 대한 간선을 각각 저장해줍니다.
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
       
        visited[1] = true;
        DFS(1);

        System.out.println(vertexCnt);
    }
}