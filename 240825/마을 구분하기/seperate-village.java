import java.util.*;
public class Main {
    static final int[] dy = {1,-1,0,0};
    static final int[] dx = {0,0,-1,1};
    static List<Integer> list = new ArrayList<>();
    static Integer cnt = 1;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maps = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                maps[i][j] = sc.nextInt();
            }
        }
        // dfs 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                if(!visited[i][j] && maps[i][j] != 0){
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(maps,visited,i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        list.forEach(it -> System.out.println(it));
    }

    public static void dfs(int[][] maps, boolean[][] visited,int y ,int x){
        for(int i = 0 ; i < 4 ; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY < 0|| nextY > maps.length - 1 || nextX < 0 || nextX > maps[y].length - 1){
                continue;
            }
            if(visited[nextY][nextX] || maps[nextY][nextX] == 0){
                continue;
            } 
            visited[nextY][nextX] = true;
            cnt++;
            dfs(maps,visited,nextY,nextX);
        }
    }
}