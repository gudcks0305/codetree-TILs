import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main {
   private static final int RECTANGLE_LENGTH = 10;
    private static final int ORIGIN_WIDTH_X_HEIGHT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine().trim());
        List<Pair<Integer,Integer>> ractanglesPointsXY = new ArrayList<>();
        for (int i = 0 ; i < nums; i++){
            String[] xy = br.readLine().split(" ");
            ractanglesPointsXY.add(new Pair<>(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
        }
        int result = 0;
        for (int i = 0 ; i < nums-1; i++){
            for (int j = i+1 ; j < nums; j++){
                result += getIntersectionArea(ractanglesPointsXY.get(i),ractanglesPointsXY.get(j));
            }
        }
        System.out.println(100 * nums - result);
    }
    // A's area + B's Area - AB's intersection
    public static int getIntersectionArea(Pair<Integer,Integer> r1 , Pair<Integer,Integer> r2){
        // cross x , y
        int x = Math.max(0,Math.min(r1.x + RECTANGLE_LENGTH, r2.x + RECTANGLE_LENGTH) - Math.max(r1.x, r2.x));
        int y = Math.max(0,Math.min(r1.y + RECTANGLE_LENGTH, r2.y + RECTANGLE_LENGTH) - Math.max(r1.y, r2.y));
        return x * y;
    }
    static final class Pair<T, U> {

        private final T x;
        private final U y;

        Pair(
            T x,
            U y
        ) {
            this.x = x;
            this.y = y;
        }

        public T x() {return x;}

        public U y() {return y;}

        }
}