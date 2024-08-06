import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String a = reader.readLine().trim();
        String b = reader.readLine().trim();

        // 가능한 숫자 찾기
        long result = findOriginalNumber(a, b);

        // 결과 출력
        System.out.println(result);
    }

    public static long findOriginalNumber(String a, String b) {
        // 2진수 변형 가능한 숫자 리스트 구하기
        Set<Long> binaryCandidates = generateBinaryCandidates(a);
        // 3진수 변형 가능한 숫자 리스트 구하기
        Set<Long> ternaryCandidates = generateTernaryCandidates(b);

        binaryCandidates.retainAll(ternaryCandidates);
        return binaryCandidates.iterator().next();
    }

    public static Set<Long> generateBinaryCandidates(String binaryString) {
        Set<Long> candidates = new HashSet<>();
        char[] binary = binaryString.toCharArray();

        // 2진수 각 자리 변경
        for (int i = 0; i < binary.length; i++) {
            char original = binary[i];
            // 0 -> 1 또는 1 -> 0
            binary[i] = original == '0' ? '1' : '0';

            // 새로운 숫자 추가
            candidates.add(convertToDecimal(binary, 2));

            // 원상복귀
            binary[i] = original;
        }

        return candidates;
    }

    public static Set<Long> generateTernaryCandidates(String ternaryString) {
        Set<Long> candidates = new HashSet<>();
        char[] ternary = ternaryString.toCharArray();

        // 3진수 각 자리 변경
        for (int i = 0; i < ternary.length; i++) {
            char original = ternary[i];
            // 0 -> 1, 0 -> 2, 1 -> 0, 1 -> 2, 2 -> 0, 2 -> 1
            for (char replacement = '0'; replacement <= '2'; replacement++) {
                if (ternary[i] != replacement) {
                    ternary[i] = replacement;

                    // 새로운 숫자 추가
                    candidates.add(convertToDecimal(ternary, 3));
                }
            }

            // 원상복귀
            ternary[i] = original;
        }

        return candidates;
    }

    public static long convertToDecimal(char[] numberArray, int base) {
        String number = new String(numberArray);
        return Long.parseLong(number, base);
    }

}