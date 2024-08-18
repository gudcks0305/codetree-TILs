import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int min = 11;
        for(int i = 1; i <= s.length(); i++){
            String shift = rightShift(s,i);
            //System.out.println(runLengthEncoding(shift));
            min = Math.min(runLengthEncoding(shift).length() , min);
        }
        System.out.println(min);
    }

    public static String rightShift(String s, int n) {
        int len = s.length();
        n = n % len;  // n이 문자열 길이보다 클 경우 처리
        return s.substring(len - n) + s.substring(0, len - n);
    }

    public static String runLengthEncoding(String s) {
        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        // 마지막 문자 추가
        encoded.append(s.charAt(s.length() - 1)).append(count);

        return encoded.toString();
    }
}