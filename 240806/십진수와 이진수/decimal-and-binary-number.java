import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main {
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine().trim();
        BigInteger result = calculateBinarySum(inputString);
        System.out.println(result.toString(2));
    }

    private static BigInteger calculateBinarySum(String binaryString) {
        // * 17
        BigInteger binary = new BigInteger(binaryString, 2);
        BigInteger seventeen = new BigInteger("17");
        return binary.multiply(seventeen);
    }
}