import java.util.Scanner;

public class Main {

	static final int MAX_N = 100;
	static final int DIR_NUM = 4;

	static int n;
	static int r, c, m1, m2, m3, m4, dir;

	// 방향마다 이동해야할 횟수 {0, m1, m2, m3, m4}
	static int[] moveNum;

	static int[][] grid = new int[MAX_N][MAX_N];

	// rotate clock direction
	static void rotateClock() {

		int[] dx = {0, -1, -1, 1, 1};
		int[] dy = {0, 1, -1, -1, 1};

		int tmp = grid[r][c];
		int cx = r, cy = c; // currPos

		// 방향 1~4 순회하며 한 칸씩 로테이트
		for (int d = 1; d <= DIR_NUM; d++) {
			int numToMove = moveNum[d];

			for (int move = 0; move < numToMove; move++) {
				// copy Number
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				grid[cx][cy] = grid[nx][ny];

				// move currPos to next
				cx = nx;
				cy = ny;
			}
		}

		// use tmp near (r, c)
		grid[r - 1][c - 1] = tmp;
	}

	// rotate anti clock direction
	static void rotateAntiClock() {

		int[] dx = {0, 1, 1, -1, -1};
		int[] dy = {0, -1, 1, 1, -1};

		int tmp = grid[r][c];
		int cx = r, cy = c; // currPos

		// 방향 4~1 순회하며 한 칸씩 로테이트
		for (int d = DIR_NUM; d >= 1; d--) {
			int numToMove = moveNum[d];

			for (int move = 0; move < numToMove; move++) {
				// copy Number
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				grid[cx][cy] = grid[nx][ny];

				// move currPos to next
				cx = nx;
				cy = ny;
			}
		}

		// use tmp near (r, c)
		grid[r - 1][c + 1] = tmp;
	}

	// simulate
	static void simulate() {
		if (dir == 1) { // dir 1이면 시계 회전, 0이면 반시계 회전
			rotateClock();
			return;
		}
		rotateAntiClock();
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		r = sc.nextInt() - 1; // r행 c열 -> grid[r][c] 인덱스로 활용
		c = sc.nextInt() - 1;

		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
		m4 = sc.nextInt();
		moveNum = new int[]{0, m1, m2, m3, m4};

		dir = sc.nextInt();

		// rotate
		simulate();

		// 출력
		print(grid);
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}