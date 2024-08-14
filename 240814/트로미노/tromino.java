import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] board;
 static int[][][] blocks = {
        // 3칸짜리 블록의 모든 회전 및 대칭 형태
        {{1, 1, 1}},            // 일자 블록 (가로)
        {{1}, {1}, {1}},        // 일자 블록 (세로)
        {{1, 0}, {1, 1}},       // ㄱ자 블록 (기본)
        {{1, 1}, {1, 0}},       // ㄱ자 블록 (회전 90도)
        {{1, 1}, {0, 1}},       // ㄴ자 블록 (기본)
        {{0, 1}, {1, 1}}        // ㄴ자 블록 (회전 90도)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        board = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        
        int maxSum = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[][] block : blocks) {
                    maxSum = Math.max(maxSum, calculateBlockSum(i, j, block));
                }
            }
        }
        
        System.out.println(maxSum);
    }

    public static int calculateBlockSum(int x, int y, int[][] block) {
        int sum = 0;
        int blockRows = block.length;
        int blockCols = block[0].length;
        
        if (x + blockRows > n || y + blockCols > m) {
            return 0; // 블록이 배열 밖으로 나가는 경우
        }
        
        for (int i = 0; i < blockRows; i++) {
            for (int j = 0; j < blockCols; j++) {
                if (block[i][j] == 1) {
                    sum += board[x + i][y + j];
                }
            }
        }
        
        return sum;
    }
}