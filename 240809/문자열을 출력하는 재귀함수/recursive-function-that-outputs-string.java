import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        printF(n);
    }
    public static void printF(int n){
        if(n == 0) return;
        System.out.println("Coding is my favorite hobby!");
        printF(n-1);
    }
}