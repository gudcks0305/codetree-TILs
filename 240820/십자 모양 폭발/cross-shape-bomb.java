import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maps = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                maps[i][j] = sc.nextInt();
            }
        }
        int y1 = sc.nextInt() - 1;
        int x1 = sc.nextInt() - 1;
        simulate(maps,y1,x1);
        print(maps,n);
    }

    public static void simulate(int[][] maps, int y1, int x1){
        boom(maps,y1,x1);
        fall(maps);
    }
    public static int[] dy = {0,1,-1,0,0};
    public static int[] dx = {0,0,0,1,-1};

    public static void boom(int[][] maps, int y1,int x1){
        int value = maps[y1][x1];
        int length = maps.length - 1;
        for(int i = 0; i < 5; i++){
            int nextY = y1;
            int nextX = x1;
            for(int j = 1; j < value; j++){
                nextY += dy[i];
                nextX += dx[i];
                if(nextY < 0 || nextY > length || nextX < 0 || nextX > length) break;
                maps[nextY][nextX] = 0;
            }
        }
    }

    // draw 
    public static void fall(int[][] maps){
        int length = maps.length - 1;
        for(int i = length; i > 0; i--){
            for(int j = length; j > 0; j--){
                if(maps[j][i] == 0){
                    for(int k = j; k >0; k--){
                        maps[k][i] = maps[k-1][i];
                    }
                    maps[0][i] = 0;
                }
            }
        }

     
    }

    public static void print(int[][] maps, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }    
    }
}