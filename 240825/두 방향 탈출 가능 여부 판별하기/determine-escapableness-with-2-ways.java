import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] maps = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maps[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;
        dfs(maps,visited,0,0);
        if(visited[n - 1][m - 1]){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
    static final int[] dy = {1,-1,0,0};
    static final int[] dx = {0,0,1,-1};
    public static final void dfs(int[][] maps , boolean[][] visited, int y , int x){
        //print(visited);
        for(int i = 0 ; i < 4 ; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY < 0|| nextY > maps.length - 1 || nextX < 0 || nextX > maps[y].length - 1){
                continue;
            }
            if(visited[nextY][nextX] || maps[nextY][nextX] == 0) continue;
            visited[nextY][nextX] = true;
            dfs(maps,visited,nextY,nextX);
        }
    }
    static void print(boolean[][] visited){
        System.out.println();
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[i].length; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}