import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] maps = new int[n][m];
        newMaps = new int[n][m];
        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j< m; j++){
                maps[i][j] = sc.nextInt();
                newMaps[i][j] = maps[i][j];
            }
        }
        // 바람 입력    
        List<int[]> winds = new ArrayList<>();
        for(int i = 0 ; i < q;i++){
            winds.add(new int[]{sc.nextInt() - 1,sc.nextInt() - 1,sc.nextInt() - 1,sc.nextInt() - 1});
        }
        for(int[] wind : winds){
            rotate(wind,maps);
        }
        for(int i = 0; i < n; i++){
            //System.out.println(Arrays.toString(maps[i]));
            for(int j = 0; j < m; j++){
                System.out.print(newMaps[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 현재 좌표의 상하 좌우의 합의 평균을 내서 리턴하는 함수
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,1,-1}; 
    static int[][] newMaps;

    public static void applyAvg(int y1, int x1, int[][] maps) {
        int cnt = 1;
        int sum = maps[y1][x1];

        for (int i = 0; i < 4; i++) {
            int nextY = y1 + dy[i];
            int nextX = x1 + dx[i];
            if (isRange(nextY, nextX, maps)) {
                cnt++;
                sum += maps[nextY][nextX];
            }
        }

        // 중앙 값을 newMaps에 저장
        newMaps[y1][x1] = sum / cnt;
    }
    // 범위 체크 
    private static boolean isRange(int y1,int x1 ,int[][] maps){
        if(y1 < 0 || y1 > maps.length - 1 || x1 < 0 || x1 > maps[y1].length - 1){
            return false;
        }
        return true;
    }


    // x1 y1 x2 y2 의 좌표를 받고 해당하는 가장자리 들이 right rotate 되도록 하는 함수 
    private static void rotate(int[] wind, int[][] maps) {
        // Y x y x 순 
        int y1 = wind[0];
        int x1 = wind[1];
        int y2 = wind[2];
        int x2 = wind[3];

        // 네 가장자리의 숫자들을 임시 저장한다. 
        int firstTemp = maps[y1][x1];
        int secondTemp = maps[y1][x2];
        int thirdTemp = maps[y2][x1];
        int fourthTemp = maps[y2][x2];

        // 상단 행의 값을 오른쪽으로 한 칸씩 이동
        for (int i = x2; i > x1; i--) {
            maps[y1][i] = maps[y1][i - 1];
        }

        // 하단 행의 값을 왼쪽으로 한 칸씩 이동
        for (int i = x1; i < x2; i++) {
            maps[y2][i] = maps[y2][i + 1];
        }

        // 오른쪽 열의 값을 아래로 한 칸씩 이동
        for (int i = y2; i > y1; i--) {
            maps[i][x2] = maps[i - 1][x2];
        }

        // 왼쪽 열의 값을 위로 한 칸씩 이동
        for (int i = y1; i < y2; i++) {
            maps[i][x1] = maps[i + 1][x1];
        }

        // 임시 저장된 값을 원래 위치에 할당
        maps[y1][x1 + 1] = firstTemp;
        maps[y2][x2 - 1] = fourthTemp;
        maps[y2 - 1][x1] = thirdTemp;
        maps[y1 + 1][x2] = secondTemp;


        for(int i = y1; i <= y2; i++){
            for(int j = x1; j <= x2; j++){
                applyAvg(i,j,maps);
            }
        }

    }


}