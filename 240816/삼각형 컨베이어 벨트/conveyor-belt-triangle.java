import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] first = new int[n];
        int[] second = new int[n];
        int[] third = new int[n];
        for(int i = 0; i < n; i++){
            first[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            second[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            third[i] = sc.nextInt();
        }

        while(t-- > 0){
            // 마지막 row 을 임시 저장해둔다. 
            int firstArrayLastTemp = first[first.length-1];
            int secondArrayLastTemp = second[second.length-1];
            int thirdArrayLastTemp = third[third.length-1];
            // 한칸씩 미루고
            for(int i = n- 1; i > 0; i--){
                first[i] = first[i-1];
            }
            for(int i = n - 1; i > 0; i--){
                second[i] = second[i-1];
            }
            for(int i = n - 1; i > 0; i--){
                third[i] = third[i-1];
            }
            first[0] = thirdArrayLastTemp;
            second[0] = firstArrayLastTemp;
            third[0] = secondArrayLastTemp;
        }
        for(int i = 0 ; i < n; i++){
            System.out.print(first[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < n; i++){
            System.out.print(second[i] + " ");
        }
        System.out.println();

        for(int i = 0 ; i < n; i++){
            System.out.print(third[i] + " ");
        }
    }
}