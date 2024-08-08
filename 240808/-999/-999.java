import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index999 = -1;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == -999) {
                index999 = i;
                break;
            }
        }
        inputs = Arrays.copyOfRange(inputs, 0, index999);
        Arrays.sort(inputs);
        System.out.println(inputs[inputs.length - 1] + " " + inputs[0]);
    }
}