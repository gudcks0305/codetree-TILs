import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
     public static void main(String[] args) throws IOException {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] numbers = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double max = Arrays.stream(numbers).max().getAsDouble();
        double min = Arrays.stream(numbers).min().getAsDouble();
        double kkk = Arrays.stream(numbers).filter(it -> it != max && it != min).findFirst().getAsDouble();
        System.out.printf("%d %d %d", (int) ceil(max), (int) floor(min),round(kkk));
    }
}