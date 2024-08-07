import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        // min mid max
        printGUGUDAN(nums[0],nums[1],nums[2]);
    }

    public static void printGUGUDAN(int start, int removed, int end) {
        for (int i = start; i <= end; i++) {
            if(i == removed) continue;
            printOnceGUGUDAN(i);
        }
    }

    public static void printOnceGUGUDAN(int num) {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d%n", num, i, num * i);
        }
    }
}