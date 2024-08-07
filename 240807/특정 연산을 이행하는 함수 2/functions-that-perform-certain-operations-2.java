import static java.lang.Math.*;

import java.util.*;
import java.io.*;
public class Main {
     public static void main(String[] args) throws IOException {
      
        Scanner scanner = new Scanner(System.in);

        // 세 개의 실수를 입력받기
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        // 입력받은 값을 double형으로 변환
        double num1 = Double.parseDouble(parts[0]);
        double num2 = Double.parseDouble(parts[1]);
        double num3 = Double.parseDouble(parts[2]);

        // 배열에 값을 넣고 순서를 유지
        double[] nums = {num1, num2, num3};
        int[] results = new int[3];

        // 가장 큰 수와 가장 작은 수 찾기
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }

        // 가장 큰 수는 올림, 가장 작은 수는 내림
        results[maxIndex] = (int) Math.ceil(nums[maxIndex]);
        results[minIndex] = (int) Math.floor(nums[minIndex]);

        // 나머지 수는 반올림
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && i != minIndex) {
                results[i] = (int) Math.round(nums[i]);
            }
        }

        // 결과 출력
        System.out.println(results[0] + " " + results[1] + " " + results[2]);
    }
}