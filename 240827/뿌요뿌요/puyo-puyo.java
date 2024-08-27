import java.util.*;
public class Main {
    static int max = 0;
    static int cnt = 0;
    static int value = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maps = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                maps[i][j] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                if(!visited[i][j]){
                    cnt = 0;
                    dfs(maps,visited,i,j);
                    if(cnt >= 4){
                    max = Math.max(max,cnt);
                        value = maps[i][j];
                    }
                    
                }
            }
        }
        System.out.println(value + " " + max);
    }
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    public static void dfs(int[][] maps,boolean[][] visited,int y , int x){
        for(int i = 0; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY < 0 || nextY > maps.length - 1 || nextX < 0 || nextX > maps.length - 1){
                continue;
            }
            if(visited[nextY][nextX]){
                continue;
            }
            if(maps[y][x] != maps[nextY][nextX]) continue;
            visited[nextY][nextX] = true;
            cnt++;
            dfs(maps,visited,nextY,nextX);
        }
    }
}