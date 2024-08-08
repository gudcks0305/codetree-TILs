import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main {
   private static final int RECTANGLE_LENGTH = 10;
    private static final int GRID_SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine().trim());
        List<Pair<Integer, Integer>> rectanglesPointsXY = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            String[] xy = br.readLine().split(" ");
            rectanglesPointsXY.add(new Pair<>(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
        }

        boolean[][] grid = new boolean[GRID_SIZE][GRID_SIZE];
        for (Pair<Integer, Integer> rectangle : rectanglesPointsXY) {
            markGrid(grid, rectangle.x(), rectangle.y());
        }

        int result = countCoveredArea(grid);
        System.out.println(result);
    }

    private static void markGrid(boolean[][] grid, int x, int y) {
        for (int i = x; i < x + RECTANGLE_LENGTH && i < GRID_SIZE; i++) {
            for (int j = y; j < y + RECTANGLE_LENGTH && j < GRID_SIZE; j++) {
                grid[i][j] = true;
            }
        }
    }

    private static int countCoveredArea(boolean[][] grid) {
        int count = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    static final class Pair<T, U> {
        private final T x;
        private final U y;

        Pair(T x, U y) {
            this.x = x;
            this.y = y;
        }

        public T x() {
            return x;
        }

        public U y() {
            return y;
        }
    }
}