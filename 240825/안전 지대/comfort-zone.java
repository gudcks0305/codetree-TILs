import java.util.*;
public class Main {
    static final int[] dy = {1,-1,0,0};
    static final int[] dx = {0,0,-1,1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maps = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int maxVal = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                maps[i][j] = sc.nextInt();
                maxVal = Math.max(maxVal,maps[i][j]);
            }
        }
        // dfs
        int minK = 101;
        int maxCnt = 1;
        for(int k = 1; k < maxVal; k++){
            int cnt = 0;

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m; j++){
                    if(!visited[i][j] && maps[i][j] > k){
                        visited[i][j] = true;
                        dfs(maps,visited,i,j,k);
                        cnt++;
                    }
                }
            
            }
            if(cnt > maxCnt){
                minK = k;        
            }
            maxCnt = Math.max(cnt,maxCnt);
            visited = new boolean[n][m];
        }
        System.out.println(minK + " " + maxCnt);
    }

    public static void dfs(int[][] maps, boolean[][] visited,int y ,int x,int k){
        for(int i = 0 ; i < 4 ; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY < 0|| nextY > maps.length - 1 || nextX < 0 || nextX > maps[y].length - 1){
                continue;
            }
            if(visited[nextY][nextX] || maps[nextY][nextX] <= k){
                continue;
            } 
            visited[nextY][nextX] = true;
            dfs(maps,visited,nextY,nextX,k);
        }
    }
}