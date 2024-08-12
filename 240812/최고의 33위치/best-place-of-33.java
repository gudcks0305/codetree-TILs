import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] maps = new int[n][n];
        for(int i = 0; i < n; i++){
            maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int max = 0;
        for(int i = 0; i < n -2; i++){
            for(int j = 0; j < n -2; j++){
                int result = searchCoin(i, j,maps);
                max = Math.max(result,max);
            }
        }
        System.out.println(max);
    }
    public static int searchCoin(int x, int y,int[][] maps){
        if(!validateMapsLength(x,y,maps)){
            return 0;
        }
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!validateMapsLength(x + i, y + j,maps)){
                    continue;
                }
                if(maps[x+i][y+j] == 1) cnt++;
            }
        }
        return cnt;
    }

    private static boolean validateMapsLength(int x, int y , int[][] maps){
        if(x < 0 || x > maps.length || y < 0 || y > maps.length){
            return false;
        }
        return true;
    }

}