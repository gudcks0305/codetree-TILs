import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int re1 = gcd(a,b);
        int re2 = (a*b) / re1;
        System.out.println(re1 + " " + re2);
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}