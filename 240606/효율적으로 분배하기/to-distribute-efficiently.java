import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // n = 5a + 3b
        // result = a + b
        // 3result = 3a + 3b
        // n - 3result = 2a 
        int result = findMinimumBoxes(n);
        System.out.println(result);
    }
       public static int findMinimumBoxes(int n) {
        // 최적화된 상자 개수
        int boxCount = 0;
        
        // 5의 용량 상자부터 가능한 최대 개수를 채운다.
        while (n >= 0) {
            if (n % 5 == 0) {
                boxCount += n / 5;
                return boxCount;
            }
            // 5로 나누어 떨어지지 않으면 3의 용량 상자를 사용한다.
            n -= 3;
            boxCount++;
        }
        
        // 정확히 나눌 수 없는 경우 -1을 반환
        return -1;
    }
}