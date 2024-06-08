import java.util.*;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner scanner = new Scanner(System.in);
        String binaryInput = scanner.nextLine();
        BigInteger decimalValue = new BigInteger(binaryInput, 2);
        BigInteger multipliedValue = decimalValue.multiply(BigInteger.valueOf(17));

        // 십진수를 이진수로 변환
        String resultBinary = multipliedValue.toString(2);

        // 결과 출력
        System.out.println(resultBinary);
    }
}