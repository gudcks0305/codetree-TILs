import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        divid(n);
    }
    public static void divid(int n){
        System.out.print(n + " ");
        if(n == 1) return;
        if(n % 2 == 0) {
            divid(n / 2);
        }else{
            divid(n / 3);
        }
    }
}