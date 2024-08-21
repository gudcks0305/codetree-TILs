import java.util.*;
public class Main {

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        recursive(k,n,"");
    }
    public static void recursive(int k, int n,String s){
        if(n == 0){
            System.out.println(s.substring(1));
            return;
        }
        for(int i = 1; i <= k; i++){
            recursive(k,n-1,s + " " + i);
        }
    }
}