import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n][n];
        for(int i = 0; i < n; i++){
            maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(isHappy(i,m,maps)){
                cnt++;
            }
            if(isHappyY(i,m,maps)){
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    public static boolean isHappy(int x,int m,int[][] maps){
        int cnt = 1;
        int maxCnt = 1;
        int first = maps[0][x];
        for(int i = 1; i < maps.length; i++){
            if(maps[i][x] == first) {
                cnt++;
            }else{
                cnt=1;
            }
            maxCnt = Math.max(cnt,maxCnt);

            first = maps[i][x];

        }
        return maxCnt >= m;
    }

    public static boolean isHappyY(int y,int m,int[][] maps){
        int cnt = 1;
        int maxCnt = 1;
        int first = maps[y][0];
        for(int i = 1; i < maps.length; i++){
            if(maps[y][i] == first) {
                cnt++;

            }else{
                cnt=1;
            }
            maxCnt = Math.max(cnt,maxCnt);

            first = maps[y][i];

        }
        return maxCnt >= m;
    }
}