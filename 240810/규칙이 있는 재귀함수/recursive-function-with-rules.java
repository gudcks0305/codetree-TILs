import java.util.*;
public class Main {
    private static int[] dp;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        dp[1] = 2;
        addRecursive(n);
        for(int i = 1 ; i < dp.length; i++){
            System.out.print(dp[i] +" ");
        }
    }

    public static void addRecursive(int t){
        if(t <= 1) return;
        if(dp[t] != 0) return;
        addRecursive(t/2);
        addRecursive(t-1);
        dp[t] = dp[t/2] + dp[t-1]; 

    }
}