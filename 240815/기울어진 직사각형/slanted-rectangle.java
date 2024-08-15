import java.util.*;
import java.io.*;
public class Main {
    private static int[] dx = {-1,-1,1,1};
    private static int[] dy = {1,-1,-1,1};
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] maps = new int[n][n];
        for(int i = 0 ; i < n; i ++){
            maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
          //  System.out.println(Arrays.toString(maps[i]));
        }
        // 끝까지 갔는지 체크
        int result = 0;

        for(int i = 0;  i < n; i++){
            for(int j = 0 ; j < n; j++){
                for(int w = 1; w < n; w++){
                    for(int h = 1; h < n; h++){
                        result = Math.max(result,getScore(i,j,w,h,maps));
                    }
                }               
            }
        }
        System.out.println(result);
    }

    private static int getScore(int y,int x,int w,int h,int[][] maps){
        int[] moveNums = new int[]{h,w,h,w};
        int score = 0;
        for(int d = 0; d < 4; d++){
            for(int m = 0; m < moveNums[d]; m++){
                // 방향 가는 대로 값을 추가 하기 
                y += dy[d];
                x += dx[d];

                // y x 가 범위를 벗어나는지 체크 
                // 범위를 벗어나는 경우면 내가원하는 만큼 이동이 안된다는 버려버리기  
                if (y >= maps[0].length || y < 0 || x < 0 || x >= maps.length) {
                    return 0;
                }
                try{
                    score += maps[y][x];
                }catch(Exception e){
                    throw new RuntimeException(y + " " + x + " " + e);
                }
            }
        }
        return score;
    }
}