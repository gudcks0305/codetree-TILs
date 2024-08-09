import java.util.*;
import java.io.*;
public class Main {
    
    private static int CUR_NUM = 1000;
    private static int CNT = 0;
    private static int SUM = 0;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        minusTwice(n,2);
    }

    public static void minusTwice(int targetNumber,int minusN){
        if(CUR_NUM <= targetNumber){
            System.out.println(CNT + " " + SUM);
            return;
        }
        CUR_NUM = CUR_NUM - minusN;
        CNT++;
        SUM+=minusN;
        minusTwice(targetNumber,minusN+2);
    }

    

}