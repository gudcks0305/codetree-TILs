import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pibo(n));
    }

    public static int pibo(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;
        return pibo(n-2) + pibo(n-1);
    }
}