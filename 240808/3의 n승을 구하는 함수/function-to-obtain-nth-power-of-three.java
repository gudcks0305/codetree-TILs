import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(recursiveThree(n));
    }
    public static int recursiveThree(int n){
        if(n == 0) return 1;
        return recursiveThree(n - 1) * 3;
    }
}