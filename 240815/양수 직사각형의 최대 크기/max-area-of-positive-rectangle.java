import java.util.*;
import java.io.*;
public class Main {
    static int MAXL = 20;
    static int[][] maps = new int[MAXL][MAXL];
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        for(int i = 0; i < n; i++){
            maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int h = 1; h < n - i; h++){
                    for(int w = 1; w < m - j; w++){
                        if(isPositiveSquare(j,i,j+w,i+h)){
                            int wh = (w + 1) * (h + 1);
                            max = Math.max(max,wh);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isPositiveSquare(int x1,int y1,int x2,int y2){
        for(int i = y1; i <= y2; i++){
            for(int j = x1; j <= x2; j++){
                if(maps[i][j] < 0) return false;
            }
        }
        return true;
    }
}