import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        
        int count = 1;  // a의 반복 횟수
        String str = a; // 비교할 문자열
        int idx;        // 부분 문자열 인덱스

        for (int i = 0; i < b.length(); i++) {
            // 현재 단어
            String target = String.valueOf(b.charAt(i));

            // 비교할 문자열에 포함되어 있으면 부분문자열 구하기
            if (str.contains(target)) {
                idx = str.indexOf(target) + 1;
                str = str.substring(idx);
            // 없으면 count 증가 후 부분문자열 구하기
            } else {
                idx = a.indexOf(target) + 1;
                str = a.substring(idx);
                count++;
            }
        }

        System.out.println(count);
    }
}