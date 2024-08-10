import java.util.Scanner;

public class Main {
    private static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        ans(n);
        System.out.println(dp[n]);

    }
    public static void ans(int n) {


        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            int min=100001;

            for(int j=1; j<= i/2; j++) {

                if(j*j == i) { // i가 어떤수의 제곱인 경우는 dp가 1이다
                    min = 1;
                    break;
                }
                else{
                    min = Math.min(min, dp[j]+dp[i-j]);
                }

            }
            dp[i] = min;
            //System.out.println("dp["+i + "] == " + min);
        }

        return;

    }
}