import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] con = new int[2 * n];
        for(int i = 0; i < 2 * n ; i++){
           con[i] = sc.nextInt();
        }
        for(int i = 0; i < t; i++){
            rotate(con);
        }
        for(int i = 0; i < 2 * n; i++){
           System.out.print(con[i]+ " ");
           if(i == n - 1) System.out.println();
        }

    }

    private static void rotate(int[] con){
        int last = con[con.length - 1];
        for (int i = con.length - 1; i > 0; i--) {
            con[i] = con[i - 1];
        }
        con[0] = last;
    }
}